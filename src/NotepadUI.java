import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NotepadUI {

    private JFrame main_window;
    private JTextArea text_area;
    private JComboBox<String> font_size_box;
    private JToggleButton theme_toggle;
    private FileManager file_manager;
    private JPanel top_panel;
    private boolean is_dark_theme = false;

    public void create_and_show_ui() {
        main_window = new JFrame("simple_notepad");
        text_area = new JTextArea();
        text_area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        text_area.setLineWrap(true);
        text_area.setWrapStyleWord(true);

        JButton open_button = new JButton("open");
        JButton save_button = new JButton("save");
        JButton clear_button = new JButton("clear");

        font_size_box = new JComboBox<>(new String[] { "12", "14", "16", "18", "20", "24", "28" });
        theme_toggle = new JToggleButton("light_mode");

        top_panel = new JPanel();
        top_panel.add(open_button);
        top_panel.add(save_button);
        top_panel.add(clear_button);
        top_panel.add(new JLabel("font:"));
        top_panel.add(font_size_box);
        top_panel.add(theme_toggle);

        JScrollPane scroll_panel = new JScrollPane(text_area);

        main_window.add(top_panel, BorderLayout.NORTH);
        main_window.add(scroll_panel, BorderLayout.CENTER);

        file_manager = new FileManager(main_window);

        open_button.addActionListener(this::handle_open);
        save_button.addActionListener(this::handle_save);
        clear_button.addActionListener(this::handle_clear);
        font_size_box.addActionListener(this::handle_font_change);
        theme_toggle.addActionListener(this::handle_theme_toggle);

        set_theme(false);

        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.pack();
        main_window.setMinimumSize(new Dimension(600, 400));
        main_window.setLocationRelativeTo(null);
        main_window.setVisible(true);
    }

    private void handle_open(ActionEvent e) {
        String content = file_manager.open_file();
        if (content != null) {
            text_area.setText(content);
        }
    }

    private void handle_save(ActionEvent e) {
        file_manager.save_file(text_area.getText());
    }

    private void handle_clear(ActionEvent e) {
        text_area.setText("");
    }

    private void handle_font_change(ActionEvent e) {
        String size_text = (String) font_size_box.getSelectedItem();
        if (size_text != null) {
            int size = Integer.parseInt(size_text);
            Font old_font = text_area.getFont();
            text_area.setFont(new Font(old_font.getFamily(), Font.PLAIN, size));
        }
    }

    private void handle_theme_toggle(ActionEvent e) {
        is_dark_theme = theme_toggle.isSelected();
        set_theme(is_dark_theme);
    }

    private void set_theme(boolean dark) {
        Color bg;
        Color fg;
        if (dark) {
            bg = new Color(30, 30, 30);
            fg = new Color(230, 230, 230);
            theme_toggle.setText("dark_mode");
        } else {
            bg = Color.WHITE;
            fg = Color.BLACK;
            theme_toggle.setText("light_mode");
        }

        text_area.setBackground(bg);
        text_area.setForeground(fg);
        top_panel.setBackground(bg);

        for (Component c : top_panel.getComponents()) {
            c.setBackground(bg);
            c.setForeground(fg);
        }

        main_window.getContentPane().setBackground(bg);
    }
}
