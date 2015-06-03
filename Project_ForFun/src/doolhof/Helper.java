/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Helper extends Item {

    private final int MAX_WAARDE = 1000;
    private int kortsteRoute;
    private int aantalKolRij;
    private Veld[][] veldLijst;
    public String[][] oplossing;
    public String[][] doolhof;

    public Helper() {
        ImageIcon img = new ImageIcon("src/Pics/helper.png");
        itemImage = img.getImage();
        oplossing = null;
        doolhof = new String[21][21]; // aantal kolommen en rijen van het level: 21 bij 21
    }

    // zet de veldlijst terug naar een Stringlijst
    public void terugOmzetten() {
        for (int y = 0; y < aantalKolRij; y++) {
            for (int x = 0; x < aantalKolRij; x++) {

                Veld huidig = veldLijst[y][x];
                if (huidig.getMuur() != null) 
                {
                    doolhof[y][x] = "M";
                }

                if (huidig.getVriend() != null) 
                {
                    doolhof[y][x] = "V";
                }
                
                if (huidig.getGang() != null) 
                {
                    doolhof[y][x] = "G";
                }
            }
        }
    }
    
    // Maakt een copy van de Stringlijst zodat deze kan dienen als oploslijst
    private void copyDoolhof() {
        oplossing = new String[aantalKolRij][aantalKolRij];
        for (int x = 0; x < aantalKolRij; x++) {
            for (int y = 0; y < aantalKolRij; y++) {
                oplossing[x][y] = doolhof[x][y];
            }
        }
    }

    // pak de start locatie x,y en los doolhof op
    public void losOp(int x, int y) {
        kortsteRoute = MAX_WAARDE;
        aantalKolRij = veldLijst.length;
        for (int q = 0; q < aantalKolRij; q++) {
            for (int r = 0; r < aantalKolRij; r++) {
                if (veldLijst[q][r].getVriend() != null) {
                    doolhof[q][r] = "V";
                }
            }
        }
        terugOmzetten();
        kortsteRoute = MAX_WAARDE;

        if (stap(x, y, 0) != MAX_WAARDE) {
            oplossing[x][y] = "S";
        }
    }

    // Deze recurieve methode zet de stappen terug van vriend naar begin
    public int stap(int x, int y, int aantalStappen) {

        // Zoek vriend
        if ("V".equals(doolhof[x][y])) {
            kortsteRoute = aantalStappen;
            this.copyDoolhof();
            return aantalStappen;
        }

        // Deze stap gaat niet omdat de stap naar een Muur is of omdat het pad al is gemarkeerd
        if ("M".equals(doolhof[x][y]) || "*".equals(doolhof[x][y])) {
            return MAX_WAARDE;
        }
        // dit pad (van vriend naar begin) is langer dan het al eerder gevonden pad (van begin naar vriend)
        if (aantalStappen == kortsteRoute) {
            return MAX_WAARDE;
        }

        //markeer deze stap (van het pad) als oplossing
        doolhof[x][y] = "*";
        int uitkomst = MAX_WAARDE;

        int nieuweUitkomst = MAX_WAARDE;

        // omhoog
        nieuweUitkomst = stap(x, y - 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst) 
        {
            uitkomst = nieuweUitkomst;
        }
        
        // omlaag
        nieuweUitkomst = stap(x, y + 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst) {
            uitkomst = nieuweUitkomst;
        }

        // links
        nieuweUitkomst = stap(x - 1, y, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst) {
            uitkomst = nieuweUitkomst;
        }

        // rechts
        nieuweUitkomst = stap(x + 1, y, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst) {
            uitkomst = nieuweUitkomst;
        }

        // maak de markering ongedaan
        doolhof[x][y] = "G";

        if (uitkomst < MAX_WAARDE) {
            return uitkomst;
        }
        
        return MAX_WAARDE;
    }

    @Override
    public void paint(Graphics g, int x, int y) {
        
        g.drawImage(itemImage, x * 40, y * 40, null);
    }
    
    public void paintRoute(Graphics g) {
        
        ImageIcon img = new ImageIcon("src/Pics/helperPad.png");
        itemImage = img.getImage();
        
        for (int x = 0; x < aantalKolRij; x++) {
            for (int y = 0; y < aantalKolRij; y++) {
                
                if ("*".equals(oplossing[x][y])) {
                    
                    g.drawImage(itemImage, y * 40, x * 40, null);
                }
            }
        }

    }
    
    public void setVeldLijst(Veld[][] doolhof) {
        this.veldLijst = doolhof;
    }
}
