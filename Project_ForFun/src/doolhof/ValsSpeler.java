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
    private int stappen;
    
    public ValsSpeler() 
    {
        ImageIcon img = new ImageIcon("src/Pics/valsspeler.png");
        itemImage = img.getImage();   
    }

    public int getStappen()
    {
        return stappen;
    }

    public void setStappen(int stappen)
    {
        this.stappen = stappen;
    }
}
