import javax.swing.SwingUtilities;

import InterfaceGame.InterfaceGame;

public class MainGame {
	
	public static void startGame() {
		 SwingUtilities.invokeLater(() -> {
	        	InterfaceGame frame = new InterfaceGame();
	            frame.setVisible(true);
	            
	        });
	}//test
	
    public static void main(String[] args) {

    startGame();
       
    }
}
