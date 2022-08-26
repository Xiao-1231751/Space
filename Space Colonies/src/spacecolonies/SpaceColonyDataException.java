package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the soaceColonyDataException class
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * Creates a new instance of the SpaceColonyDataException class
     * 
     * @param string
     *            the string will be posted
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }

}
