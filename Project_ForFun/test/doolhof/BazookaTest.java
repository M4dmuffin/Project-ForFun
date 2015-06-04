/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author HP Pavillion
 */
public class BazookaTest
{

    public BazookaTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of schieten method, of class Bazooka.
     */
    @Test
    public void testSchieten1()
    {
        System.out.println("schieten omhoog - muur niet kapot");
        int veldX = 1;
        int veldY = 1;
        int richting = 0;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Gang result = level.getEenVeld(veldX, veldY).getGang();
        Gang verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten2()
    {
        System.out.println("schieten rechts - muur niet kapot");
        int veldX = 1;
        int veldY = 1;
        int richting = 1;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Gang result = level.getEenVeld(veldX, veldY).getGang();
        Gang verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten3()
    {
        System.out.println("schieten omlaag - muur niet kapot");
        int veldX = 1;
        int veldY = 1;
        int richting = 2;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Gang result = level.getEenVeld(veldX, veldY).getGang();
        Gang verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten4()
    {
        System.out.println("schieten links - muur niet kapot");
        int veldX = 1;
        int veldY = 1;
        int richting = 3;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Gang result = level.getEenVeld(veldX, veldY).getGang();
        Gang verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten5()
    {
        System.out.println("schieten omhoog - muur wel kapot");
        int veldX = 3;
        int veldY = 3;
        int richting = 0;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Muur result = level.getEenVeld(veldX, veldY).getMuur();
        Muur verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten6()
    {
        System.out.println("schieten rechts - muur muur wel kapot");
        int veldX = 3;
        int veldY = 3;
        int richting = 1;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Muur result = level.getEenVeld(veldX, veldY).getMuur();
        Muur verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten7()
    {
        System.out.println("schieten omlaag - muur wel kapot");
        int veldX = 3;
        int veldY = 3;
        int richting = 2;
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Muur result = level.getEenVeld(veldX, veldY).getMuur();
        Muur verwachting = null;
        assertEquals(verwachting, result);
    }
    
    @Test
    public void testSchieten8()
    {
        System.out.println("schieten links - muur wel kapot");
        int veldX = 3;
        int veldY = 3;
        int richting = 3;   
        Level level = new Level(99);
        Bazooka instance = new Bazooka();
        instance.schieten(veldX, veldY, richting, level);
        if (richting == 0)
        {
            veldY--;
        }
        if (richting == 1)
        {
            veldX++;
        }
        if (richting == 2)
        {
            veldY++;
        }
        if (richting == 3)
        {
            veldX--;
        }
        Muur result = level.getEenVeld(veldX, veldY).getMuur();
        Muur verwachting = null;
        assertEquals(verwachting, result);
    }
}
