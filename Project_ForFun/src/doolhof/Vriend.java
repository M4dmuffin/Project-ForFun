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

    private int veldX, veldY;
    private Image vriend;

    public Vriend() 
    {
      veldX = 40;
      veldY = 40;
      ImageIcon img = new ImageIcon("C:\\Users\\HP Pavillion\\Desktop\\Kevin\\School\\Netbeans\\Doolhof\\Pics\\vriend.png");
      vriend = img.getImage();    
    }
    
    public void paint(Graphics g) {
        g.drawImage(vriend, veldX, veldY, null);
    }
    
   public Image getVriend() {
        return vriend;
    }
}
