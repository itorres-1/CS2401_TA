//package Lab3;
//
//import java.util.*;
///**
// * Author: Imani Martin
// * Course: CS2401
// * Date: July 7, 17
// * Assignment: Lab 3
// * Professor: Urenda, Julio
// */
//
////TODO -5 in correctness for REALLY not following directions on submissions format.
//
//public class Martin3{
//
//    private CircularList circle;
//
//    private int members;
//
//    private int killOrder;
//
//    //prompt user for input
//    public void preparation(){
//        Scanner scnr = new Scanner (System.in);
//
//        System.out.print("Please enter the number of members: ");
//        members = scnr.nextInt();
//
//        if (members < 0){
//            System.out.println("Invalid input. Negative number. ");
//            System.out.print("Please enter a positive number next time.");
//            System.out.println("Good-bye.");
//            System.exit(0);
//        }
//
//        System.out.print("Enter the count to death:");
//        killOrder = scnr.nextInt();
//
//        if (killOrder < 0){
//            System.out.println("Invalid input. Negative number. ");
//            System.out.print("Please enter a positive number.");
//            System.out.println("Good-bye.");
//            System.exit(0);
//        }
//
//    }
//
//    public void createlist(){
//        circle = new CircularList();
//
//        for(int element = 1; element <= members; element++) {
//            circle.add(element);
//        }
//
//        circle.print();
//
//    }
//
//    //calls survival method, decreasing the size of the array
//    public void survivor(){
//        circle.SurvivalNumber(killOrder--, members);
//
//        circle.print();
//
//    }
//
//    public static void main(String args[]){
//        //covert methods for exception
//        try{
//            Martin catchEx = new Martin();
//
//            catchEx.preparation();
//            catchEx.createlist();
//            catchEx.survivor();
//        }
//
//        catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//
//}
//
//
////Creating, Deleting, and Positioning elements within the list
//class CircularList {
//    private Nodes head;
//
//    private int iterator;
//
//    //adding new members
//    public void add(int member){
//        iterator++;
//        Nodes first = new Nodes(member);
//
//        if(head == null){
//            head = first;
//        }
//        else{
//            Nodes tail = head;
//
//            while(tail.link != head){
//                tail = tail.link;
//            }
//            tail.link = first;
//        }
//        first.link = head;
//    }
//
//    public void moveToFront(int member){
//        iterator++;
//        Nodes first = new Nodes(member);
//
//        if(head == null){
//            first.link = first;
//        }
//        else{
//            Nodes tail = head;
//
//            while(tail.link != head){
//                tail = tail.link;
//            }
//            tail.link = tail;
//            first.link = head;
//        }
//        head = first;
//    }
//
//    //prints out the survivors of the list
//    public void print(){
//        if(head == null) {
//            System.out.println("There is nothing present within the list.");
//        }
//        else{
//            Nodes first = head;
//            System.out.print("The remaining members are: ");
//
//            while(first.link != head){
//                System.out.print(first.data + " ");
//                first = first.link;
//            }
//            System.out.println(first.data + " ");
//        }
//    }
//
//    //deleting elements
//    public int deletElem(Nodes kill){
//        Nodes current = head;
//        Nodes previous = head;
//        int info = kill.data;
//
//        while(current.data != info){
//            if(current.link == head) {
//                break;
//            }
//            previous = current;
//            current = current.link;
//        }
//        previous.link = current.link;
//        iterator = iterator - 1;
//
//        return info;
//    }
//
//    //returns what's left of the list
//    public int totalMembers(){
//        return iterator;
//    }
//
//    //Let the game begin
//    public void survivalNumber(int members,int killOrder){
//        Nodes current = head;
//        int iterator;
//
//        while(true){
//            iterator = current.data;
//
//            for(int i = 0; i < members; i++){
//                current = current.link;
//            }
//
//            head = current.link;
//
//            if(totalMembers() > 1){
//                if(iterator == current.data){
//                deletElem(current);
//                    print();
//                }
//
//                else{
//                    deletElem(current);
//                }
//                print();
//            }
//
//            current = head;
//        }
//    }
//
//    //storage
//    private static class Nodes{
//        int data;
//        Nodes link;
//
//        public Nodes(int info){
//            this.data = info;
//        }
//
//        public Nodes(int info, Nodes link){
//            this.data = info;
//            this.link = link;
//        }
//    }
//}