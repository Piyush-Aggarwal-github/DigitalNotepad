import javax.swing.*;

public class SimpleNotepad {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadUI app = new NotepadUI();
            app.create_and_show_ui();
        });
    }
}
