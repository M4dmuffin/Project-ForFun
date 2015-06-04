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
public class Gang extends JComponent
{

    private Image gang;
    private Item item;

    public Gang()
    {
        ImageIcon img = new ImageIcon("src/Pics/street.png");
        gang = img.getImage();
    }

    public void Paint(Graphics g, int x, int y)
    {
        g.drawImage(gang, x * 40, y * 40, null);
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Item getItem()
    {
        return item;
    }

}
