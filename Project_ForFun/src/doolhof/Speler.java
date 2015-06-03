/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Speler extends JComponent
{
    private int veldX, veldY;
    private Image spelerImage;
    private Level level;
    private int richting;
    private int stappen;
    private Bazooka bazooka;
    private Helper helper;
    
    public Speler() 
    {
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
        richting = 2;
        setImage();  
        stappen = 0;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(getSpelerImage(), veldX * 40, veldY * 40, null);
    }
       
    public void reset()
    {
        if(helper != null)
        {
            helper.isGevonden = false;
            helper = null;
        }
        if(bazooka != null)
        {
            bazooka.isGevonden = false;
            bazooka = null;
        }
        veldX = 1; 
        veldY = 1; 
        stappen = 0;
        richting = 2;
    }
    
    // schiet de bazooka
    public void schietBazooka()
    {
        if(bazooka != null)
        {
            bazooka.schieten(veldX, veldY, richting, level);
            bazooka = null;
        }
    }
    
    // controleert of de speler in aanraking komt met de objecten: Helper, ValsSpeler en Bazooka
    public void checkObject()
    {
        if(level.getVriend(veldX, veldY) == null)
        {
           Item item = new Item();
            item = level.getGang(veldX, veldY).getItem();
            if(item != null)
            {
                if(item instanceof Helper)
                {
                    helper = (Helper)item;
                    helper.losOp(veldY, veldX);  
                    helper.isGevonden = true;  
                    level.getGang(veldX, veldY).setItem(null);                 
                }
                if(item instanceof ValsSpeler)
                {
                    ValsSpeler vals = (ValsSpeler)item;  
                    stappen -= vals.getStappen();
                    level.getGang(veldX, veldY).setItem(null);
                }
                if(item instanceof Bazooka)
                {
                    bazooka = (Bazooka)item;
                    bazooka.isGevonden = true;
                    level.getGang(veldX, veldY).setItem(null);
                }
            } 
        }
    }
    
    // de beweeg methode van de speler
    public void move(BeweegRichting richting)
    {
        if(richting.equals(BeweegRichting.omhoog))
        {
            int omhoog = veldY - 1;
            this.richting = 0;
            if(level.getMuur(veldX, omhoog) == null)
            {
                veldY = omhoog;
                stappen++;
            }
            setImage();
            checkObject();
        }
        if(richting.equals(BeweegRichting.omlaag))
        {
            int omlaag = veldY + 1;
            this.richting = 2;
            if(level.getMuur(veldX, omlaag) == null)
            {
                veldY = omlaag;
                stappen++;
            }
            setImage();
            checkObject();
        }
        if(richting.equals(BeweegRichting.links))
        {
            int links = veldX - 1;
            this.richting = 3;
            if(level.getMuur(links, veldY) == null)
            {
                veldX = links;
                stappen++;
            }
            setImage();
            checkObject();
        }
        if(richting.equals(BeweegRichting.rechts))
        {
            int rechts = veldX + 1;
            this.richting = 1;
            if(level.getMuur(rechts, veldY) == null)
            {
                veldX = rechts;
                stappen++;
            }
            setImage();
            checkObject();
        }
    }
    
    public Image getSpelerImage() 
    {
        return spelerImage;
    }
    
    public int getVeldX() 
    {
        return veldX;
    }

    public int getVeldY() 
    {
        return veldY;
    }
    
    public void setLevel(Level level)
    {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
    
    // zorgt dat het plaatje van de speler mee veranderd met de beweegrichting van de speler
    public void setImage()
    {
        String plaatje = "";
        if(bazooka == null)
        {
            
            if(richting == 0)
            {
                plaatje = "playerHoog";
            }
            if(richting == 1)
            {
                plaatje = "playerRechts";
            }
            if(richting == 2)
            {
                plaatje = "player";
            }
            if(richting == 3)
            {
                plaatje = "playerLinks";
                
            }
        }
        else
        {
            if(richting == 0)
            {
                plaatje = "playerHoogBazooka";
            }
            if(richting == 1)
            {
                plaatje = "playerRechtsBazooka";
            }
            if(richting == 2)
            {
                plaatje = "playerBazooka";
            }
            if(richting == 3)
            {
                plaatje = "playerLinksBazooka";
            }
        }
        ImageIcon img = new ImageIcon("src/Pics/" + plaatje + ".png");
        spelerImage = img.getImage();
        
    }

    public int getStappen()
    {
        return stappen;
    }

    public Helper getHelper() {
        return helper;
    }
    
    
    
    
}
