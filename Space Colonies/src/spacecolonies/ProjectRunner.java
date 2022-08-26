package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the ProjectRunner class to run the code from other classes
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ProjectRunner {

    /**
     * Creates a new instance of the Project Runner class
     * 
     */
    public ProjectRunner() {

        /**
         * The constructor should be empty
         */
    }


    /**
     * Creates a new method to run the all codes
     * 
     * @param args
     *            The array contains the test name
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        if (args.length == 2) {
            ColonyReader coloyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader coloyReader = new ColonyReader("input.txt",
                "planets.txt");
        }

    }

}
