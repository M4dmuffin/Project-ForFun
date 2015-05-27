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
public class Vriend extends JComponent {

    private int veldBreedte, veldHoogte;
    private Image vriend;

    public Vriend() 
    {
      veldBreedte = 40;
      veldHoogte = 40;
      ImageIcon img = new ImageIcon("src/Pics/vriend.png");
      vriend = img.getImage();    
    }
    
    public void paint(Graphics g) {
        g.drawImage(vriend, veldBreedte, veldHoogte, null);
    }
    
   public Image getImageVriend() {
        return vriend;
    }
}
