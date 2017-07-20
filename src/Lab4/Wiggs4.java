package Lab4;

import Testers.LabInterfaces.Lab4Interface;

import java.util.ArrayList;
import java.util.List;

// Robert Noah Wiggs
//CS2401 Summer 2017

    public class Wiggs4 implements Lab4Interface {
        public static void main(String[] args)
        {

            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=4; i++) {
                list.add(i);
            }

            int cnt = 0;
            for(int i=1; i<=list.size(); i++) {
                List<List<List<Integer>>> ret = helper(list, i);
                cnt += ret.size();
                for (List<List<Integer>> partition: ret){
                    System.out.println(partition);
                }
            }
            System.out.println("Number of partitions: " + cnt);
        }

        // partition f(n, m)

        /**
         * helper partitions the array by using if statements and recursive methods
         * @param ori
         * @param m
         * @return
         */
        public static List<List<List<Integer>>> helper(List<Integer> ori, int m)
        {
            List<List<List<Integer>>> ret = new ArrayList<>();
            if(ori.size() < m || m < 1) return ret;

            if(m == 1) {
                List<List<Integer>> partition = new ArrayList<>();
                partition.add(new ArrayList<>(ori));
                ret.add(partition);
                return ret;
            }

            // f(n-1, m)
            List<List<List<Integer>>> prev1 = helper(ori.subList(0, ori.size() - 1), m);
            for(int i=0; i<prev1.size(); i++) {
                for(int j=0; j<prev1.get(i).size(); j++) {
                    // Deep copy from prev1.get(i) to l
                    List<List<Integer>> l = new ArrayList<>();
                    for(List<Integer> inner : prev1.get(i)) {
                        l.add(new ArrayList<>(inner));
                    }

                    l.get(j).add(ori.get(ori.size()-1));
                    ret.add(l);
                }
            }

            List<Integer> set = new ArrayList<>();
            set.add(ori.get(ori.size() - 1));
            // f(n-1, m-1)
            List<List<List<Integer>>> prev2 = helper(ori.subList(0, ori.size() - 1), m - 1);
            for(int i=0; i<prev2.size(); i++) {
                List<List<Integer>> l = new ArrayList<>(prev2.get(i));
                l.add(set);
                ret.add(l);
            }

            return ret;
        }

        public void printAllPartitions(String str) {

        }
    }