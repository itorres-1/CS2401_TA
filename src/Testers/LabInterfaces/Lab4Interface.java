package Testers.LabInterfaces;

/**
 * Author: Isaac Torres
 * Date: 7/5/17.
 * Course: CS 2401 Elementary Data Structures
 */

/**
 * An interface to ensure that the everyone in the class
 * adheres to the exact same method signature thus ensuring
 * code compatibility with the TA's code.
 */
public interface Lab4Interface {
    /**
     * A method that given a string of characters, whatever characters,
     * prints all possible partitions of these characters. The uniqueness
     * of the characters in the string are irrelevant.
     * @param str the string representing a set of characters
     */
    public void printAllPartitions(String str);
}
