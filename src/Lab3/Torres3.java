///**
// * Created by Andrea on 6/28/2017.
// */
//package Lab3;
//
//public class Torres3 {
//
//    public static void main(String[] args) {
//        System.out.println("10,2: " + survivalNumber(10, 2));//even number of people even number of Kth power
//        System.out.println("13, 3: " + survivalNumber(13, 3));//odd  number of people odd  number of Kth power
//        System.out.println("15, 4: " + survivalNumber(15, 4));//odd  number of people even number of Kth power
//        System.out.println("20, 3: " + survivalNumber(20, 3));//even number of people odd  number of Kth power
//        System.out.println("52, 9: " + survivalNumber(52, 9));//even number of people odd number of Kth power
//        System.out.println("14763, 13: " + survivalNumber(14763, 13));//odd number of people odd number of Kth power
//        System.out.println("28657, 4148: " + survivalNumber(28657, 4148));//odd number of people even number of Kth power
//        //System.out.println("-12, 2"+survivalNumber(-12,2));//negative number of people even number of Kth power
//        //System.out.println("12, -2"+survivalNumber(12,-2));//even number of people negative number of Kth power
//        //System.out.println("12, -2"+survivalNumber(12,-2));//negative number of people negative number of Kth power
//    }
//
//    /**
//     * This method populates a circular linked list and repeatedly delete elements from it
//     * until only one remains.
//     *
//     * @param numPeople the number of people in the circle.
//     * @param poss      the elimination number, for example, if this number is exactly two we eliminate
//     *                  every second person. determines the survivor’s number.
//     * @return the surviver position.
//     */
//    public static int survivalNumber(int numPeople, int poss) {
//        int lastPerson = -1;
//        if ((numPeople <= 0) || (poss <= 0)) {// this looks for more than one person and killing not adding, although the negative could be used to go counter clockwise in future project, the survivor would still be a positive number.
//            throw new IndexOutOfBoundsException("At least one parameter is less than 1.");
//        }
//        try {
//            LinkedList people = new LinkedList();
//            for (int i = 1; i <= numPeople; i++) {//fills the array with the correct num of people.
//                people.addEnd(i);
//            }
//            //people.printList();//print full list. for testing purposes
//            people.makeCircle();//makes linked list people a circle.
//            while (people.getLength() > 1) {//while there is more than 1 person alive.
//                for (int j = 1; j < poss; j++) {//when j is less than the kill number.
//                    if (j != poss - 1) {//do this if j is not one less than the kill number.
//                        people.changeHead(people.getHead().next);//move head to the next one but not remove it.
//                    } else {//do this if j is equal to kill number -1, because the remove next will remove from the list (why carry dead bodies they wanted to kill you anyways.)
//                        people.removeNext();//this method will remove the
//                        people.changeHead(people.getHead().next);
//                    }
//                    // people.printList(); for testing purposes
//                }
//            }
//            lastPerson = (Integer) people.getHead().data;
//        } catch (Exception e) {
//        }
//        return lastPerson;
//    }
//}
//
//class LinkedList<T> {
//    private Node head;// usually private
//    private Node tail;//usually private
//    private int length;
//
//    public LinkedList() {
//        head = null;
//        tail = null;
//        length = 0;
//    }
//
//    public LinkedList(T data) {
//        head = new Node(data, null);
//        tail = head;
//        length = 1;
//    }
//
//    public Node getHead() {
//        return head;
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public void addEnd(T data) {
//        if (head == null) {
//            head = new Node(data, null);
//            tail = head;
//        } else {
//            Node tmp = new Node(data, null);
//            tail.next = tmp;
//            tail = tmp;
//        }
//
//        length++;
//    }
//
//    public void removeNext() {
//        if ((head.next != null/*Means if length of array is 1*/) && (head.next.next != null/*means length of array is 2*/)) {
//            head.next = head.next.next;
//        } else {
//            head.next = null;
//        }
//        length--;
//    }
//
//    public void makeCircle() {
//        if (head == null) {
//            head = null;
//            tail = null;
//            length = 0;
//        } else {
//            tail.next = head;
//        }
//    }//used to make a linked list circular.
//
//    public void printList() {
//        Node curr = head;
//        for (int i = 0; i < length; i++) {
//            System.out.print(curr.data + " ");
//            curr = curr.next;
//        }
//        System.out.println();
//    }//used for testing purposes
//
//    public void changeHead(Node data) {
//        head = data;
//    }
//}
//
//class Node<T> {
//    public T data;
//    public Node<T> next;
//
//    public Node(T myData, Node<T> myNext) {
//        data = myData;
//        next = myNext;
//    }
//}
