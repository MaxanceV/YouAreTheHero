package MainLaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import InterfaceGame.InterfaceCreatorTool;
import Univers.TPlayer;

public class SaveManager {
	
	public static void savePlayer(TPlayer player) {
        File saveDir = new File("saves");
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        File saveFile = new File(saveDir, player.getNom() + "_save.ser");
        try (FileOutputStream fileOut = new FileOutputStream(saveFile);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(player);
            System.out.println("Player saved in " + saveFile.getAbsolutePath());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
	public static TPlayer loadPlayer(String playerName) {
        TPlayer player = null;
        File saveFile = new File("saves/" + playerName + "_save.ser");
        if (!saveFile.exists()) {
            System.out.println("Save file not found for player: " + playerName);
            return null;
        }

        try (FileInputStream fileIn = new FileInputStream(saveFile);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            player = (TPlayer) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("TPlayer class not found");
            c.printStackTrace();
        }
        return player;
    }
	
    public static void deleteSaveOfPlayer(String playerName) {
        File saveFile = new File("saves/" + playerName + "_save.ser");
        if (saveFile.exists()) {
            if (saveFile.delete()) {
                System.out.println("Save file deleted for player: " + playerName);
            } else {
                System.out.println("Failed to delete save file for player: " + playerName);
            }
        } else {
            System.out.println("Save file not found for player: " + playerName);
        }
    }
}

