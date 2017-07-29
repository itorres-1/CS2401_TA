///**
// * Created by samur_000 on 7/20/2017.
// */
//public class Bennett5 {
//
///**
// * Author: Alexis Bennett
// * Date: 7/23/17
// * Course: CS 2401 Elementary Data Structures
// */
//
//    /**
//     * An interface to ensure that the everyone in the class
//     * adheres to the exact same method signature(s) thus ensuring
//     * code compatibility with the TA's code.
//     */
//    public interface Lab5Interface {
//
//        public static void main(String[] args) {
//            int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//                change(A);
//            /**
//             * A method that given a reference to an int array, sorts that array
//             * using a recursive implementation of bubble sort.
//             * @param A
//             */
//        }
//        public void rBubbleSort(int[] A);
//            if(A == null);{
//            return;
//        }
//            for(i = 0; i < A.length-1; i++){
//            if(A[i] > A[i+1]){
//               swap(A,i);
//            }
//    }
//        public void rSelectionSort(int[] A);
//
//        int i = 0;
//        if(i>1){
//            i--;
//            rSelectionSort(A,i);
//            int x = A[i];
//            int j = i -1;
//
//            while(j>=0 && A[j]> x){
//                A[j+1] = A[j];
//                j--;
//            }
//            A[j+1] = x;
//        }
//        public void rInsertionSort(int[] A);
//
//        if(A.length==1){
//            return new int[]{A[0]};
//        }
//        int[] sortArr = new int[A.length - 1]{
//                System.arraycopy(A, 0,sortArr, 0,A.length + 1);
//                int[] B = rInsertionSort(sortArr);
//                int[] C = merge(B ,A[A.length - 1]);
//
//                return C;
//        }
//        public void iQuickSort(int[] A);
//    }
//        public void iMergeSort(int[] A);
//
//
//
//
//}
