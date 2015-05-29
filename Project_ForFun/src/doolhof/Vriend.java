/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

//import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
//import javax.swing.JComponent;
//import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Vriend {
    private Image vriend;

    public Vriend() 
    {

      ImageIcon img = new ImageIcon("src/Pics/vriend.png");
      vriend = img.getImage();    
    }

   public Image getImageVriend() {
        return vriend;
    }
   
}
