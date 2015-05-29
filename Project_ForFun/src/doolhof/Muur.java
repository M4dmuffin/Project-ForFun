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
public class Muur{
    
    private Image muur;

    public Muur() 
    {

      ImageIcon img = new ImageIcon("src/Pics/wall.png");
      muur = img.getImage();
    }
    
    
   public Image getImageMuur() {
        return muur;
    }

}
