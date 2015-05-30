/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author HP Pavillion
 */
public class LevelTest {
    
    public LevelTest() {
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
     * Test of getAANTAL_KOLOMMEN_LEVEL method, of class Level.
     */
    @Test
    public void testGetAANTAL_KOLOMMEN_LEVEL() {
        System.out.println("getAANTAL_KOLOMMEN_LEVEL");
        Level instance = new Level(1);
        int expResult = 21;
        int result = instance.getAANTAL_KOLOMMEN_LEVEL();
        assertEquals(expResult, result);

    }

    /**
     * Test of getHoeveelheidLevels method, of class Level.
     */
    @Test
    public void testGetHoeveelheidLevels() {
        System.out.println("getHoeveelheidLevels");
        Level instance = new Level(1);
        int expResult = 4;
        int result = instance.getHoeveelheidLevels();
        assertEquals(expResult, result);

    }
}
