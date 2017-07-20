//package Lab3;
//
///**
// Author: Salas Jaime
// Date: 7/3/17
// Course: 2401
// Assignment: Lab 3
// Instructor: Urenda, Julio
// */
//
//import java.util.*;
//
//public class Salas3{
//    private CircularList cl;
//
//    private int noOfPersons;
//
//    private int countToDeath;
//
//    public void members(){
//
//        System.out.print("Enter the number of people:");
//
//        Scanner in=new Scanner(System.in);
//
//        noOfPersons=in.nextInt();
//
//        System.out.print("Enter the number skip till death:");
//
//        countToDeath=in.nextInt();
//
//    }
//
//    public void buildCircular(){    //method for building a circular list
//
//        cl=new CircularList();
//        for(int i=1;i<=noOfPersons;i++)     // total number of people in the circle
//            cl.insert(i);
//        cl.disp();
//
//    }
//
//    public void start_Game(){
//        cl. SurvivalNumber (countToDeath-1, noOfPersons);
//        System.out.print("Then Survive is:");cl.disp();
//    }
//
//    public static void main(String args[]){
//        try{
//            Salas3 js=new Salas3(); //calls method from above
//            js.members();
//            js.buildCircular();
//            js.start_Game();
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//    }
//}
////CircularList.java
//
//class CircularList {            //Inserts the number of Nodes
//    private Nodes begin;
//    private int Count;
//    public void insert(int x){
//        Count++;
//        Nodes t1=new Nodes(x);
//        if(begin==null){
//            begin=t1;
//        }else{
//            Nodes tp=begin;
//            while(tp.link!=begin){
//                tp=tp.link;
//            }
//            tp.link=t1;
//        }
//        t1.link=begin;
//    }
//    public void insertFront(int x){    //Inserts Nodes in front
//        Count++;
//        Nodes t1=new Nodes(x);
//        if(begin==null){
//            t1.link=t1;
//        }else{
//            Nodes tp=begin;
//            while(tp.link!=begin){
//                tp=tp.link;
//            }
//            tp.link=t1;
//            t1.link=begin;
//        }
//        begin=t1;
//    }
//    public void insertAt(int position,int x){
//        Nodes t1,tp;
//        t1=new Nodes(x);
//        tp=begin;
//        for(int i=1;i<=position;i++){
//            if(tp.link==begin)
//                break;
//            tp=tp.link;
//        }
//        t1.link=tp.link;
//        tp.link=t1;
//        Count++;
//    }
//    public void disp(){
//        if(begin==null)
//            System.out.println("List is empty..");
//        else{
//            Nodes t1=begin;
//            System.out.println(" ");
//            while(t1.link!=begin){
//                System.out.print(" "+t1.data+" ");
//                t1=t1.link;
//            }
//            System.out.println(t1.data+" ");
//        }
//    }
//    public void deleteAt(int position){
//        Nodes cur=begin;
//        Nodes previous=begin;
//        for(int i=0;i<position;i++){
//            if(cur.link==begin)
//                break;
//            previous=cur;
//            cur=cur.link;
//        }
//        System.out.print(cur.data);
//        if(position==0)
//            deleteFirst();
//        else
//            previous.link=cur.link;
//        Count--;
//    }
//    public int deleteNodes(Nodes node){
//        Nodes cur=begin;
//        Nodes previous=begin;
//        int data=node.data;
//        while(cur.data!=data){
//            if(cur.link==begin)
//                break;
//            previous=cur;
//            cur=cur.link;
//        }
//        previous.link=cur.link;
//        Count--;
//        return data;
//    }
//    public void deleteFirst() {
//        Nodes t1=begin;
//        while(t1.link!=begin){
//            t1=t1.link;
//        }
//        t1.link=begin.link;
//        begin=begin.link;
//        Count--;
//    }
//    public int getCount(){
//        return Count;
//    }
//
//    public void SurvivalNumber(int EliminationNum,int NumofPeople){
//        Nodes cur=begin;
//        int cal=0;
//        while(true){
//            cal=cur.data;
//            for(int i=0;i< EliminationNum;i++){
//                cur=cur.link;
//            }
//            begin=cur.link;
//            if(getCount()>1){
//                if(cal==cur.data)
//                {deleteNodes(cur);
//                    disp();}
//                else
//                {deleteNodes(cur);
//                    disp();}
//            }else{
//                break;
//            }
//            cur=begin;
//        }
//    }
//    private static class Nodes{
//        int data;
//        Nodes link;
//        public Nodes(int data){
//            this.data=data;
//        }
//
//        public Nodes(int data,Nodes link){
//            this.data=data;
//            this.link=link;
//        }
//    }
//}