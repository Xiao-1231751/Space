package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the class to check the information of the planet
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class Planet implements Comparable<Planet> {

    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int popultionSize;
    /**
     * The capacity is the final integer
     */
    private final int capacity;

    /**
     * Creates a new instance of the Planet class
     * 
     * @param plantName
     *            The name of the planet
     * @param planetAgri
     *            The argi skill number of the planet
     * @param planetMedi
     *            the medi skill number of the planet
     * @param planetTech
     *            the tech skill number of the planet
     * @param planetCap
     *            the cap number of the planet
     */
    public Planet(
        String plantName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        this.name = plantName;
        this.minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        this.population = new Person[planetCap];
        this.popultionSize = 0;
        this.capacity = population.length;
    }


    /**
     * Creates a new method to set the name of the planet
     * 
     * @param name
     *            the name will be used to change the planet's name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Creates a new method to get the name of the planet
     * 
     * @return return the name of the planet
     */
    public String getName() {
        return this.name;
    }


    /**
     * Creates a new method to get the skills of the planet
     * 
     * @return return the skills of the planet
     */
    public Skillset getSkills() {
        return this.minSkills;
    }


    /**
     * Creates a new method get the people in the planet
     * 
     * @return return the array contains people in the planet
     */
    public Person[] getPopulation() {
        return this.population;
    }


    /**
     * Creates a new method to get the people's number in the planet
     * 
     * @return return the number of the people in the planet
     */
    public int getPopulationSize() {
        return this.popultionSize;
    }


    /**
     * Creates a new method to get the capacity of the planet
     * 
     * @return return the planet's capacity
     */
    public int getCapacity() {
        return this.capacity;
    }


    /**
     * Creates a new method to get the availability of the planet
     * 
     * @return return the available number that people can be added to the
     *         planet
     */
    public int getAvailability() {
        return this.capacity - this.popultionSize;
    }


    /**
     * Creates a new method check if the planet is full or not
     * 
     * @return return true if the planet if full
     */
    public boolean isFull() {
        return this.capacity == this.popultionSize;
    }


    /**
     * Creates a new method to add the people in the planet
     * 
     * @param newbie
     *            the people will be added in the planet
     * @return return true if it add the people successfully
     */
    public boolean addPerson(Person newbie) {
        if (this.isQualified(newbie)) {
            population[this.popultionSize] = newbie;
            this.popultionSize++;
            return true;
        }
        return false;
    }


    /**
     * Creates a new method to test if the people can live in the planet or not
     * 
     * @param newbie
     *            the people will be check
     * @return return true if the people can live in the planet
     */
    public boolean isQualified(Person newbie) {
        return !isFull() && minSkills.isLessThanOrEqualTo(newbie.getSkills());
    }


    /**
     * Creates a new method to return the planet's information as a string
     * 
     * @return return a string contains planet's information
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(", population ");
        stringBuilder.append(this.popultionSize);
        stringBuilder.append(" (cap: ");
        stringBuilder.append(this.capacity);
        stringBuilder.append("), Requires: A >= ");
        stringBuilder.append(this.minSkills.getAgriculture());
        stringBuilder.append(", M >= ");
        stringBuilder.append(this.minSkills.getMedicine());
        stringBuilder.append(", T >= ");
        stringBuilder.append(this.minSkills.getTechnology());
        return stringBuilder.toString();
    }


    /**
     * Creates a new method to check if two objects are equals or not
     * 
     * @param obj
     *            the object will be used to check
     * @return return true if two objects are same
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        // System.out.println(this.getClass() + " " + obj.getClass() +
        // (this.getClass() == obj.getClass()));
        if (this.getClass() == obj.getClass()) {
            Planet newPlanet = ((Planet)obj);
            if ((this.getName().equals(newPlanet.getName())) && (this
                .getSkills().equals(newPlanet.getSkills())) && (this
                    .getPopulationSize() == newPlanet.getPopulationSize())
                && (this.getCapacity() == newPlanet.getCapacity())) {
                for (int i = 0; i < this.popultionSize; i++) {
                    Person thisPeople = this.population[i];
                    Person otherPeople = newPlanet.population[i];
                    if (!thisPeople.equals(otherPeople)) {
                        return false;
                    }
                }
                return true;

            }
            return false;

        }
        return false;
    }


    /**
     * Creates a new method to compare two planets.
     * 
     * @param newPlanet
     *            The new planet will be used to compare
     * @return return -1 if this planet is less accessible than another one
     *         return 0 if this planet is as same as another one
     *         return 1 if this planet is more accessible than another one
     */
    @Override
    public int compareTo(Planet newPlanet) {
        
        if (this.capacity < newPlanet.capacity) {
            return -1;
        }
        else if (this.capacity == newPlanet.capacity) {
            if (this.getAvailability() < newPlanet.getAvailability()) {
                return -1;
            }
            else if (this.getAvailability() == newPlanet.getAvailability()) {
                if (this.minSkills.compareTo(newPlanet.minSkills) < 0) {
                    return -1;
                }
                else if (this.minSkills.compareTo(newPlanet.minSkills) == 0) {
                    return this.name.compareTo(newPlanet.name);
                }
                else {
                    return 1;
                }
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }

}
