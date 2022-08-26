package spacecolonies;

import java.util.Arrays;
import list.AList;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the class to add the person and check the person application.
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class ColonyCalculator {
    /**
     * There are only three planets, so this number equals to 3
     */
    public static final int NUM_PLANETS = 3;
    /**
     * This the lowest requirement to each person
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * The is the highest requirement to each person
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;

    /**
     * Creates a new instance of the ColonyCalculator class
     * 
     * @param applicantQueue
     *            the arrayQueue contains people's information
     * @param planets
     *            the array contains planet's information
     */
    public ColonyCalculator(
        ArrayQueue<Person> applicantQueue,
        Planet[] planets) {
        if (applicantQueue == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.applicantQueue = applicantQueue;
            this.planets = planets;
            this.rejectBus = new AList<Person>();
        }
    }


    /**
     * Create a new method to get the ArrayQyeye<Person>
     * 
     * @return return a arrayQueue<Person>
     */
    public ArrayQueue<Person> getQueue() {
        return this.applicantQueue;
    }


    /**
     * Creates a new method to get the Planet[]
     * 
     * @return return a Planet[]
     */
    public Planet[] getPlanets() {
        return this.planets;
    }


    /**
     * Creates a new method to check if this planet can accept the people or not
     * 
     * @param newPlanet
     *            The planet will be check
     * @param newPeople
     *            The people will be check
     * @return return true if this planet can accept the people
     */
    private boolean canAccept(Planet newPlanet, Person newPeople) {
        return newPlanet.isQualified(newPeople);
    }


    /**
     * Creates a new method to get a planet that fit to the newPeople
     * 
     * @param newPeople
     *            The people need a planet
     * @return return the planet fits to the newPeople
     */
    private Planet getHighestCapacityPlanet(Person newPeople) {
        Planet sortPlanet = null;
        Planet[] sortPlanets = Arrays.copyOf(planets, planets.length);
        Arrays.sort(sortPlanets);

        for (int i = sortPlanets.length - 1; i >= 0; i--) {
            if (this.canAccept(sortPlanets[i], newPeople)) {
                sortPlanet = sortPlanets[i];
                System.out.println(sortPlanet);
                return sortPlanet;

            }
        }
        return sortPlanet;

    }


    /**
     * Creates a new method to get an appropriate
     * planet to the nextPerson
     * 
     * @param nextPerson
     *            the nextPerson need to find a planet
     * @return return the planet that nextPerson can live
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        String preferencePlanet = "";
        if (nextPerson == null) {
            return null;
        }
        else if (this.getPlanetIndex(nextPerson.getPlanetPreference()) != -1) {

            // preferencePlanet = nextPerson.getPlanetPreference();
            // int index = this.getPlanetIndex(preferencePlanet);
            if (this.planets[this.getPlanetIndex(nextPerson
                .getPlanetPreference())].isQualified(nextPerson)) {
                return this.planets[this.getPlanetIndex(nextPerson
                    .getPlanetPreference())];
            }
            else {
                return null;
            }
        }
        else {
            return this.getHighestCapacityPlanet(nextPerson);
        }
    }


    /**
     * Creates a new method to check if the planet can accept the new person or
     * not
     * 
     * @return return true if the planet can accept the people
     */
    public boolean accept() {
        if (!this.applicantQueue.isEmpty()) {
            Planet planet = this.getPlanetForPerson(this.applicantQueue
                .getFront());
            if (planet != null) {
                planet.addPerson(this.applicantQueue.getFront());
                this.applicantQueue.dequeue();
                return true;
            }

        }
        return false;
    }


    /**
     * Create a new method to add the rejected people to to a new list.
     * 
     */
    public void reject() {
        Person rejectPerson = this.applicantQueue.dequeue();
        this.rejectBus.add(rejectPerson);
    }


    /**
     * Creates a new method to get the index of the planet
     * 
     * @param planet
     *            the planet will be used to find
     * @return return the index of the planet, and return -1 when this planet is
     *         not exist.
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < this.planets.length; i++) {
            if (this.planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }

}
