//package Lab3;
//
///**
// * STring
// * Created by Onyx on 6/28/2017.
// */
//class linkNode {
//    int data;
//    linkNode next;
//    linkNode previous;
//
//    // constructors
//    public linkNode(linkNode inputnext, int elementgiven) {
//        data = elementgiven;
//        next = inputnext;
//    }
//
//    public linkNode(linkNode inputnext, linkNode inputhead, int elementgiven) {
//        data = elementgiven;
//        next = inputnext;
//        previous = inputhead;
//
//    }
//}
//
//public class McCarty3 {
//
//    public static Integer survivalNumber(int numberofpeople, int eliminationnumber) {
//        try {
//            if (numberofpeople < 0) {
//                throw new Exception(" this first parameter must be an integer greater than 0");
//            }
//            if (eliminationnumber < 0) {
//                throw new Exception(" the second parameter must be an integer greater than 0");
//            }
//
//
//            int size;
//            // create list
//            if (numberofpeople > 0) {
//                size = 0;
//                linkNode head = new linkNode(null, ++size);
//                linkNode temp = head;
//                linkNode temp2 = head;
//                while (size < numberofpeople) {
//                    temp.next = new linkNode(null, ++size);
//                    temp = temp.next;
//                }
//                temp.next = head;
//                temp = head;
//////////////////////////////////////////////// list is now created
//                //  creating loop to delete given elimination number
//                int peopleleft = size;
//                while (peopleleft > 1) {
//
//                    for (int i = 1; i < eliminationnumber-1; i++) {
//                        temp = temp.next;
//                    }
//                    temp2 = temp.next;
//                    temp.next = temp2.next;
//                    temp=temp.next;
//                    peopleleft--;
//
//                }
//
//                return temp.data;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//}
//
///*public class test {
//    public static void main(String[] args) {
//
//        System.out.println(" the survivor is " + McCarty3.survivalNumber(-1, 2));
//    }
//}*/