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
public class ValsSpeler extends Item {
    
    private int veldX, veldY;

    public ValsSpeler() 
    {
        ImageIcon img = new ImageIcon("src/Pics/valsspeler.png");
        itemImage = img.getImage();
        
        
        veldX = 5; //start x positie valsspeler 
        veldY = 9; //start y positie valsspeler 
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
