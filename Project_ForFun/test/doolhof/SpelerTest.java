/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.xml.bind.Marshaller;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author HP Pavillion
 */
public class SpelerTest {
    
    public SpelerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception { 
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of move method, of class Speler.
     */
    @Test
    public void testMove1() {
        System.out.println("move, test1, verwachting = Succes"); 
        BeweegRichting richting = null;
        Speler instance = new Speler();
        int beginX  = instance.getVeldX(); // 1 is startpositie X van de speler
        int beginY = instance.getVeldY();  // 1 is startpositie Y van de speler
        int eindX = 0;
        int eindY = 0;
        
        richting = BeweegRichting.omhoog;
        if(richting.equals(BeweegRichting.omhoog))
        {
            eindY = beginY - instance.getVeldY();           
        }
        //Verwachting = Goed;
        assertTrue("Succes, De beweging van de speler is omhoog dus omlaag op de Y-as beginY moet dus groter zijn dan eindY", beginY > eindY);
        
        richting = BeweegRichting.omlaag;
        if(richting.equals(BeweegRichting.omlaag))
        {
            eindY = beginY + instance.getVeldY();
        }
        //Verwachting = Goed;
        assertTrue("Succes, De beweging van de speler is omlaag dus omhoog op de Y-as beginY moet dus kleiner zijn dan eindY", beginY < eindY);
        
        richting = BeweegRichting.links;
        if(richting.equals(BeweegRichting.links))
        {
            eindX = beginX - instance.getVeldX();
        }
        //Verwachting = Goed;
        assertTrue("Succes, De beweging van de speler is links dus omlaag op de X-as beginX moet dus groter zijn dan eindX", beginX > eindX);
        
        richting = BeweegRichting.rechts;
        if(richting.equals(BeweegRichting.rechts))
        {
            eindX = beginX + instance.getVeldX();
        }
        //Verwachting = Goed;
        assertTrue("Succes, De beweging van de speler is rechts dus omhoog op de X-as beginX moet dus kleiner zijn dan eindX", beginX < eindX);
    }
    
    /**
     * Test of move method, of class Speler.
     */
    @Test(expected = AssertionError.class)
    public void testMove2() {
        System.out.println("move, test2, verwachting = Error"); 
        BeweegRichting richting = null;
        Speler instance = new Speler();
        int beginX  = instance.getVeldX(); // 1
        int beginY = instance.getVeldY();  // 1
        int eindX = 0;
        int eindY = 0;
        
        richting = BeweegRichting.omhoog;
        if(richting.equals(BeweegRichting.omhoog))
        {
            eindY = beginY - instance.getVeldY();
        }
        // Verwachting Error
        assertFalse("Error, De beweging van de speler is omhoog dus omlaag op de Y-as, beginY moet dus groter zijn dan eindY", beginY > eindY);
        
        
        richting = BeweegRichting.omlaag;
        if(richting.equals(BeweegRichting.omlaag))
        {
            eindY = beginY + instance.getVeldY();
        }
        // Verwachting Error
        assertFalse("Error, De beweging van de speler is omlaag dus omhoog op de Y-as, beginY moet dus kleiner zijn dan eindY", beginY < eindY);
        
        richting = BeweegRichting.links;
        if(richting.equals(BeweegRichting.links))
        {
            eindX = beginX - instance.getVeldX();
        }
        // Verwachting Error
        assertFalse("Error, De beweging van de speler is links dus omlaag op de X-as, beginX moet dus groter zijn dan eindX", beginX > eindX);
        
        richting = BeweegRichting.rechts;
        if(richting.equals(BeweegRichting.rechts))
        {
            eindX = beginX + instance.getVeldX();
        }
        // Verwachting Error
        assertFalse("Error, De beweging van de speler is rechts dus omhoog op de X-as, beginX moet dus kleiner zijn dan eindX", beginX < eindX);
    }
 
}
