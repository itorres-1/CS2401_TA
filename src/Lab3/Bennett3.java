//package Lab3;
//
///**
// * Created by samur_000 on 7/10/2017.
// */
//public class Bennett3 {
//    static class iNode{
//        int data;
//        iNode next; // this is a reference to the "next" node in the sequence
//
//        public iNode(int data, iNode next){
//            this.data = data;
//            this.next = next;
//        }
//    }
//    static class CLL{
//        iNode reference; //we could call this "head" but it's circular
//        int size;
//
//        public CLL(int n){
//            if (n >=1){
//                reference = new iNode(++size,null);
//                iNode lastNodeCreated = reference;
//                while (size < n){
//                    lastNodeCreated.next = new iNode(++size, null);
//                    lastNodeCreated = lastNodeCreated.next;
//                }
//                lastNodeCreated.next = reference; //this line is the line that mske this thing circulsr
//            }
//        }
//
//        public void printCLL(){
//            iNode tmp = reference;
//            int counter = 0;
//            while (counter < size){
//                System.out.print(tmp.data+" ");
//                tmp = tmp.next;
//                counter++;
//            }
//            System.out.println();
//        }
//
//        public Integer initiateSequence(int e){
//            if (e >=1){
//                reference = new iNode(++size,null);
//                iNode lastNodeCreated = reference;
//                while (size < e){
//                    lastNodeCreated.next = new iNode(++size, null);
//                    lastNodeCreated = lastNodeCreated.next;
//                }
//                lastNodeCreated.next = reference;
//            }
//            return null;
//
//        }
//    }
//
//    public static Integer survivalNumber(int n, int e){
//        if (n < 1 || e < 1) return null;
//        CLL suicidalFools = new CLL(n);
//        return suicidalFools.initiateSequence(e);
//    }
//
//    public static void main(String[] args) {
//    }
//}
