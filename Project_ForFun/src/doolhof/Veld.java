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
    
    private Muur muur;
    private Gang gang;
    private Vriend vriend;

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
        System.out.println("hallo");
    }
}
