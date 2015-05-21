/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Level {

    private final int AANTAL_KOLOMMEN_LEVEL;
    private Scanner levelOpbouw;
    private Image gang, muur, vriend;
    private String[] level_1;

    public Level() {
        AANTAL_KOLOMMEN_LEVEL = 21;
        level_1 = new String[AANTAL_KOLOMMEN_LEVEL];
        openFile();
        readFile();
        closeFile();
    }

    public Image getGang()
    {
        return gang;
    }
    
    public Image getMuur()
    {
        return muur;
    }
    
    public Image getVriend()
    {
        return vriend;
    }
    
    
    
    private void openFile() {
        try {
            levelOpbouw = new Scanner(new File("C:\\Users\\HP Pavillion\\Desktop\\Kevin\\School\\Netbeans\\Doolhof\\Levels\\Level1.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Error: Map niet gevonden");
        }
    }

    private void readFile() {
        while (levelOpbouw.hasNext()) {
            for (int i = 0; i < AANTAL_KOLOMMEN_LEVEL; i++) {
                level_1[i] = levelOpbouw.next();
            }
        }

    }

    private void closeFile() {
        levelOpbouw.close();
    }
    
    public String getLevel_1(int x, int y)
    {
        String index = level_1[y].substring(x, x + 1);
        return index;
    }
    
    
    public int getHOOGTE_LEVEL() {
        return AANTAL_KOLOMMEN_LEVEL;
    }
}
