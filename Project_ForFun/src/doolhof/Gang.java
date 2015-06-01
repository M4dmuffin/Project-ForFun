/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author HP Pavillion
 */
public class Gang extends JComponent {


    private Image gang;
    private Item item;
    private Veld veld;
    
    public Gang()
    {
      ImageIcon img = new ImageIcon("src/Pics/street.png");
      gang = img.getImage();    
    }

    
   public Image getImageGang() {
        return gang;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Item getItem()
    {
        return item;
    }

    public Veld getVeld()
    {
        return veld;
    }

    public void setVeld(Veld veld)
    {
        this.veld = veld;
    }
    
}
