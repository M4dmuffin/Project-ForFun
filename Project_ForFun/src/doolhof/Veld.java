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
    private Object object;

    public int getLocX() 
    {
        return locX;
    }

    public Object getObject() 
    {
        return object;
    }

    public int getLocY() 
    {
        return locY;
    }

    public void setObject(Object object) 
    {
        this.object = object;
    }

    public void setLocX(int locX) 
    {
        this.locX = locX;
    }

    public void setLocY(int locY) 
    {
        this.locY = locY;
    }
    
}
