/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Lars
 */
public class Kogel
{

    private Image kogel;

    public Kogel()
    {
        ImageIcon img = new ImageIcon("src/Pics/kogel.png");
        kogel = img.getImage();
    }

    public void paint(Graphics g)
    {
        g.drawImage(kogel, 40, 40, null);
    }
}
