//package Lab3;
//
//import java.util.InputMismatchException;
//
//class IntNode{
//    public int data;
//    public IntNode next;
//
//    /**
//     * This method allows the object to be populated as well as to point towards other nodes.
//     * @param data (int - holds data of type int in the node)
//     * @param next (intNode - pointer towards the next node)
//     */
//    public IntNode(int data, IntNode next) {
//        this.data = data;
//        this.next = next;
//    }
//}
//
//class CLL {
//    IntNode head = null;
//    IntNode temp = null;
//    int size = 0;
//
//    /**
//     * This method populates the object with n amount of nodes. It creates a head node, then a temp node creates new
//     * nodes until the nth node is made. It then makes the pointer of the nth node point towards the head, to make it
//     * a circular linked list.
//     * @param n (int - the number that dictates how many nodes are to be created in the circular linked list)
//     */
//    public CLL(int n) {
//            head = new IntNode(++size, null);
//            temp = head;
//
//            while(size < n) {
//                temp.next = new IntNode(++size, null);
//                temp = temp.next;
//            }
//            temp.next = head;
//    }
//}
//
//public class LeonCordero3 {
//    /**
//     * Integer method survivalNumber receives two integers, numOfPeople and numElim respectively. It checks whether they
//     * are valid numbers (greater than 0) else it throws an exception and returns null. It then eliminates the nth node
//     * in the circular linked list created with kth nodes according to numOfPeople, based on numElim, until there is
//     * only one last node left. Lastly, it returns the data of the last node.
//     *
//     * @param numOfPeople (int - number which dictates how many nodes are int he circular linked list)
//     * @param numElim (int - number which dictates which nth node should be eliminated)
//     * @return people.temp.data (Integer type - treated as an object in order to be able to return null if need be)
//     */
//    public static Integer survivalNumber(int numOfPeople, int numElim) {
//        try {
//            if (numOfPeople <= 0) {
//                throw new InputMismatchException("You cannot have less than 0 people in a circle.");
//            } else if (numElim <= 0) {
//                throw new InputMismatchException("You can't eliminate a negative number of people.");
//            }
//
//            int counter = 1;
//            CLL people = new CLL(numOfPeople);
//            people.temp = people.head;
//            while (people.size > 1) {
//                if ((counter + 1) == numElim) {
//                    people.temp.next = people.temp.next.next;
//                    people.size = people.size - 1;
//                    counter = 0;
//                }
//                people.temp = people.temp.next;
//                counter++;
//            }
//            return people.temp.data;
//        } catch (InputMismatchException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//}