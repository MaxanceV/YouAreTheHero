import javax.swing.SwingUtilities;

import InterfaceGame.MainMenu;

public class MainGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	MainMenu frame = new MainMenu();
            frame.setVisible(true);
        });
    }
}
