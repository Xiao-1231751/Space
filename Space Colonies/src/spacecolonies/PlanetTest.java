package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a test class to test the methods from the planet class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class PlanetTest extends student.TestCase {
    private Planet earth;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        earth = new Planet("earth", 2, 2, 2, 10);
    }


    /**
     * Test if setName() method can work correctly
     *
     */
    public void testSetName() {
        earth.setName("sun");
        assertEquals("sun", earth.getName());
    }


    /**
     * Test if getName() method can get the correctly name
     *
     */
    public void testGetName() {
        assertEquals("earth", earth.getName());
    }


    /**
     * Test if getSkills() method can work correctly
     *
     */
    public void testGetSkills() {
        assertNotNull(earth.getSkills());
    }


    /**
     * Test if the getPopulation() method can work correctly
     *
     */
    public void testGetPopulation() {
        assertNotNull(earth.getPopulation());
    }


    /**
     * Test if the getPopulationSize() method can return the correct population
     * size
     *
     */
    public void testGetPopulationSize() {
        assertEquals(0, earth.getPopulationSize());
    }


    /**
     * Test if the getCapacity() method can get the correct capacity
     *
     */
    public void testGetCapacity() {
        assertEquals(10, earth.getCapacity());
    }


    /**
     * Test if the getAvailability can get the correct availability of the
     * planet
     *
     */
    public void testGetAvailability() {
        assertEquals(10, earth.getAvailability());
    }


    /**
     * Test if the isFull() method can check if the planet is full or not
     *
     */
    public void testIsFull() {
        assertFalse(earth.isFull());
        for (int i = 0; i < 10; i++) {
            earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        }
        assertTrue(earth.isFull());
    }


    /**
     * Test if the isQualified() method can check if the people can live in the
     * planet
     *
     */
    public void testIsQualified() {
        assertTrue(earth.isQualified(new Person("Tom", 3, 3, 3, "")));
        assertFalse(earth.isQualified(new Person("Tom", 1, 1, 1, "")));
        for (int i = 0; i < 10; i++) {
            earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        }
        assertFalse(earth.isQualified(new Person("Tom", 3, 3, 3, "")));
        assertFalse(earth.isQualified(new Person("Tom", 1, 1, 1, "")));

    }


    /**
     * Test if addPerson() method can work when people didn't meet the
     * requirement
     *
     */
    public void testAddPerson() {
        assertFalse(earth.addPerson(new Person("Tom", 1, 1, 1, "")));
    }


    /**
     * Test if toString() method can work correctly
     *
     */
    public void testToString() {
        assertEquals(
            "earth, population 0 (cap: 10), Requires: A >= 2, M >= 2, T >= 2",
            earth.toString());
    }


    /**
     * Test if the equals() method can work in the different situations
     *
     */
    public void testEquals() {
        assertFalse(earth.equals(null));
        assertTrue(earth.equals(earth));
        String test = "earth";
        assertFalse(earth.equals(test));
        Planet firstEarth = new Planet("earth", 2, 2, 2, 10);
        assertTrue(earth.equals(firstEarth));

        Planet earth0 = new Planet("earth", 2, 2, 2, 10);
        earth0.addPerson(new Person("Tom", 3, 3, 3, ""));
        assertFalse(earth.equals(earth0));
        Planet earth1 = new Planet("earth1", 2, 2, 2, 10);
        assertFalse(earth.equals(earth1));

        Planet earth3 = new Planet("earth", 2, 3, 2, 10);
        assertFalse(earth.equals(earth3));
        Planet earth4 = new Planet("earth4", 2, 3, 2, 11);
        assertFalse(earth.equals(earth4));

        Planet earth5 = new Planet("earth", 2, 2, 2, 11);
        assertFalse(earth.equals(earth5));

        Planet earth6 = new Planet("earth", 2, 2, 2, 10);
        earth6.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth6.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth6.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth6.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth.addPerson(new Person("Tom", 3, 3, 3, ""));
        assertTrue(earth.equals(earth6));

        Planet earth7 = new Planet("earth", 2, 2, 2, 10);
        earth7.addPerson(new Person("Tim", 3, 3, 3, ""));
        earth7.addPerson(new Person("Tom", 3, 4, 3, ""));
        earth7.addPerson(new Person("Tom", 3, 3, 3, ""));
        earth7.addPerson(new Person("Tim", 3, 3, 3, ""));
        assertFalse(earth.equals(earth7));
    }


    /**
     * Test if the compareTo() method can work correctly
     *
     */
    public void testCompareTo() {
        assertEquals(-1, earth.compareTo(new Planet("earth", 2, 2, 2, 12)));
        assertEquals(1, earth.compareTo(new Planet("earth", 2, 2, 2, 9)));
        earth.addPerson(new Person("Tim", 3, 3, 3, ""));
        Planet earth0 = new Planet("earth", 2, 2, 2, 10);
        assertEquals(-1, earth.compareTo(earth0));
        assertEquals(1, earth0.compareTo(earth));

        Planet earth1 = new Planet("earth", 3, 3, 3, 10);
        Planet earth2 = new Planet("earth", 2, 2, 2, 10);
        assertEquals(1, earth1.compareTo(earth2));
        assertEquals(-1, earth2.compareTo(earth1));

        Planet earth3 = new Planet("earth", 3, 3, 3, 10);
        Planet earth4 = new Planet("sun", 3, 3, 3, 10);
        assertEquals(-14, earth3.compareTo(earth4));
        assertEquals(14, earth4.compareTo(earth3));

        Planet earth5 = new Planet("earth", 2, 2, 2, 10);
        Planet earth6 = new Planet("earth", 2, 2, 2, 10);
        assertEquals(0, earth5.compareTo(earth6));
    }
}
