package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a test class to test the methods from the skillsset class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class SkillsetTest extends student.TestCase {

    private Skillset skiller;
    private Skillset skiller1;
    private Skillset skiller2;
    private Skillset skiller3;
    private String skiller4;
    private Skillset skiller5;
    private Skillset skiller6;
    private Skillset skiller7;
    private Skillset skiller8;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        skiller = new Skillset(2, 2, 2);
        skiller1 = new Skillset(1, 1, 1);
        skiller2 = new Skillset(3, 3, 3);
        skiller3 = new Skillset(2, 2, 2);
        skiller4 = "apple";
        skiller5 = new Skillset(2, 4, 2);
        skiller6 = new Skillset(2, 2, 3);
        skiller7 = new Skillset(2, 1, 2);
        skiller8 = new Skillset(2, 2, 1);
    }


    /**
     * Test if getTechnology() method can get the tec skill number correctly
     *
     */
    public void testGetTechnology() {
        assertEquals(2, skiller.getTechnology());
    }


    /**
     * Test if isLessThanOREqualTo() method can work correctly to compare two
     * objects
     *
     */
    public void testIsLessThanOrEqualTo() {
        assertTrue(skiller.isLessThanOrEqualTo(skiller2));
        assertFalse(skiller.isLessThanOrEqualTo(skiller1));
        assertFalse(skiller.isLessThanOrEqualTo(skiller7));
        assertFalse(skiller.isLessThanOrEqualTo(skiller8));
    }


    /**
     * Test if equals() method can check if two objects are equals or not
     *
     */
    public void testEquals() {
        assertFalse(skiller.equals(null));
        assertTrue(skiller.equals(skiller));
        assertTrue(skiller.equals(skiller3));
        assertFalse(skiller.equals(skiller2));
        assertFalse(skiller.equals(skiller4));
        assertFalse(skiller.equals(skiller5));
        assertFalse(skiller.equals(skiller6));
    }


    /**
     * Test if compareTo() method can return the correct number (-1, 0, 1)
     *
     */
    public void testCompareTo() {
        assertEquals(-1, skiller.compareTo(skiller2));
        assertEquals(0, skiller.compareTo(skiller3));
        assertEquals(1, skiller.compareTo(skiller1));
    }


    /**
     * Test if toString() method can work correctly
     *
     */
    public void testToString() {
        assertEquals("A:2 M:2 T:2", skiller.toString());
    }
}
