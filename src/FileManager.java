import javax.swing.*;
import java.io.*;

public class FileManager {

    private JFrame parent_window;

    public FileManager(JFrame parent_window) {
        this.parent_window = parent_window;
    }

    public String open_file() {
        JFileChooser file_chooser = new JFileChooser();
        int result = file_chooser.showOpenDialog(parent_window);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = file_chooser.getSelectedFile();
            StringBuilder builder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\\n");
                }
                return builder.toString();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent_window, "error_opening_file");
            }
        }
        return null;
    }

    public void save_file(String content) {
        JFileChooser file_chooser = new JFileChooser();
        int result = file_chooser.showSaveDialog(parent_window);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = file_chooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent_window, "error_saving_file");
            }
        }
    }
}
