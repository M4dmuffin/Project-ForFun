/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

/**
 *
 * @author HP Pavillion
 */
public class Veld 
{
    private int locX, locY;
    private Muur muur;
    private Gang gang;
    private Vriend vriend;
    private Veld[] buren;
    private boolean isBezocht;
    
    public Veld()
    {
        buren = new Veld[4];
    }

    public void setLocX(int locX) 
    {
        this.locX = locX;
    }

    public void setLocY(int locY) 
    {
        this.locY = locY;
    }

    public Gang getGang()
    {
        return gang;
    }

    public Muur getMuur()
    {
        return muur;
    }

    public Vriend getVriend()
    {
        return vriend;
    }

    public void setGang(Gang gang)
    {
        this.gang = gang;
    }

    public void setMuur(Muur muur)
    {
        this.muur = muur;
    }

    public void setVriend(Vriend vriend)
    {
        this.vriend = vriend;
    }

    public void setBuren(int richting, Veld veld)
    {
        buren[richting] = veld;
    }

    public Veld getBuren(int richting)
    {
        return buren[richting];
    }

    public boolean isIsBezocht() {
        return isBezocht;
    }

    public void setIsBezocht(boolean isBezocht) {
        this.isBezocht = isBezocht;
    }
    
    
    
}
