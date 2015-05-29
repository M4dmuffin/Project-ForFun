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
    private Boolean isBreekbaar;

    public Muur() 
    {

      ImageIcon img = new ImageIcon("src/Pics/wall.png");
      muur = img.getImage();
    }
    
    
   public Image getImageMuur() {
        return muur;
    }

    public void setIsBreekbaar(Boolean isBreekbaar)
    {
        this.isBreekbaar = isBreekbaar;
    }

    public Boolean getIsBreekbaar()
    {
        return isBreekbaar;
    }
    
}
