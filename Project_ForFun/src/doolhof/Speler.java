/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Speler 
{
    private int veldX, veldY;
    private Image spelerImage;

    public Speler() 
    {
        ImageIcon img = new ImageIcon("src/Pics/player.png");
        spelerImage = img.getImage();
        
        
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
    }
    
    public void move(int locX, int locY)
    {
        veldX += locX;
        veldY += locY;
    }
    
    public Image getSpelerImage() 
    {
        return spelerImage;
    }
    
    public int getVeldX() 
    {
        return veldX;
    }

    public int getVeldY() 
    {
        return veldY;
    }
    
    
    
}
