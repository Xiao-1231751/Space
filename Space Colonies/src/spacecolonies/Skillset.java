package spacecolonies;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Huhua Xiao (xiaohuhua2019)

/**
 * It is the Skillset class that contains three skills information
 * 
 * @author Huhua Xiao (xiaohuhua2019)
 * @version 04.09.2022
 */
public class Skillset {
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * Creates a new instance of the Skillset class
     * @param ag
     *            the agri skill number
     * @param med
     *            the med skill number
     * @param tech
     *            the tech skill number
     */
    public Skillset(int ag, int med, int tech) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tech;
    }


    /**
     * Creates a new method to get the argi skill number
     * 
     * @return return the argi skill number
     */
    public int getAgriculture() {
        return this.agriculture;
    }


    /**
     * Creates a new method to get the med skill number
     * 
     * @return return the med skill number
     */
    public int getMedicine() {
        return this.medicine;
    }


    /**
     * Creates a new method to get the tec skill number
     * 
     * @return return the tec skill number
     */
    public int getTechnology() {
        return this.technology;
    }


    /**
     * Creates a new method to check if one skillset is less than other skillset
     * 
     * @param other
     *            the other skillset will be compared
     * @return return true if one of the skillset is less than another one
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return (this.agriculture <= other.agriculture)
            && (this.medicine <= other.medicine)
            && (this.technology <= other.technology);
    }


    /**
     * Creates a new method to check if two objects are same or not
     * 
     * @param obj
     *            the another object will be used to compare
     * @return return true if they are same
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == this.getClass()) {
            Skillset newSkillset = ((Skillset)obj);
            return (this.agriculture == newSkillset.agriculture)
                && (this.medicine == newSkillset.medicine)
                && (this.technology == newSkillset.technology);
        }
        return false;
    }


    /**
     * Creates a new method to get the information of the skillset as a string
     * 
     * @return return the information as a string
     */
    public String toString() {
        String result = "";
        result = "A:" + this.getAgriculture() + " M:" + this.getMedicine()
            + " T:" + this.getAgriculture();
        return result;
    }


    /**
     * Creates a new method to compare two skillsets
     * 
     * @param skills
     *            the another skillset
     * @return the negative means less, positive means more, zero means equal
     */
    public int compareTo(Skillset skills) {
        int sum = this.agriculture + this.medicine + this.technology;
        int total = skills.agriculture + skills.medicine + skills.technology;
        if (sum < total) {
            return -1;
        }
        else if (sum == total) {
            return 0;
        }
        else {
            return 1;
        }
    }

}
