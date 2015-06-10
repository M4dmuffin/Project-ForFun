/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Spin extends Vijand implements KorsteRoute
{
    private Image spinImage;
    private BeweegRichting richting;
    
    private final int MAX_WAARDE = 1000;
    private int kortsteRoute;
    private int aantalKolRij;
    private Veld[][] veldLijst;
    public String[][] oplossing;
    public String[][] doolhof;
    
    public Spin()
    {
        veldX = 19;
        veldY = 13;
//        ImageIcon img = new ImageIcon("src/Pics/spider.png");
//        spinImage = img.getImage();
        doolhof = new String[21][21];
        richting = BeweegRichting.omlaag;
        setImage();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(spinImage, veldX * 40, veldY * 40, null);
    }

    @Override
    public void move()
    {
        losOp(veldY, veldX);
        for (int i = 0; i < oplossing.length; i++)
        {
            String beweging = oplossing[veldY - 1][veldX];
            if(beweging.equals("*") || beweging.equals("P"))
            {
                veldY -= 1;
                this.richting = BeweegRichting.omhoog;
                setImage();
                break;
            }
            beweging = oplossing[veldY + 1][veldX];
            if(beweging.equals("*") || beweging.equals("P"))
            {
                veldY += 1;
                this.richting = BeweegRichting.omlaag;
                setImage();
                break;
            }
            beweging = oplossing[veldY][veldX - 1];
            if(beweging.equals("*") || beweging.equals("P"))
            {
                veldX -= 1;
                this.richting = BeweegRichting.links;
                setImage();
                break;
            }
            beweging = oplossing[veldY][veldX + 1];
            if(beweging.equals("*") || beweging.equals("P"))
            {
                veldX += 1;
                this.richting = BeweegRichting.rechts;
                setImage();
                break;
            }
            
        }
    }

    
    @Override
    public void terugOmzetten()
    {  
        for (int y = 0; y < aantalKolRij; y++)
        {
            for (int x = 0; x < aantalKolRij; x++)
            {

                Veld huidig = veldLijst[y][x];
                if (huidig.getMuur() != null)
                {
                    doolhof[y][x] = "M";
                }
                
                //negeer vriend object, beschouw vriend als muur
                if (huidig.getVriend() != null)
                {
                    doolhof[y][x] = "M";
                }

                if (huidig.getGang() != null)
                {
                    doolhof[y][x] = "G";
                }
            }
        }
    }

    @Override
    public void copyDoolhof()
    {
        oplossing = new String[aantalKolRij][aantalKolRij];
        for (int x = 0; x < aantalKolRij; x++)
        {
            System.arraycopy(doolhof[x], 0, oplossing[x], 0, aantalKolRij);
        }
    }

    @Override
    public void losOp(int x, int y)
    {
        veldLijst = speler.getLevel().getVeldLijst();
        kortsteRoute = MAX_WAARDE;
        aantalKolRij = veldLijst.length;
        
        terugOmzetten();
        doolhof[speler.getVeldY()][speler.getVeldX()] = "P";
        
        kortsteRoute = MAX_WAARDE;

        if (stap(x, y, 0) != MAX_WAARDE)
        {
            oplossing[veldY][veldX] = "S";
        }
    }

    @Override
    public int stap(int y, int x, int aantalStappen)
    {
        // Zoek Speler
        if ("P".equals(doolhof[y][x]))
        {
            kortsteRoute = aantalStappen;
            copyDoolhof();
            return aantalStappen;
        }

        // Deze stap gaat niet omdat de stap naar een Muur is of omdat het pad al is gemarkeerd
        if ("M".equals(doolhof[y][x]) || "*".equals(doolhof[y][x]))
        {
            return MAX_WAARDE;
        }
        // dit pad (van vriend naar begin) is langer dan het al eerder gevonden pad (van begin naar vriend)
        if (aantalStappen == kortsteRoute)
        {
            return MAX_WAARDE;
        }

        //markeer deze stap (van het pad) als oplossing
        doolhof[y][x] = "*";
        int uitkomst = MAX_WAARDE;

        int nieuweUitkomst = MAX_WAARDE;

        // omhoog
        nieuweUitkomst = stap(y - 1, x, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // omlaag
        nieuweUitkomst = stap(y + 1, x, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // links
        nieuweUitkomst = stap(y, x - 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // rechts
        nieuweUitkomst = stap(y, x + 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // maak de markering ongedaan
        doolhof[y][x] = "G";

        if (uitkomst < MAX_WAARDE)
        {
            return uitkomst;
        }

        return MAX_WAARDE;
    }
    
    private void setImage()
    {
        String plaatje = "";
        
            switch (richting)
            {
                case omhoog: {plaatje = "spiderOmhoog";break;}
                case rechts: {plaatje = "spiderRechts";break;}
                case omlaag: {plaatje = "spider";break;}
                case links: {plaatje = "spiderLinks";break;}
            }
       
        
        ImageIcon img = new ImageIcon("src/Pics/" + plaatje + ".png");
        spinImage = img.getImage();
    }
    
}
