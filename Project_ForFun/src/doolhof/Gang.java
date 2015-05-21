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

    private int veldX, veldY;
    private Image gang;

 
    
    public Gang()
    {
      veldX = 40;
      veldY = 40;
      ImageIcon img = new ImageIcon("C:/School/Blok D/Project/Doolhof/src/Pics/street.png");
      gang = img.getImage();
             
    }
    
    public void paint(Graphics g) {
        g.drawImage(gang, veldX, veldY, null);
    }
    
   public Image getGang() {
        return gang;
    }
    
    
    
}
