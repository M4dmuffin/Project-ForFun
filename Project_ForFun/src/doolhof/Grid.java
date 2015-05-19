/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

/**
 *
 * @author Lars
 */
public class Grid
{
    private static Level level = new Level();
    
    
    public Veld[][] bouwGrid()
    {
        Object[][] doolhof = level.level1;
        Veld[][] veldGrid = new Veld[21][21];
        for (int i = 0; i < 21; i++)
        {
            for (int j = 0; j < 21; j++)
            {
                Veld veld = new Veld();
                veld.x = i;
                veld.y = j;
                veld.object = doolhof[i][j];
                veld.buren[0] = doolhof[i - 1][j];
                veld.buren[1] = doolhof[i][j + 1];
                veld.buren[2] = doolhof[i + 1][j];
                veld.buren[3] = doolhof[i][j - 1];
                veldGrid[i][j] = veld;
            }
        }
        return veldGrid;
    }
}
