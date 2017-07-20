//package Testers;
//
///**
// * Author: Isaac Torres
// * Date: 6/27/17.
// * Course:
// * Assignment:
// * Instructor:
// * T.A:
// */
//
//class IGTNode{
//    int data;
//    IGTNode next;
//
//    public IGTNode(int data, IGTNode next) {
//        this.data = data;
//        this.next = next;
//    }
//}
//class CircLinkedList{
//    IGTNode head;
//    int size;
//
//    public CircLinkedList(int n) {
//        head = new IGTNode(1,null);
//        IGTNode tmp = head;
//        size = 1;
//        while (size < n){
//            tmp.next = new IGTNode(++size,null);
//            tmp = tmp.next;
//        }
//        tmp.next = head;
//    }
//
//    public Integer initiateSuicide(int e){
//        try{
//            if (e < 2) return null;
//            IGTNode previous = head;
//            IGTNode current = head.next;
//            while(size > 1){
//                for(int i = 2; i < e; i++){
//                    previous = previous.next;
//                    current = current.next;
//                }
//                if (current == head) head = head.next;
//                previous.next =current.next;
//                previous = previous.next;
//                current = previous.next;
//                size--;
//            }
//            System.out.println();
//            return head.data;
//        }catch (Exception exception){
//            return null;
//        }
//    }
//
//    public void printList(){
//        IGTNode tmp = head;
//        int i = 0;
//        while (i++ < size){
//            System.out.print(tmp.data+" ");
//            tmp = tmp.next;
//        }
//        System.out.println();
//    }
//}
//public class Lab3Tester {
//    static double correctness = 0;
//    static double robustness = 0;
//    static int n;
//    static int e;
//    static Integer correctResult;
//    static Integer studentResult;
//
//    public static Integer survivalNumber(int n, int e){
//        if (n < 1 | e < 1) return null;
//        CircLinkedList suicidalFools = new CircLinkedList(n);
//        return suicidalFools.initiateSuicide(e);
//    }
//    public static void main(String[] args) {
//        //Robustness (n < 0)
//        n = -1;
//        e = 2;
//        Util.titleString("Robustness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Robustness += 33.33..");
//                robustness += 33.33333333;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
////        //Robustness (e < 0)
//        n = 5;
//        e = -2;
//        Util.titleString("Robustness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Robustness += 33.33..");
//                robustness += 33.33333333;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        //Robustness (n,e < 0)
//        n = -2;
//        e = -2;
//        Util.titleString("Robustness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Robustness += 33.33..");
//                robustness += 33.33333333;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        //TODO Correctness (n = 10, e = 2)
//        n = 10;
//        e = 2;
//        Util.titleString("Correctness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Correctness += 25");
//                correctness += 25.0;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        //TODO Correctness (n = 10, e = 3)
//        n = 5;
//        e = 2;
//        Util.titleString("Correctness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Correctness += 25");
//                correctness += 25.0;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        //TODO Correctness (n = 7, e = 2)
//        n = 7;
//        e = 2;
//        Util.titleString("Correctness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Correctness += 25");
//                correctness += 25.0;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        //TODO Correctness (n = 7, e = 3)
//        n = 7;
//        e = 3;
//        Util.titleString("Correctness test: n = "+n+", e = "+e);
//        System.out.println("Correct: "+(correctResult = survivalNumber(n,e)));
//        try {
//            System.out.println("Your result: "+(studentResult = Lab3.Monty3.survivalNumber(n,e)));
//            if (studentResult == correctResult){
//                System.out.println("Correctness += 25");
//                correctness += 25.0;
//            }
//        } catch (Exception e){
//            System.out.println("Your code crashed!");
//        }
//        Util.printGradeSoFar(correctness, robustness);
//
//        Util.titleString("Final Grade");
//        Util.printGradeSoFar(correctness, robustness);
//    }
//}
