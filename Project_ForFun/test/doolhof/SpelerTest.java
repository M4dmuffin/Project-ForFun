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
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(17);
        instance.setVeldY(1);
        
        instance.move(BeweegRichting.omhoog);
        int verwachtY = 1;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove2() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(17);
        instance.setVeldY(1);
        
        instance.move(BeweegRichting.rechts);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testMove3() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(17);
        instance.setVeldY(1);
        
        instance.move(BeweegRichting.omlaag);
        int verwachtY = 1;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove4() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(17);
        instance.setVeldY(1);
        
        instance.move(BeweegRichting.links);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    
    @Test
    public void testMove5() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(18);
        instance.setVeldY(3);
        
        instance.move(BeweegRichting.omhoog);
        int verwachtY = 2;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove6() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(18);
        instance.setVeldY(3);
        
        instance.move(BeweegRichting.rechts);
        int verwachtX = 19;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testMove7() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(18);
        instance.setVeldY(3);
        
        instance.move(BeweegRichting.omlaag);
        int verwachtY = 4;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove8() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(18);
        instance.setVeldY(3);
        
        instance.move(BeweegRichting.links);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    
    
    
}
    
 
