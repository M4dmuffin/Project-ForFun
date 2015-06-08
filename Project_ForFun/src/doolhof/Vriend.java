/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Vriend
{

    private Image vriend;

    public Vriend()
    {
        ImageIcon img = new ImageIcon("src/Pics/vriend.png");
        vriend = img.getImage();
    }

    public Image getImageVriend()
    {
        return vriend;
    }

    public void paint(Graphics g, int x, int y)
    {
        g.drawImage(vriend, x * 40, y * 40, null);
    }
}
