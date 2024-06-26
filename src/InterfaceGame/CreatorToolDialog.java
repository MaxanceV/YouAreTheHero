package InterfaceGame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainLaunch.MainGame;
import Representation.node.ANode;
import Univers.TPersonnage;

public class CreatorToolDialog {
	final static String SETTING_ICON = "images/setting.png";
	final static String STAT_BUTTON_ICON = "images/statbutton.png";
	final static String HEALTH_ITEM = "images/coeur.png";
	final static String DEFAULT_DECORE_IMAGE = "images/decore.png";
	private static final int MAX_IMAGE_WIDTH = 800;  // Change to your desired max width
	private static final int MAX_IMAGE_HEIGHT = 400; // Change to your desired max height
	
	public static String insertLineBreaks(String input, int lineLength) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int length = input.length();

        while (start < length) {
            int end = Math.min(start + lineLength, length);
            if (end == length) {
                result.append(input.substring(start));
                break;
            }

            // Rechercher le dernier espace avant de couper
            int lastSpace = input.lastIndexOf(' ', end);
            if (lastSpace > start) {
                result.append(input, start, lastSpace).append("<br>");
                start = lastSpace + 1;  // Sauter l'espace
            } else {
                result.append(input, start, end).append("<br>");
                start = end;
            }
        }

        return result.toString();
    }
	
	public static String stringDescriptionNodeFormat(String string) {
		string.replace("\n", "<br>");
		string = insertLineBreaks(string, 130);
		return string;
	}
	
	public static Image getScaledImage(Image srcImg) {
	    int srcWidth = srcImg.getWidth(null);
	    int srcHeight = srcImg.getHeight(null);

	    if (srcWidth <= MAX_IMAGE_WIDTH && srcHeight <= MAX_IMAGE_HEIGHT) {
	        return srcImg;
	    }

	    float widthRatio = (float) MAX_IMAGE_WIDTH / srcWidth;
	    float heightRatio = (float) MAX_IMAGE_HEIGHT / srcHeight;
	    float ratio = Math.min(widthRatio, heightRatio);

	    int newWidth = Math.round(srcWidth * ratio);
	    int newHeight = Math.round(srcHeight * ratio);

	    Image scaledImg = srcImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	    return scaledImg;
	}
	
	public static JLabel createBackgroundLabel(ANode node) {
        return createBackgroundLabel("images/" + node.getId() + ".png");
    }
           
	
	public static JLabel createBackgroundLabel(String link) {
		ImageIcon backgroundIcon;
		try {	
	        // Chargement de l'image spécifique
	        backgroundIcon = new ImageIcon(CreatorToolDialog.class.getClassLoader().getResource(link));
			// Vérifier si l'image a été chargée correctement
	        if (backgroundIcon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
	            throw new RuntimeException("Image not loaded");
	        }
	
	        // Redimensionner l'image si nécessaire
	        Image img = backgroundIcon.getImage();
	        Image scaledImg = getScaledImage(img);
	        backgroundIcon = new ImageIcon(scaledImg);
	    } catch (Exception e) {
	        // En cas d'erreur, charger l'image par défaut sans redimensionnement
	        backgroundIcon = new ImageIcon(CreatorToolDialog.class.getClassLoader().getResource(DEFAULT_DECORE_IMAGE));
	    }
	
	    // Panel principal avec l'image de fond
	    return new JLabel(backgroundIcon);
	}
	public static Image getIconOfDialog() {
		ImageIcon icon = new ImageIcon(CreatorToolDialog.class.getClassLoader().getResource("images/bouclier.png"));
        return icon.getImage();
	}
	public static JPanel getSettingsAndStatsButtons(JDialog dialog, TPersonnage player) {
	    // Panel principal pour aligner les boutons verticalement
	    JPanel verticalButtonPanel = new JPanel();
	    verticalButtonPanel.setLayout(new BoxLayout(verticalButtonPanel, BoxLayout.Y_AXIS));
	    verticalButtonPanel.setOpaque(false);

	    // Bouton des paramètres
	    JButton settingsButton = new JButton(new ImageIcon(dialog.getClass().getClassLoader().getResource(SETTING_ICON)));
	    settingsButton.setContentAreaFilled(false);
	    settingsButton.setBorderPainted(false);
	    settingsButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            MainGame.startOptionsDialog(dialog);
	        }
	    });
	    verticalButtonPanel.add(settingsButton);

	    // Bouton des statistiques
	    JButton statsButton = new JButton(new ImageIcon(dialog.getClass().getClassLoader().getResource(STAT_BUTTON_ICON)));
	    statsButton.setContentAreaFilled(false);
	    statsButton.setBorderPainted(false);
	    statsButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            MainGame.startStatisticsDialog(dialog, player);
	        }
	    });
	    verticalButtonPanel.add(statsButton);

	    return verticalButtonPanel;
	}

}
