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
public class SpelerTest {
    
    private int muurX = 17;
    private int muurY = 1;
    
    private int gangX = 18;
    private int gangY = 3;
    
    private int bazookaX = 2;
    private int bazookaY = 5;
    
    private int valsSpelerX = 2;
    private int valsSpelerY = 6;
    
    private int helperX = 2;
    private int helperY = 7;
    
    private int stappen = 20;
    
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
        
        instance.setVeldX(muurX);
        instance.setVeldY(muurY);
        
        instance.move(BeweegRichting.omhoog);
        int verwachtY = 1;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove2() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(muurX);
        instance.setVeldY(muurY);
        
        instance.move(BeweegRichting.rechts);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testMove3() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(muurX);
        instance.setVeldY(muurY);
        
        instance.move(BeweegRichting.omlaag);
        int verwachtY = 1;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove4() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(muurX);
        instance.setVeldY(muurY);
        
        instance.move(BeweegRichting.links);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testMove5() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(gangX);
        instance.setVeldY(gangY);
        
        instance.move(BeweegRichting.omhoog);
        int verwachtY = 2;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove6() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(gangX);
        instance.setVeldY(gangY);
        
        instance.move(BeweegRichting.rechts);
        int verwachtX = 19;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testMove7() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(gangX);
        instance.setVeldY(gangY);
        
        instance.move(BeweegRichting.omlaag);
        int verwachtY = 4;
        assertEquals(verwachtY, instance.getVeldY());
    }
    
    @Test
    public void testMove8() {
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(gangX);
        instance.setVeldY(gangY);
        
        instance.move(BeweegRichting.links);
        int verwachtX = 17;
        assertEquals(verwachtX, instance.getVeldX());
    }
    
    @Test
    public void testPakItemBazooka1(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(bazookaX);
        instance.setVeldY(bazookaY);
        
        instance.move(BeweegRichting.rechts);
        
        Bazooka verwacht = null;
        assertEquals(verwacht, instance.getBazooka());
    }
    
    @Test
    public void testPakItemBazooka2(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(bazookaX);
        instance.setVeldY(bazookaY);
        
        instance.move(BeweegRichting.links);
        
        boolean verwacht = true;
        assertEquals(verwacht, instance.getBazooka().isGevonden);
    }
    
    @Test
    public void testPakItemValsSpeler1(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        instance.setStappen(stappen);
        int verwacht = stappen + 1;
        
        instance.setVeldX(valsSpelerX);
        instance.setVeldY(valsSpelerY);
        
        instance.move(BeweegRichting.rechts);
        
        assertEquals(verwacht, instance.getStappen());
    }
    
    @Test
    public void testPakItemValsSpeler2(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        instance.setStappen(stappen);
        
        Item item = level.getGang(1, 6).getItem();
        ValsSpeler vals = null;
        if(item instanceof ValsSpeler)
        {
            vals = (ValsSpeler)item;
        }
        int verwacht = (stappen + 1) - vals.getStappen();
        
        instance.setVeldX(valsSpelerX);
        instance.setVeldY(valsSpelerY);
        
        instance.move(BeweegRichting.links);
        
        assertEquals(verwacht, instance.getStappen());
    }
    
    @Test
    public void testPakItemHelper1(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(bazookaX);
        instance.setVeldY(bazookaY);
        
        instance.move(BeweegRichting.rechts);
        
        Helper verwacht = null;
        assertEquals(verwacht, instance.getHelper());
    }
    
    @Test
    public void testPakItemHelper2(){
        Level level = new Level(99);
        Speler instance = new Speler();
        instance.setLevel(level);
        
        instance.setVeldX(helperX);
        instance.setVeldY(helperY);
        
        instance.move(BeweegRichting.links);
        
        boolean verwacht = true;
        assertEquals(verwacht, instance.getHelper().isGevonden);
    }
}
    
 
