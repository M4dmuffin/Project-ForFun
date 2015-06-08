/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Bazooka extends Item
{

    public Bazooka()
    {
        ImageIcon img = new ImageIcon("src/Pics/bazooka.png");
        itemImage = img.getImage();
    }

    public void schieten(int veldX, int veldY, int richting, Level level)
    {
        int x = veldX;
        int y = veldY;

        boolean isGeraakt = false;
        while (isGeraakt == false)
        {
            switch (richting)
            {
                case 0: {y--;break;}
                case 1: {x++;break;}
                case 2: {y++;break;}
                case 3: {x--;break;}
            }

            if (level.getMuur(x, y) != null && level.getMuur(x, y).getIsBreekbaar() == true)
            {
                level.getEenVeld(x, y).setMuur(null);
                gang = new Gang();
                level.getEenVeld(x, y).setGang(gang);
                isGeraakt = true;
            }
            if (level.getMuur(x, y) != null && level.getMuur(x, y).getIsBreekbaar() == false)
            {
                isGeraakt = true;
            }
        }
    }

    @Override
    public void paint(Graphics g, int x, int y)
    {
        g.drawImage(itemImage, x * 40, y * 40, null);
    }
}
