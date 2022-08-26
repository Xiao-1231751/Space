package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the class to read the information from the text document
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ColonyReader {

    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * Creates a new instance of the ColonyReader class
     * 
     * @param applicantFile
     *            The text document contains people's information
     * @param planetFileName
     *            The text document contains planet's information
     */
    @SuppressWarnings("unused")
    public ColonyReader(String applicantFile, String planetFileName)
        throws java.text.ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        queue = readQueueFile(applicantFile);
        planets = readPlanetFile(planetFileName);
        // System.out.println(queue);
        ColonyCalculator colonyCalculator = new ColonyCalculator(queue,
            planets);
        SpaceWindow newWindow = new SpaceWindow(colonyCalculator);
    }


    /**
     * Creates a new method to check if the people is in range
     * 
     * @param num1
     *            The agri skill number
     * @param num2
     *            the medi skill number
     * @param num3
     *            the tech skill number
     * @return return true if the skill numbers are in the range
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        if (num1 > ColonyCalculator.MAX_SKILL_LEVEL
            || num1 < ColonyCalculator.MIN_SKILL_LEVEL
            || num2 > ColonyCalculator.MAX_SKILL_LEVEL
            || num2 < ColonyCalculator.MIN_SKILL_LEVEL
            || num3 > ColonyCalculator.MAX_SKILL_LEVEL
            || num3 < ColonyCalculator.MIN_SKILL_LEVEL) {
            return false;
        }
        else {
            return true;
        }
    }


    /**
     * Creates a new method to read the information from the planetFile
     * 
     * @param fileName
     *            The file name of the planet
     * @return return the array contains the information of the planet
     */
    private Planet[] readPlanetFile(String fileName)
        throws java.text.ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        Planet[] newPlanets = new Planet[3];
        File newFile = new File(fileName);
        Scanner scanner = new Scanner(newFile);
        int number = 0;
        while (scanner.hasNextLine() && number < 3) {
            String read = scanner.nextLine();
            Scanner currLine = new Scanner(read);
            currLine.useDelimiter(", ");
            String[] tokens = new String[5];
            int counter = 0;
            while (currLine.hasNext() && counter < 5) {
                tokens[counter] = currLine.next();
                // System.out.println(tokens[counter]);
                counter++;
            }
            currLine.close();
            if (counter != 5) {
                throw new java.text.ParseException("parse exception", 1);
            }
            int[] skillsNumber = new int[3];
            int count = 0;
            for (int i = 1; i < 4; i++) {
                int result = Integer.valueOf(tokens[i]);
                skillsNumber[count] = result;
                // System.out.println(skillsNumber[count]);
                count++;
            }
            if (!isInSkillRange(skillsNumber[0], skillsNumber[1],
                skillsNumber[2])) {
                throw new SpaceColonyDataException("parse exception");
            }
            Planet newPlanet = new Planet(tokens[0], skillsNumber[0],
                skillsNumber[1], skillsNumber[2], Integer.valueOf(tokens[4]));

            newPlanets[number] = newPlanet;
            number++;
        }
        scanner.close();
        for (int i = 0; i < 3; i++) {
            if (newPlanets[i] == null) {
                throw new SpaceColonyDataException("parse exception");
            }
        }
        return newPlanets;

    }


    /**
     * Creates a new method to read the people's information from the text file
     * @param fileName
     *            The file name of the people
     * @return return an arrayQueue contains the people 
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        ArrayQueue<Person> peopleList = new ArrayQueue<Person>(
            ArrayQueue.DEFAULT_CAPACITY);
        File newFile = new File(fileName);
        Scanner scanner = new Scanner(newFile);
        while (scanner.hasNextLine()) {
            String read = scanner.nextLine();
            Scanner newScanner = new Scanner(read);
            newScanner.useDelimiter(", *");
            String[] tokens = new String[5];
            int counter = 0;
            while (newScanner.hasNext() && counter < 5) {
                tokens[counter] = newScanner.next();
                // System.out.println(tokens[counter]);
                counter++;
            }
            newScanner.close();
            int[] skillsNumber = new int[3];
            int count = 0;
            for (int i = 1; i < 4; i++) {
                // System.out.println(tokens[i]);
                int result = Integer.valueOf(tokens[i]);
                skillsNumber[count] = result;
                count++;
            }
            if (!isInSkillRange(skillsNumber[0], skillsNumber[1],
                skillsNumber[2])) {
                throw new SpaceColonyDataException("parse exception");
            }
            Person newPeople = null;
            if (tokens.length == 5) {
                newPeople = new Person(tokens[0], skillsNumber[0],
                    skillsNumber[1], skillsNumber[2], tokens[4]);
            }
            else {
                newPeople = new Person(tokens[0], skillsNumber[0],
                    skillsNumber[1], skillsNumber[2], "");
            }
            peopleList.enqueue(newPeople);

        }
        scanner.close();
        return peopleList;
    }

}
