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

    private final static int MAX_WAARDE = 1000;
    private int korste_route;
    private int aantalKol_Rij;
    private Veld[][] veldLijst;
    public char[][] oplossing;
    public char[][] doolhof;

    public Helper() {
        ImageIcon img = new ImageIcon("src/Pics/helper.png");
        itemImage = img.getImage();
        oplossing = null;
        doolhof = new char[21][21];
    }

    // zet de veldlijst terug naar een charlijst
    public void terugOmzetten() {
        for (int y = 0; y < aantalKol_Rij; y++) {
            for (int x = 0; x < aantalKol_Rij; x++) {

                Veld huidig = veldLijst[y][x];
                if (huidig.getMuur() != null) 
                {
                    doolhof[y][x] = 'M';
                }

                if (huidig.getVriend() != null) 
                {
                    doolhof[y][x] = 'V';
                }
                
                if (huidig.getGang() != null) 
                {
                    doolhof[y][x] = 'G';
                }
            }
        }
    }
    
    // Maakt een copy van de charlijst zodat deze kan dienen als oploslijst
    private void copyDoolhof() {
        oplossing = new char[aantalKol_Rij][aantalKol_Rij];
        for (int x = 0; x < aantalKol_Rij; x++) {
            for (int y = 0; y < aantalKol_Rij; y++) {
                oplossing[x][y] = doolhof[x][y];
            }
        }
    }

    // pak de start locatie x,y en los doolhof op
    public void losOp(int x, int y) {
        korste_route = MAX_WAARDE;
        aantalKol_Rij = veldLijst.length;
        for (int q = 0; q < aantalKol_Rij; q++) {
            for (int r = 0; r < aantalKol_Rij; r++) {
                if (veldLijst[q][r].getVriend() != null) {
                    doolhof[q][r] = 'V';
                }
            }
        }
        terugOmzetten();
        korste_route = MAX_WAARDE;

        if (stap(x, y, 0) != MAX_WAARDE) {
            oplossing[x][y] = 'S';
        }
    }

    // Deze recurieve methode zet de stappen terug van vriend naar begin
    public int stap(int x, int y, int aantal) {

        // Zoek vriend
        if (doolhof[x][y] == 'V') {
            korste_route = aantal;
            this.copyDoolhof();
            return aantal;
        }

        // Deze stap gaat niet omdat de stap naar een Muur is of omdat het pad al is bewandeld
        if (doolhof[x][y] == 'M' || doolhof[x][y] == '*') {
            return MAX_WAARDE;
        }
        // dit pad (van vriend naar beging) is langer dan het al eerder gevonden pad (van begin naar vriend)
        if (aantal == korste_route) {
            return MAX_WAARDE;
        }

        //markeer deze stap (van het pad) als oplossing
        doolhof[x][y] = '*';
        int result = MAX_WAARDE;

        int new_result = MAX_WAARDE;

        // omhoog
        new_result = stap(x, y - 1, aantal + 1);
        if (new_result < result) 
        {
            result = new_result;
        }
        
        // omlaag
        new_result = stap(x, y + 1, aantal + 1);
        if (new_result < result) {
            result = new_result;
        }

        // links
        new_result = stap(x - 1, y, aantal + 1);
        if (new_result < result) {
            result = new_result;
        }

        // rechts
        new_result = stap(x + 1, y, aantal + 1);
        if (new_result < result) {
            result = new_result;
        }

        // maak de markering ongedaan
        doolhof[x][y] = 'G';

        if (result < MAX_WAARDE) {
            return result;
        }
     
        return MAX_WAARDE;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon("src/Pics/helperPad.png");
        itemImage = img.getImage();
        for (int x = 0; x < aantalKol_Rij; x++) {
            for (int y = 0; y < aantalKol_Rij; y++) {

                if (oplossing[x][y] == '*') {
                    super.paint(g);
                    g.drawImage(itemImage, y * 40, x * 40, null);
                }
            }
        }

    }

    public void setVeldLijst(Veld[][] doolhof) {
        this.veldLijst = doolhof;
    }
}
