//package Lab3;
///**
// * Created by Brian G on 6/28/2017.
// */
//class Node {
//
//    public int iData;
//    public Node next;
//
//    public Node(int x) {
//        iData = x;
//    }
//
//    public void displayNode() {
//        System.out.print(iData + " ");
//
//    }
//
//}
//class CircularList {
//
//    private Node first;
//    private Node last;
//    private Node current;
//    private int count; // total items in the list
//
//
//    public CircularList() {
//        first = null;
//        last = null;
//        current = null;
//        count = 0;
//    }
//
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    public void step() {
//        current = current.next;
//    }
//
//
//
//    public Node getFirst() {
//        return first;
//    }
//
//    public void insert(int x) {
//        Node newNode = new Node(x);
//
//        if (isEmpty()) {
//            first = newNode;
//            current = first;
//        } else {
//            current.next = newNode;
//        }
//
//        newNode.next = first;
//        last = newNode;
//        step();
//        count++;
//    }
//
//
//
//    public void delete(int x) {
//        Node prev = first;
//        Node curr = first.next;
//
//        while (curr.iData != x) {
//            prev = curr;
//            curr = curr.next;
//
//        }
//
//        if (count == 1) {
//            first = null;
//            count--;
//        } else if (curr == first) {
//            prev.next = curr.next;
//            first = curr.next;
//            count--;
//        } else {
//            prev.next = curr.next;
//            count--;
//        }
//
//    }
//
//    public void displayList() {
//        int x = 0;
//        Node printer = first;
//
//        if (x == count-1) {
//            printer.displayNode();
//            printer = printer.next;
//            x++;
//        }
//
//
//    }
//
//}
//class Josephus {
//
//    private int numOfPeople; // number of people in a circle
//    private int countNum; // number used for counting off
//    private Node head;
//    private Node tail;
//    CircularList circle;
//
//    public Josephus() {
//        circle = new CircularList();
//        numOfPeople = 0;
//        countNum = 0;
//
//    }
//
//    public void setNumOfPeople(int x) {
//        numOfPeople = x;
//
//    }
//
//
//
//    public void setCountNum(int x) {
//        countNum = x;
//    }
//
//
//
//    public void addPeople() {
//        for (int i = 1; i < numOfPeople; i++) {
//            circle.insert(i);
//        }
//    }
//
//    public void move() {
//
//        for (int i = 0; i < countNum; i++) {
//            tail = head;
//            head = head.next;
//        }
//
//
//
//    }
//
//    public void execute() {
//        tail = null;
//        head = circle.getFirst();
//        while (numOfPeople != 2) {
//
//            move();
//            circle.delete(head.iData);
//            tail = tail.next;
//            head = head.next;
//            numOfPeople--;
//            display();
//        }
//
//    }
//
//    public void display() {
//        //System.out.print("Alive:  ");
//        circle.displayList();
//    }
//
//}
//public class Garcia3 {
//    public static int survivalNumber(int n, int e){
//        Josephus lab3 = new Josephus();
//
//        lab3.setNumOfPeople(n);
//        lab3.addPeople();
//        System.out.print("Last person alive position: ");
//        lab3.display();
//
//        lab3.setCountNum(e);
//        lab3.execute();
//    return 0;
//    }
//
//
//}