/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

/**
 *
 * @author Lars
 */
public class Level 
{
    private Muur m;
    private Gang g;
    private Speler s;
    
    private Object[][] level1;

    public Object[][] getLevel1() 
    {
        return level1;
    }
    
    public Level()
    {
        g = new Gang();
        m = new Muur();
        s = new Speler();
        
        level1 = new Object[][]{
  { m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m },
  { g,s,g,g,m,g,g,g,g,g,g,g,g,g,g,g,g,g,m,g,m },
  { m,g,m,m,m,g,m,m,m,m,m,m,m,m,m,m,m,g,m,g,m },
  { m,g,g,g,g,g,g,g,m,g,m,g,g,g,g,g,g,g,m,g,m },
  { m,g,m,m,m,m,m,m,m,g,m,g,m,m,m,g,m,m,m,g,m },
  { m,g,m,g,g,g,m,g,g,g,m,g,m,g,g,g,m,g,g,g,m },
  { m,m,m,m,m,g,m,g,m,m,m,m,m,m,m,g,m,m,m,g,m },
  { m,g,g,g,m,g,m,g,m,g,m,g,m,g,g,g,g,g,g,g,m },
  { m,g,m,m,m,g,m,g,m,g,m,g,m,m,m,g,m,g,m,m,m },
  { m,g,m,g,m,g,g,g,g,g,g,g,m,g,m,g,g,g,g,g,m },
  { m,g,m,g,m,g,m,m,m,m,m,m,m,g,m,g,g,g,g,g,m },
  { m,g,m,g,g,g,m,g,g,g,g,g,g,g,m,g,g,g,g,g,m },
  { m,g,m,m,m,g,m,g,g,g,g,g,m,m,m,g,g,g,g,g,m },
  { m,g,m,g,g,g,m,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,m,g,m,m,m,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,m },
  { m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,m,g,m },
};
    }
    
}
