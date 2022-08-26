package spacecolonies;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a test class to test the methods from Person class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class PersonTest extends student.TestCase {

    private Person people;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        people = new Person("Tom", 2, 2, 2, "Earth");
    }


    /**
     * Test if the getName() method can return the name of the people
     *
     */
    public void testGetName() {
        assertEquals("Tom", people.getName());
    }


    /**
     * Test if the getSkills method can return the correct skillset
     *
     */
    public void testGetSkills() {
        Skillset skills = new Skillset(2, 2, 2);
        assertEquals(skills, people.getSkills());
    }


    /**
     * Test if the getPlanetPreference() method can return the correct object
     *
     */
    public void testGetPlanetPreference() {
        assertEquals("Earth", people.getPlanetPreference());
    }


    /**
     * Test if the toString() method can return the correct string
     *
     */
    public void testToString() {
        assertEquals("Tom A:2 M:2 T:2 Wants: Earth", people.toString());
        Person newPeople = new Person("Tim", 2, 2, 2, "");
        assertEquals("No-Planet Tim A:2 M:2 T:2", newPeople.toString());
    }


    /**
     * Test if the equals() method can correctly check if two objects are same
     *
     */
    public void testEuqals() {
        Person secondPeople = new Person("Tom", 2, 2, 2, "Earth");
        Person thirdPeople = new Person("Tim", 2, 2, 2, "Earth");
        Person fourthPeople = new Person("Tom", 3, 2, 2, "Earth");
        Person people5 = new Person("Tom", 2, 3, 2, "Earth");
        Person people6 = new Person("Tom", 2, 2, 3, "Earth");
        Person people7 = new Person("Tom", 2, 2, 2, "Sum");
        String people8 = "Tom";
        assertFalse(people.equals(null));
        assertTrue(people.equals(people));
        assertTrue(people.equals(secondPeople));
        assertFalse(people.equals(thirdPeople));
        assertFalse(people.equals(thirdPeople));
        assertFalse(people.equals(fourthPeople));
        assertFalse(people.equals(people5));
        assertFalse(people.equals(people6));
        assertFalse(people.equals(people7));
        assertFalse(people.equals(people8));
    }
}
