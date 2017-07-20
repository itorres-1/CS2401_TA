//package Lab3;
//// Joshua Boatright
//// Lab 3
//// CS2401 - Dr. Urenda - TA: Isaac Torres
//// Date of last modification: 07/02/2017
//
//import java.security.InvalidParameterException;
//import java.util.Scanner;
//
////TODO Do not print in methods which are not supposed to print.
//
//class IntNode {
//  int data;
//  IntNode next;
//
//  /**
//   * Constructor for integer value linked list node.
//   * @param d <code>int</code> value stored in node
//   */
//  IntNode(int d) {
//    data = d;
//    next = null;
//  }
//
//  // ******Utility Method(s) for IntNode Class******
//
//  /**
//   * This method prints an individual node of a linked list.
//   */
//  void printNode() {
//    System.out.print(data + ", ");
//  }
//}
//
//class CLL {
//  IntNode head; // Pointer to first element of CLL
//  IntNode tail; // Pointer to last element of CLL
//  int size; // # of elements in total
//
//  /**
//   * Constructor for circular linked list of type <code>int</code>.
//   * @param n Number of nodes in the linked list (people in the circle).
//   */
//  CLL(int n) {
//    size = n; // Initializes field size to n
//    head = new IntNode(1); // Creates first node with int value 1
//    IntNode iter = head; // Iterator to move through CLL
//    IntNode newNode; // Declare node object to be added in CLL
//
//    // Adds nodes between head and tail, given size n
//    for (int i=2; i<size; i++) {
//      newNode = new IntNode(i);
//      iter.next = newNode;
//      iter = iter.next;
//    }
//
//    tail = new IntNode(size); // Creates "last" node
//    iter.next = tail; // Points previous node to tail
//    tail.next = head; // Points tail to head, completing circle
//  }
//
//  /**
//   * <p>This method uses the size of the linked list, and takes an elimination number.<br />
//   * Using the elimination number, it deletes every <i>n</i>th element (person),<br />
//   * where n is the elimination number.</p>
//   * @param e Elimination number
//   */
//  void eliminateLL(int e) {
//    IntNode iter = head; // Iterator to move through CLL
//    IntNode temp = head; // Temp value to pass over eliminated elements (delete)
//
//    for (int i=0; i<size-1; i++) { // Outer loop performs delete operation 1 times less than the size
//      for (int j=0; j<e-1; j++) { // First inner loop moves iterator to element before the one to be removed
//        iter = iter.next;
//      }
//      for (int k=0; k<e-2; k++) { // Second inner loop moves temp to element before iterator (accounts for e > 2)
//        temp = temp.next;
//      }
//
//      temp.next = iter.next; // Sets temp to value after iterator (effectively removing nth element)
//      iter = iter.next; // Moves iterator to next position
//      temp = temp.next; // Moves temp to next position
//    }
//    head = temp; // Points head to surviving number
//  }
//
//  // ******Utility Method(s) for CLL Class******
//
//  /**
//   * This Method prints a circular linked list.
//   */
//  void printCLL() {
//    System.out.print("List: ");
//    for (int i=0; i<size; i++) {
//      head.printNode();
//      head = head.next;
//    }
//    System.out.println();
//  }
//}
//
//public class Boatright3 {
//  /**
//   * <p>This method creates a circular linked list, then eliminates all but one element given certain criteria.<br />
//   * An elimination number is given, and used to determine every <i>n</i>th element that will be eliminated,<br />
//   * until only one remains, which is the value returned.</p>
//   * @param n Number of people in circle (Size of CLL)
//   * @param e Elimination number (Every <i>n</i>th element is eliminated until there is only one.
//   * @return The surviving element
//   */
//  public static int survivalNumber(int n, int e) {
//    // Throws exception if either parameter is <= 0
//    if (n <= 0 || e <= 0) {
//      throw new InvalidParameterException("Both n and e must be positive integers.");
//    }
//
//    try {
//      // Creates new circular linked list, with size n
//      CLL circle = new CLL(n);
//      // Prints original linked list
//      circle.printCLL();
//      // Performs elimination
//      circle.eliminateLL(e);
//      // Returns surviving integer
//      return circle.head.data;
//    } catch (InvalidParameterException f) { // Returns 0 if exception is caught
//      return 0;
//    }
//  }
//
//  public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);
//
//    System.out.println("How many people are in the circle?"); // Gets # of people from user
//    int numPeople = scan.nextInt();
//
//    System.out.println("Choose an elimination number."); // Gets elimination number from user
//    int elimNum = scan.nextInt();
//
//    int survivor = survivalNumber(numPeople, elimNum); // Calls survivalNumber and assigns to int survivor
//
//    System.out.println("Survived Elimination: " + survivor); // Prints surviving integer
//  }
//}
//
