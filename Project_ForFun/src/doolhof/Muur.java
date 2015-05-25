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
public class Muur extends JComponent {
    
    private int veldBreedte, veldHoogte;
    private Image muur;

    public Muur() 
    {
      veldBreedte = 40;
      veldHoogte = 40;
      ImageIcon img = new ImageIcon("src/Pics/wall.png");
      muur = img.getImage();
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(muur, veldBreedte, veldHoogte, null);
    }
    
   public Image getMuur() {
        return muur;
    }

}
