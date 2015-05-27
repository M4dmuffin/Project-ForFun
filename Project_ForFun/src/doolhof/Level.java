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
    private final int AANTAL_KOLOMMEN_LEVEL;
    private String[] level;
    private String[][] level_2D;


    public Level(int levelCount)
    {
        AANTAL_KOLOMMEN_LEVEL = 21;
        level = new String[AANTAL_KOLOMMEN_LEVEL];
        level_2D = new String[AANTAL_KOLOMMEN_LEVEL][AANTAL_KOLOMMEN_LEVEL];
        veldLijst = new Veld[AANTAL_KOLOMMEN_LEVEL][AANTAL_KOLOMMEN_LEVEL];
        openFile(levelCount);
        readFile();
        closeFile();
        bouwGrid();
    }
    
    private void openFile(int level)
    {
        String levelText = "";
        if(level == 1)
        {
            levelText = "src/Levels/Level1.txt";
        }
        if(level == 2)
        {
            levelText = "src/Levels/Level2.txt";
        }
        if(level == 3)
        {
            levelText = "src/Levels/Level3.txt";
        }
        try
        {
            levelOpbouw = new Scanner(new File(levelText));
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("Error: Map niet gevonden");
        }
    }

    private void readFile()
    {
        while (levelOpbouw.hasNext())
        {
            for (int i = 0; i < AANTAL_KOLOMMEN_LEVEL; i++)
            {
                level[i] = levelOpbouw.next();
            }
        }

        try
        {
            for (int i = 0; i < AANTAL_KOLOMMEN_LEVEL; i++)
            {
                for (int j = 0; j < AANTAL_KOLOMMEN_LEVEL; j++)
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

    private void closeFile()
    {
        levelOpbouw.close();
    }

    private void bouwGrid()
    {
        for (int i = 0; i < AANTAL_KOLOMMEN_LEVEL; i++)
        {
            for (int j = 0; j < AANTAL_KOLOMMEN_LEVEL; j++)
            {
                String huidig = level_2D[i][j];
                if (huidig.equals("m"))
                {
                    Muur muur = new Muur();
                    Veld veld = new Veld();
                    veld.setMuur(muur);
                    veld.setLocX(i);
                    veld.setLocY(j);
                    veldLijst[i][j] = veld;
                } else if (huidig.equals("g"))
                {
                    Gang gang = new Gang();
                    Veld veld = new Veld();
                    veld.setGang(gang);
                    veld.setLocX(i);
                    veld.setLocY(j);
                    veldLijst[i][j] = veld;
                } else if (huidig.equals("v"))
                {
                    Vriend vriend = new Vriend();
                    Veld veld = new Veld();
                    veld.setVriend(vriend);
                    veld.setLocX(i);
                    veld.setLocY(j);
                    veldLijst[i][j] = veld;
                }
            }
        }
    }
    
    public int getAANTAL_KOLOMMEN_LEVEL()
    {
        return AANTAL_KOLOMMEN_LEVEL;
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
}
