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
public class Bazooka extends Item {
    
    private int veldX, veldY;

    public Bazooka() 
    {
        ImageIcon img = new ImageIcon("src/Pics/bazooka.png");
        itemImage = img.getImage();
        veldX = 8; //start x positie bazooka 
        veldY = 1; //start y positie bazooka 
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
