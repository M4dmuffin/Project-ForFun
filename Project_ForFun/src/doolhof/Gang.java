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

    private int veldBreedte, veldHoogte;
    private Image gang;

 
    
    public Gang()
    {
      veldBreedte = 40;
      veldHoogte = 40;
      ImageIcon img = new ImageIcon("src/Pics/street.png");
      gang = img.getImage();
             
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(gang, veldBreedte, veldHoogte, null);
    }
    
   public Image getGang() {
        return gang;
    }
    
    
    
}
