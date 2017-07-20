//package Lab3;
//
//import java.util.Scanner;
//import java.util.Scanner;
//
//
//
//
///* Class Node */
//class intNode {
//    protected int value;
//    protected intNode link;
//
//
//    /* Constructor */
//    public intNode(int num, intNode n)
//    {
//        value = num;
//        link = n;
//    }
//    /* Function to set link to next Node */
//    public void setLink(intNode n)
//    {
//        link = n;
//    }
//    /* Function to set name to current Node */
//    public void setValue(int d)
//    {
//        value = d;
//    }
//    /* Function to get link to next node */
//    public intNode getLink()
//    {
//        return link;
//    }
//    /* Function to get name from current Node */
//    public int getValue()
//    {
//        return value;
//    }
//}
//
////Here is the code for linkedList.java:
//
///* Class linkedList */
//class linkedList
//{
//    protected intNode head ;
//    protected intNode tail ;
//    public int size ;
//
//    /* Constructor */
//    public linkedList()
//    {
//        head = null;
//        tail = null;
//        size = 0;
//    }
//    /* Function to check if list is empty */
//    public boolean isEmpty()
//    {
//        return head == null;
//    }
//    /* Function to get size of the list */
//    public int getSize()
//    {
//        return size;
//    }
//
//    /**
//     * Inserts element at end of list
//     * @param val
//     */
//    public void insertAtEnd(int val)
//    {
//        intNode nptr = new intNode(val,null);
//        nptr.setLink(head);
//        if(head == null)
//        {
//            head = nptr;
//            nptr.setLink(head);
//            tail = head;
//        }
//        else
//        {
//            tail.setLink(nptr);
//            tail = nptr;
//        }
//        size++ ;
//    }
//    /**
//     * Deletes an element at given position
//     * @param pos
//     */
//    public void deleteAtPos(int pos)
//    {
//        if (size == 1 && pos == 1)
//        {
//            head = null;
//            tail = null;
//            size = 0;
//            return ;
//        }
//        if (pos == 1)
//        {
//            head = head.getLink();
//            tail.setLink(head);
//            size--;
//            return ;
//        }
//        if (pos == size)
//        {
//            intNode s = head;
//            intNode t = head;
//            while (s != tail) {
//                t = s;
//                s = s.getLink();
//            }
//            tail = t;
//            tail.setLink(head);
//            size --;
//            return;
//        }
//        intNode ptr = head;
//        pos = pos - 1 ;
//
//        int i = 1;
//        while(true)
//        {
//            if (i == pos)
//            {
//                intNode tmp = ptr.getLink();
//                tmp = tmp.getLink();
//                ptr.setLink(tmp);
//                break;
//            }
//            ptr = ptr.getLink();
//            i++;
//        }
//        size-- ;
//        return;
//    }
//
//    /**
//     * Displays Contents of Circular linked list
//     */
//    public void display()
//    {
//        System.out.print("\nCircular Singly Linked List = ");
//        intNode ptr = head;
//        if (size == 0)
//        {
//            System.out.print("empty\n");
//            return;
//        }
//        for(int i = 0; i < size-1; i++)
//        {
//            System.out.print(ptr.getValue() + "->");
//            ptr = ptr.getLink();
//        }
//        System.out.println(ptr.getValue());
//    }
//}
//
//
//
///* Class CircularSinglyLinkedList */
//
///**
// *
// */
//public class Wiggs3 {
//    /**
//     *
//     * @param args
//     */
//    public static void main(String[] args)
//    {
//        Scanner scan = new Scanner(System.in);
///* Creating object of linkedList */
//        linkedList list = new linkedList();
//        System.out.print("Enter the number of people in the circle: ");
//        int numOfPeople = scan.nextInt();
///* Preparing the circle. */
//        for(int i = 1; i <= numOfPeople; i++)
//            list.insertAtEnd(i);
//        System.out.print("The initial circle is: ");
//        list.display();
//        System.out.print("Enter the elimination number: ");
//        int eliminationNumber = scan.nextInt();
//
////Applying Josephus technique.
//        int currentPosition = eliminationNumber;
//        do
//        {
//            list.deleteAtPos(currentPosition);
//            currentPosition += eliminationNumber - 1;
//            list.display();
//        }while(list.getSize() != 1);
//
//    }
//}
