package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * Create a test class to test the methods from the SpaceColonyDataException
 * class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class SpaceColonyDataExceptionTest extends student.TestCase {

    private SpaceColonyDataException test;

    /**
     * It will be called before using every methods.
     *
     */
    public void setUp() {
        test = new SpaceColonyDataException("Test");
    }


    /**
     * Test the constructor
     *
     */
    public void testClass() {
        assertEquals("Test", test.getMessage());
    }

}
