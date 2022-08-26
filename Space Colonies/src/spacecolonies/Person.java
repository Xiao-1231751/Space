package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the class to check the people's information
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class Person {
    private String name;
    private Skillset skills;
    private String planetPreference;

    /**
     * Creates a new instance of the Person class
     * 
     * @param name
     *            The name of the people
     * @param agri
     *            The agri skill number of the people
     * @param medi
     *            The medi skill number of the people
     * @param planet
     *            The planet skill number of the people
     * @param tech
     *            The tech skill number of the people
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        this.skills = new Skillset(agri, medi, tech);
        this.planetPreference = planet;
    }


    /**
     * Creates a new method to get the name of the people
     * 
     * @return return the name of the people
     */
    public String getName() {
        return this.name;
    }


    /**
     * Creates a new method to get the skills of the people
     * 
     * @return return the skills information of the people as the skillset
     */
    public Skillset getSkills() {
        return this.skills;
    }


    /**
     * Creates a new instance of the DisplayCollection class
     * 
     * @return return the preference planet of the person
     */
    public String getPlanetPreference() {
        return this.planetPreference;
    }


    /**
     * Creates a new method to return the person's information as a string
     * 
     * @return return a string contains people's information
     */
    public String toString() {
        StringBuilder stringMaker = new StringBuilder();
        if (!this.planetPreference.equals("")) {
            stringMaker.append(this.name);
            stringMaker.append(" ");
            stringMaker.append(skills.toString());
            stringMaker.append(" Wants: ");
            stringMaker.append(this.planetPreference);
        }
        else {
            stringMaker.append("No-Planet");
            stringMaker.append(" ");
            stringMaker.append(this.name);
            stringMaker.append(" ");
            stringMaker.append(skills.toString());
        }
        return stringMaker.toString();
    }


    /**
     * Creates a new method to compare if the tow objects are same
     * 
     * @param obj
     *            the object will be used to compare
     * @return return true if two objects are same
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == this.getClass()) {
            Person newPeople = ((Person)obj);
            return this.name.equals(newPeople.name) && this.skills.equals(
                newPeople.skills) && this.planetPreference.equals(
                    newPeople.planetPreference);
        }
        return false;
    }
}
