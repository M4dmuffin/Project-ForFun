/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author HP Pavillion
 */
public class Level
{

    private Veld[][] veldLijst;
    private Scanner levelOpbouw;
    private final int AANTAL_KOL_RIJ;
    private String[] level;
    private String[][] level_2D;
    private int hoeveelheidLevels;

    public Level(int levelCount)
    {
        AANTAL_KOL_RIJ = 21;
        level = new String[AANTAL_KOL_RIJ];
        level_2D = new String[AANTAL_KOL_RIJ][AANTAL_KOL_RIJ];
        veldLijst = new Veld[AANTAL_KOL_RIJ][AANTAL_KOL_RIJ];
        hoeveelheidLevels = levelCount();
        openFile(levelCount);
        readFile();
        closeFile();
        bouwGrid();
        
    }

    // dynamisch level counter
    private int levelCount()
    {
        boolean isGevonden = false;
        int i = 1;
        while (isGevonden == false)
        {
            try
            {
                Scanner levelCount = new Scanner(new File("src/Levels/Level" + i + ".txt"));
                i++;
            } catch (FileNotFoundException ex)
            {
                isGevonden = true;
            }
        }
        return i - 1;
    }

    // open het txt bestand
    private void openFile(int level)
    {
        String levelText = "";
        levelText = "src/Levels/Level" + Integer.toString(level) + ".txt";
        try
        {
            levelOpbouw = new Scanner(new File(levelText));
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Error: Map niet gevonden");
        }
    }

    // lees het txt bestand uit
    private void readFile()
    {
        while (levelOpbouw.hasNext())
        {
            for (int i = 0; i < AANTAL_KOL_RIJ; i++)
            {
                level[i] = levelOpbouw.next();
            }
        }
        try
        {
            for (int i = 0; i < AANTAL_KOL_RIJ; i++)
            {
                for (int j = 0; j < AANTAL_KOL_RIJ; j++)
                {
                    level_2D[i][j] = level[i].substring(j, j + 1);
                }
            }
        } catch (NullPointerException n)
        {
            System.out.println("jaja het is zo!");
        } catch (Exception e)
        {
            System.out.println("nee er is iets anders!");
        }
    }

    // sluit het txt bestand af
    private void closeFile()
    {
        levelOpbouw.close();
    }

    // bouw het grid aan de hand van het txt bestand
    private void bouwGrid()
    {
        for (int y = 0; y < AANTAL_KOL_RIJ; y++)
        {
            for (int x = 0; x < AANTAL_KOL_RIJ; x++)
            {
                String huidig = level_2D[y][x];
                switch (huidig)
                {
                    case "x":
                    {
                        Muur muur = new Muur();
                        muur.setIsBreekbaar(false);
                        Veld veld = new Veld();
                        veld.setMuur(muur);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        muur.setVeld(veld);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "m":
                    {
                        Muur muur = new Muur();
                        muur.setIsBreekbaar(true);
                        Veld veld = new Veld();
                        veld.setMuur(muur);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        muur.setVeld(veld);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "g":
                    {
                        Gang gang = new Gang();
                        Veld veld = new Veld();
                        veld.setGang(gang);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        gang.setVeld(veld);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "h":
                    {
                        Gang gang = new Gang();
                        Veld veld = new Veld();
                        Helper helper = new Helper();
                        gang.setItem(helper);
                        helper.setVeldLijst(veldLijst);
                        veld.setGang(gang);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        gang.setVeld(veld);
                        helper.setGang(gang);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "c":
                    {
                        Gang gang = new Gang();
                        Veld veld = new Veld();
                        ValsSpeler vals = new ValsSpeler();
                        vals.setStappen((int) (Math.random() * 10) + 1);
                        gang.setItem(vals);
                        veld.setGang(gang);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        gang.setVeld(veld);
                        vals.setGang(gang);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "b":
                    {
                        Gang gang = new Gang();
                        Veld veld = new Veld();
                        Bazooka baz = new Bazooka();
                        gang.setItem(baz);
                        veld.setGang(gang);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        gang.setVeld(veld);
                        baz.setGang(gang);
                        veldLijst[y][x] = veld;
                        break;
                    }
                    case "v":
                    {
                        Vriend vriend = new Vriend();
                        Veld veld = new Veld();
                        veld.setVriend(vriend);
                        veld.setLocX(y);
                        veld.setLocY(x);
                        vriend.setVeld(veld);
                        veldLijst[y][x] = veld;
                        break;
                    }
                }
            }
        }
    }

    public int AANTAL_KOL_RIJ()
    {
        return AANTAL_KOL_RIJ;
    }

    public Vriend getVriend(int x, int y)
    {
        Vriend index = veldLijst[y][x].getVriend();
        return index;
    }

    public Muur getMuur(int x, int y)
    {
        Muur index = veldLijst[y][x].getMuur();
        return index;
    }

    public Gang getGang(int x, int y)
    {
        Gang index = veldLijst[y][x].getGang();
        return index;
    }

    public Veld[][] getVeldLijst()
    {
        return veldLijst;
    }

    public Veld getEenVeld(int x, int y)
    {
        return veldLijst[y][x];
    }

    public int getHoeveelheidLevels()
    {
        return hoeveelheidLevels;
    }
}
