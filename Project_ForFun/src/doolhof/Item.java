/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Item extends JPanel{
    protected Image itemImage;
    protected Gang gang;
    protected boolean isGevonden;
    
    public Image getItemImage() 
    {
        return itemImage;
    }

    public Gang getGang()
    {
        return gang;
    }

    public void setGang(Gang gang)
    {
        this.gang = gang;
    }

    
}
