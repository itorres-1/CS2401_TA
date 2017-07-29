package Testers.LabInterfaces;

import java.util.ArrayList;

/**
 * Author: Isaac Torres
 * Date: 7/26/17.
 * Course: CS 2401
 * Assignment: Lab 7
 * Instructor: Julio Urenda
 */

/**
 * An interface to ensure the student's code is compatible with the TA's code.
 * As stated several times, "implementing" this interface in your class is not
 * strictly necessary, so long as your methods have the EXACT SAME SIGNATURE
 * (this is strictly necessary). If you do not implement this interface, you
 * run the risk of having a different signature than the TA's and therefore
 * are risking your grade.
 */
public interface Lab7Interface {
    /**
     * A method that given an integer d, returns an array list of strings
     * containing all the elements of the Stern-Brocot tree of depth d
     * IN ORDER. By convention, a tree with depth 0 contains a single node.
     * As an example, the Stern-Brocot tree in the lab PDF is the tree
     * created had d been equal to 2, thus this method would have returned
     * the array list: ["1/3", "1/2", "2/3", "1/1","3/2","2/1","3/1"]
     * @param depth an int representing the depth of the desired tree.
     * @return an array list containing the element of the tree IN ORDER.
     */
    public ArrayList<String> sternBrocotTreeInOrder(int depth);
    /**
     * A method that given an integer d, returns an array list of strings
     * containing all the elements of the Stern-Brocot tree of depth d in
     * POST ORDER.
     * @param depth an int representing the depth of the desired tree.
     * @return an array list containing the element of the tree in POST ORDER.
     */
    public ArrayList<String> sternBrocotTreePostOrder(int depth);
    /**
     * A method that given an integer d, returns an array list of strings
     * containing all the elements of the Stern-Brocot tree of depth d in
     * PRE ORDER.
     * @param depth an int representing the depth of the desired tree.
     * @return an array list containing the element of the tree in PRE ORDER.
     */
    public ArrayList<String> sternBrocotTreePreOrder(int depth);
}
