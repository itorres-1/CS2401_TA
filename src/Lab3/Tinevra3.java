//package Lab3;
//
///**
// * Created by tinevra17 on 6/29/17.
// */
//import java.io.IOException;
//
////TODO separate separate separate! Also why the IOException? We're not opening files.
////TODO why the need for "convertData"? Why not just immediately return the data?
//
///**
// * class IntNode set up the variables and constructors for a circular linked list.
// * such as data and IntNode next
// */
//class IntNode {
//    int data;
//    IntNode next;
//
//    public IntNode(int data, IntNode next) {
//        this.data = data;
//        this.next = next;
//    }
//}
//
///**
// * class CLL
// * has 3 local variables.
// * one to store the node head of the circular linked list.
// * second one to store the size onf the circular linked list.
// * third one to store the intNode of the iterator.
// */
//class CLL {
//        IntNode head = null;
//        int size = 0;
//        IntNode iterator;
//
//        /**
//         * CLL
//         * it creates a circular linked list of size n and eliminates elements in the circular linked list based on m.
//         *
//         * @param n the number of people in the circular linked list.
//         * @param m the elimination number, for example, if this number is exactly two we eliminate every second person.
//         *          determines the survivor’s number.
//         */
//        public CLL(int n, int m) {
//
//            //created linked list
//            if (n > 0) {
//                head = new IntNode(++size, null);
//                iterator = head;
//                while (size < n) {
//                    iterator.next = new IntNode(++size, null);
//                    iterator = iterator.next;
//                }
//                iterator.next = head;
//            }
//            int count = 1;
//            iterator = head;
//            IntNode elimination;
//            int sizeLL = n;
//            int eliminationNum = m;
//
//            //deleting elements based on elimination num
//            while (sizeLL > 1) {
//
//                //position of iterator one before elimination num
//                while (count < eliminationNum - 1) {
//                    iterator = iterator.next;
//                    count++;
//                }
//
//                elimination = iterator.next;
//                iterator.next = elimination.next;
//                iterator = elimination.next;
//                count = 1;
//                sizeLL--;
//            }
//        }
//
//        /**
//         * convertData method
//         * converts the position of the survivor node into an integer.
//         *
//         * @return the position of the survivor node.
//         */
//        public int convertData() {
//            int convert = 0;
//            convert = iterator.data;
//            return convert;
//        }
//    }
//
//
//public class Tinevra3 {
//    /**
//     * survivalNumber method
//     * this method calls the CLL class
//     * @param n the number of people in the circular linked list.
//     * @param m the elimination number, for example, if this number is exactly two we eliminate every second person.
//     * determines the survivor’s number.
//     * @return an integer which is the position of the survival node in the circular linked list after CLL is executed.
//     * */
//    public static Integer survivalNumber(int n, int m){
//
//        int survivor = 0;
//        try {
//            if(n<=0 || m<=0){
//                throw new IOException() ;
//            }
//
//            CLL survivorInfo = new CLL(n, m);
//            survivor = survivorInfo.convertData();
//
//        }catch (NullPointerException | IOException e) {
//            return null;
//        }
//        return survivor;
//    }
//}
//
//
//
//
//
//
//
//
//
