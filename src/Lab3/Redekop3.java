//package Lab3;
//
///**
//*Assignment: Lab3
//*Name: Jessica Redekop
//*Due: July 3rd, 2017
//*Professor: Dr. Urenda
//*T.A. Isaac Torres
//*/
//
///**
//*This class creates a new object of type IntNode which holds:
//*an int data data form
//*anditself (IntNode)
//*/
//class IntNode{ //creates a new object type IntNode
//
//    public int data; //adds an element of type int to IntNode object
//    public IntNode next; //adds an element of type int to IntNode object
//
//    public IntNode(int myData, IntNode myNext){ //default data constructor
//        data = myData;
//        next = myNext;
//    }
//
//}
//
///**
//*This class creates a new object of type IntNode which holds:
//*an int data data form
//*anditself (IntNode)
//*/
//class CLL{
//
//    public int size=0; //size attribute
//    public IntNode head;//pointer attribute
//
//    public CLL(int n){//constructing the list with a size parameter
//        if (0 < n){//will count down until all links are created
//            head = new IntNode(++size, head); //makes the head point to itself and increases size by one
//            IntNode tmp = head; //creates a new variable pointing to head
//            while(size < n){ //while size is less than n
//                tmp.next = new IntNode(++size, null); //the next intNode will be created pointing to null
//                tmp = tmp.next;//moves temp over
//            }
//            tmp.next = head; //makes the next object equal to what head is pointing to
//        }
//    }
//
//    /**
//    *This method calculates the final IntNode of a CircularLinkedList
//    *@param int e for the elimination number (previously checked for exceptions)
//    *@returns Integer object of node data.
//    */
//    public Integer commenceSuicide(int e){
//        IntNode temp = head; //sets temporary to head
//        IntNode temp2 = head; //sets temporary to head
//        if(e == 1){ //if e is 1, the it should print out the last data
//            while(size > 1){
//                head = head.next; //head is equal to head.next, previous should be deleted
//                size--; //decrease size by 1
//            }
//            return head.data; //returns data of last node
//        }
//        else { //else e > 1
//            while(size > 1){
//                for(int i = 1; i < e-1; i++)//for loop iterates temp to the 2nd node previous of deletion
//                    temp = temp.next;//sets temp to node previous of deletion
//
//                temp2 = temp.next;//sets temp2 to deletion
//
//                if(head == temp2) //moves head if node needs to be deleted
//                    head = temp2.next; //moves head to next available node
//
//                temp.next = temp2.next; //sets temp.next to next node after deletion
//                temp = temp.next; //sets temp to node after the one deleted
//                temp2 = temp; //sets temp2 with temp
//                size--;
//        }
//        return head.data;
//        }
//    }
//
//}
//
//public class Redekop3{
//
//    /**
//    *This method takes the parameters for calculating the survival node of a linked list.
//    *@param n for the length of a linked list
//    *@param e for the elimination number
//    *@returns Integer object of node data.
//    */
//    public static Integer survivalNumber(int n, int e){
//        try{
//            if(n < 1) //exception for list size.
//                throw new Exception("List size should be greater than 0");
//
//            if(e < 1)//exception for elimination number.
//                throw new Exception("Elimination number should be greater than 0");
//
//            CLL suicidalFools = new CLL(n); //creates a circular linked list of size n
//            return suicidalFools.commenceSuicide(e);//calls commenceSuicide method with clean parameters.
//        }
//        catch (Exception excpt){ //catches exceptions
//            System.out.println(excpt.getMessage());
//            return null;//returns empty
//        }
//    }
//}