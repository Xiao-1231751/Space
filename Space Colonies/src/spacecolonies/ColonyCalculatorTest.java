package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a test class to test the methods from the colonyCalculator
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ColonyCalculatorTest extends student.TestCase {

    private ColonyCalculator calculator;
    private ArrayQueue<Person> arrayQueue;
    private Planet[] planets;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        arrayQueue = new ArrayQueue<Person>(9);
        planets = new Planet[3];
        calculator = new ColonyCalculator(arrayQueue, planets);

    }


    /**
     * Test the situation when the applicantQueue is null
     */
    @SuppressWarnings("unused")
    public void testError() {

        Exception e = null;
        try {
            ColonyCalculator newTest = new ColonyCalculator(null, planets);

        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);

    }


    /**
     * Test if the getQueue() method can get the correct object
     *
     */
    public void testGetQueue() {
        assertEquals(arrayQueue, calculator.getQueue());
    }


    /**
     * Test if the getPlanets() method can get the correct object
     *
     */
    public void testGetPlanets() {
        assertNotNull(calculator.getPlanets());
    }


    /**
     * Test if the getPlanetsForPerson() method can return a appropriate planet
     * to the person
     *
     */
    public void testGetPlanetsForPerson() {
        Planet newPlanet = new Planet("Earth", 2, 2, 2, 10);
        Planet newPlanet1 = new Planet("Earth1", 2, 2, 2, 9);
        Planet newPlanet2 = new Planet("Earth2", 2, 2, 2, 8);
        Person newPeople = new Person("Tom", 2, 2, 2, "Earth");
        Person newPeople1 = null;
        Person newPeople2 = new Person("Tom", 2, 2, 2, "Sun");
        planets[0] = newPlanet;
        planets[1] = newPlanet1;
        planets[2] = newPlanet2;
        assertEquals(newPlanet, calculator.getPlanetForPerson(newPeople));
        assertNull(calculator.getPlanetForPerson(newPeople1));
        assertEquals(newPlanet, calculator.getPlanetForPerson(newPeople2));
        Person newPeople3 = new Person("Tom", 3, 3, 3, null);
        assertNull(newPeople3.getPlanetPreference());
        assertEquals(newPlanet, calculator.getPlanetForPerson(newPeople3));
        Person newPeople4 = new Person("Tom", 1, 1, 3, null);
        assertEquals(null, calculator.getPlanetForPerson(newPeople4));
    }


    /**
     * Test the second situation of the getPlanetsForPerson() method.
     *
     */
    public void testGetPlanetsForPersonSecond() {
        Planet newPlanet = new Planet("Earth", 2, 2, 2, 1);
        Planet newPlanet1 = new Planet("Earth1", 2, 2, 2, 1);
        Planet newPlanet2 = new Planet("Earth2", 2, 2, 2, 1);
        planets[0] = newPlanet;
        planets[1] = newPlanet1;
        planets[2] = newPlanet2;
        Person newPeople = new Person("Tom", 2, 2, 2, "Earth");
        Person newPeople1 = new Person("Tim", 4, 2, 2, null);
        newPlanet.addPerson(newPeople);
        newPlanet1.addPerson(newPeople);
        newPlanet2.addPerson(newPeople);
       
        assertEquals(null, calculator.getPlanetForPerson(newPeople1));
        Person newPeople2 = new Person("Tim", 1, 1, 1, null);
        assertEquals(null, calculator.getPlanetForPerson(newPeople2));
        Person newPeople3 = new Person("Tim", 1, 1, 1, "Earth");
        assertEquals(null, calculator.getPlanetForPerson(newPeople3));

    }


    /**
     * Test if the accept() method can work correctly.
     *
     */
    public void testAccept() {
        Planet newPlanet = new Planet("Earth", 2, 2, 2, 1);
        Planet newPlanet1 = new Planet("Earth1", 2, 2, 2, 2);
        Planet newPlanet2 = new Planet("Earth2", 2, 2, 2, 1);
        planets[0] = newPlanet;
        planets[1] = newPlanet1;
        planets[2] = newPlanet2;
        Person newPeople = new Person("Tom", 2, 2, 2, "Earth");
        Person newPeople1 = new Person("Tim", 4, 2, 2, "Earth");
        Person newPeople3 = new Person("Tim", 1, 1, 2, "Earth1");
        Person newPeople4 = new Person("Tim", 1, 2, 2, "Earth");
        
        arrayQueue.enqueue(newPeople);
        arrayQueue.enqueue(newPeople1);
        arrayQueue.enqueue(newPeople3);
        arrayQueue.enqueue(newPeople4);
        
        // isQualified, !isFull
        assertTrue(calculator.accept());
        // isQualified, isFull
        assertFalse(calculator.accept());
        // !isQualified, !isFull
        assertFalse(calculator.accept());
        // !isQualified isFull
        assertFalse(calculator.accept());
        assertFalse(calculator.accept());
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        
        assertFalse(calculator.accept());
    }
    

    /**
     * Test if the reject() method can work correctly.
     *
     */
    public void testReject() {
        Person newPeople = new Person("Tom", 2, 2, 2, "Earth");
        Person newPeople1 = new Person("Tim", 4, 2, 2, "Earth");
        arrayQueue.enqueue(newPeople);
        arrayQueue.enqueue(newPeople1);
        assertEquals(2, arrayQueue.getSize());
        calculator.reject();

    }
   

}
