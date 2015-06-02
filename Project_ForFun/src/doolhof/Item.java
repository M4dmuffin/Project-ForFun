/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;

/**
 *
 * @author HP Pavillion
 */
public class Item {
    protected Image itemImage;
    protected Gang gang;
    
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
