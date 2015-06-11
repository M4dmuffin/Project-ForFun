/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author HP Pavillion
 */
public class Speler extends JComponent
{

    private int veldX, veldY;
    private Image spelerImage;
    private Level level;
    private BeweegRichting richting;
    private int stappen;
    private Bazooka bazooka;
    private Helper helper;

    public Speler()
    {
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
        richting = BeweegRichting.omlaag;
        stappen = 0;
        setImage();

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(spelerImage, veldX * 40, veldY * 40, null);
    }

    public void reset()
    {
        veldX = 1;
        veldY = 1;
        stappen = 0;
        richting = BeweegRichting.omlaag;
        if (helper != null)
        {
            helper.isGevonden = false;
            helper = null;
        }
        if (bazooka != null)
        {
            bazooka.isGevonden = false;
            bazooka = null;
        }setImage();
        
    }

    // schiet de bazooka
    public void schietBazooka()
    {
        if (bazooka != null)
        {
            bazooka.schieten(veldX, veldY, richting, level);
            bazooka = null;
            setImage();
        }
    }
    
    // controleert of de speler in aanraking komt met de objecten: Helper, ValsSpeler en Bazooka
    private void pakItem()
    {
        if (level.getVriend(veldX, veldY) == null)
        {
            Item item;
            item = level.getGang(veldX, veldY).getItem();
            if (item != null)
            {
                if (item instanceof Helper)
                {
                    helper = (Helper) item;
                    helper.losOp(veldY, veldX);
                    helper.isGevonden = true;
                    level.getGang(veldX, veldY).setItem(null);
                }
                if (item instanceof ValsSpeler)
                {
                    ValsSpeler vals = (ValsSpeler) item;
                    stappen -= vals.getStappen();
                    level.getGang(veldX, veldY).setItem(null);
                }
                if (item instanceof Bazooka)
                {
                    bazooka = (Bazooka) item;
                    bazooka.isGevonden = true;
                    setImage();
                    level.getGang(veldX, veldY).setItem(null);
                }
            }
        }
    }

    // zorgt dat het plaatje van de speler mee veranderd met de beweegrichting van de speler
    private void setImage()
    {
        String plaatje = "";
        if (bazooka == null)
        {
            switch (richting)
            {
                case omhoog: {plaatje = "playerHoog";break;}
                case rechts: {plaatje = "playerRechts";break;}
                case omlaag: {plaatje = "player";break;}
                case links: {plaatje = "playerLinks";break;}
            }
        } 
        else
        {
            switch (richting)
            {
                case omhoog: {plaatje = "playerHoogBazooka";break;}
                case rechts: {plaatje = "playerRechtsBazooka";break;}
                case omlaag: {plaatje = "playerBazooka";break;}
                case links: {plaatje = "playerLinksBazooka";break;}
            }
        }
        ImageIcon img = new ImageIcon("src/Pics/" + plaatje + ".png");
        spelerImage = img.getImage();
    }

    // de beweeg methode van de speler
    public void move(BeweegRichting richting)
    {
        
        if (richting.equals(BeweegRichting.omhoog))
        {
            int omhoog = veldY - 1;
            this.richting = BeweegRichting.omhoog;
            if (level.getMuur(veldX, omhoog) == null)
            {
                veldY = omhoog;
                maakStap();
            }
            pakItem();
            setImage();
        }
        if (richting.equals(BeweegRichting.omlaag))
        {
            int omlaag = veldY + 1;
            this.richting = BeweegRichting.omlaag;
            if (level.getMuur(veldX, omlaag) == null)
            {
                veldY = omlaag;
                maakStap();
            }
            pakItem();
            setImage();
        }
        if (richting.equals(BeweegRichting.links))
        {
            int links = veldX - 1;
            this.richting = BeweegRichting.links;
            if (level.getMuur(links, veldY) == null)
            {
                veldX = links;
                maakStap();
            }
            pakItem();
            setImage();
        }
        if (richting.equals(BeweegRichting.rechts))
        {
            int rechts = veldX + 1;
            this.richting = BeweegRichting.rechts;
            if (level.getMuur(rechts, veldY) == null)
            {
                veldX = rechts;
                maakStap();
            }
            pakItem();
            setImage();
        }
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

    public Level getLevel()
    {
        return level;
    }

    public int getStappen()
    {
        return stappen;
    }

    public Helper getHelper()
    {
        return helper;
    }
    
    private void maakStap()
    {
        stappen++;
    }

    //Alle methodes achter deze regel worden gebruik bij testen (Junit)
    public void setVeldX(int veldX)
    {
        this.veldX = veldX;
    }

    public void setVeldY(int veldY)
    {
        this.veldY = veldY;
    }
    
    public Bazooka getBazooka()
    {
        return bazooka;
    }
    
    public void setStappen(int stappen)
    {
        this.stappen = stappen;
    }
    
}
