//package Lab3;
//
///*****************************************
// * Aaron Monty
// * CS2401: Summer 2017
// * Date: June 27
// * Lab 3: due July 3
// *****************************************/
//import java.util.Scanner;
//import java.util.LinkedList;
//
///**
// * a linked list node
// */
//class intNode{
//    intNode next;
//    int data;
//
//    //Constructor
//    public intNode(int data){
//        this.data = data;
//    }
//
//    //Constructor
//    public intNode(int d, intNode n){
//        data = d;
//        next = n;
//    }
//
//}
//
///**
// * circular linked list class that defines the beginning and end reference
// */
//class CLL{
//    public intNode start=null ;
//    public intNode end=null ;
//    public int size=0 ;
//
//    //to check if its empty
//    public boolean isEmpty(){
//        return start == null;
//    }
//
//    //to get size
//    public int getSize(){
//        return size;
//    }
//
//    /**
//     * Print a linked list on display
//     */
//    public void print(){
//        System.out.print("People in the Circle:");
//        intNode temp = start;
//        if(size<=0){
//            System.out.print("Circle is empty.");
//        }else{
//            do {
//                System.out.print(" " + temp.data);
//                temp = temp.next;
//            }
//            while(temp!=start);
//        }
//        System.out.println();
//    }
//
//}
//
///**
// * a class to create a circular linked list
// */
//class CLL2{
//    intNode ref = null;
//    int size = 0;
//
//    //creation of circular linked list
//    public CLL2(int n){
//        ref = new intNode(++size,null);
//        intNode lastOneIn = ref;
//        //build the list to size
//        while (size < n){
//            lastOneIn.next = new intNode(++size, null);
//            lastOneIn = lastOneIn.next;
//        }
//        //last refers to the first
//        lastOneIn.next = ref;
//    }
//
//    /**
//     * print the circular linked list
//     */
//    public void printCLL2(){
//        intNode tmp = ref;
//        int counter = 0;
//        while (counter < size +1){
//            System.out.print(tmp.data+" ");
//            tmp = tmp.next;
//            counter++;
//        }
//        System.out.println();
//    }
//
//    /**
//     * method to eliminate user defined nodes
//     * @param e the node that will be deleted
//     * @return the node that is left after elimination
//     */
//    public Integer beginElimination(int e){
//        //deletion continues till one is left
//        while(size>1){
//            //This for loop just gets reference into position(guy before dead guy)
//            for(int i=0;i<e-2;i++){
//                ref=ref.next;
//            }
//            ref.next = ref.next.next;
//            size=size-1;
//            ref = ref.next;
//        }
//        //return the one that is left over
//        return ref.data;
//    }
//}
//
///**
// * a class to house the test functions
// */
//public class Monty3{
//
//    /**
//     * a method which calls other methods to complete deletion sequence
//     * @param n is an integer of people that are input by user
//     * @param e is an integer of the deletion sequence
//     * @return is the node data that is the result of deletion sequence
//     */
//    public static Integer survivalNumber(int n, int e){
//        if (n < 0 || e < 0) return null;
//        CLL2 suicidalManiacs = new CLL2(n);
//        return suicidalManiacs.beginElimination(e);
//    }
//
//    /**
//     * used to test methods of deletion
//     * @param args the actions are stored in an array called args
//     */
//    public static void main(String []args ) {
//
//        //scanner takes the input for the size of list
//        Scanner takePeep = new Scanner(System.in);
//        System.out.println("Enter the number of people in the circle:");
//        String peopleString = "";
//        int peopleNum=0;
//        do{
//            peopleString = takePeep.nextLine();
//            peopleNum=Integer.parseInt(peopleString);
//        }while(peopleNum==0);
//
//        //scanner takes input for the deletion node number
//        Scanner takeKill = new Scanner(System.in);
//        System.out.println("Enter the elimination number:");
//        String killString ="";
//        int foolsKill =0;
//        do{
//            killString = takeKill.nextLine();
//            foolsKill=Integer.parseInt(killString);
//        }while(foolsKill==0);
//
//        //print the output of the method
//       System.out.println(survivalNumber(peopleNum,foolsKill));
//
//
//
//
//    }
//
//}