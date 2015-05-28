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
public class Helper extends Item {
    
    private int veldX, veldY;
    

    public Helper() 
    {
        ImageIcon img = new ImageIcon("src/Pics/helper.png");
        itemImage = img.getImage();
        
        
        veldX = 1; //start x positie helper 
        veldY = 5; //start y positie helper 
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
