package Testers;


import Testers.LabInterfaces.Lab7Interface;
import sun.jvm.hotspot.HelloWorld;

import java.util.ArrayList;

/**
 * Author: Isaac Torres
 * Date: 7/27/17.
 * Course:
 * Assignment:
 * Instructor:
 * T.A:
 */
public class Lab7Tester {
    static class Node{
        int key;
        Node l;
        Node r;

        public Node(int key, Node l, Node r) {
            this.key = key;
            this.l = l;
            this.r = r;
        }

        public int depthOfKeyV2(Node node, int key){
            if (node == null) return -1;
            if (node.key == key) return 0;
            int leftSubtree = depthOfKeyV2(node.l, key);
            int rightSubtree = depthOfKeyV2(node.r, key);
            if (leftSubtree == -1 && rightSubtree == -1) return -1;
            if (leftSubtree == -1) return 1+rightSubtree;
            return 1+leftSubtree;
        }
    }



    static class TreeNode {
        String data;
        TreeNode parent;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(String data,  TreeNode parent,  TreeNode leftChild,  TreeNode rightChild) {
            this.data = data;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    static class SternBrocotTree{
        TreeNode root;

        public SternBrocotTree(int depth) {
            if (depth >= 0){
                root = new TreeNode("1/1",null,null,null);
                if (depth > 0){
                    root.leftChild = new TreeNode(null,root,null,null);
                    root.rightChild = new TreeNode(null,root,null,null);
                    buildSternBrocot(root.leftChild,depth-1);
                    buildSternBrocot(root.rightChild,depth-1);
                }
            }
        }
        public boolean isEmpty(){
            return root == null;
        }
        public static String getLeftFraction(TreeNode node){
            TreeNode parent = node.parent;
            if (parent == null) return "0/1";
            else {
                if (parent.rightChild == node) return parent.data;
                return getLeftFraction(parent);
            }
        }
        public static String getRightFraction(TreeNode node){
            TreeNode parent = node.parent;
            if (parent == null) return "1/0";
            else {
                if (parent.leftChild == node) return parent.data;
                return getRightFraction(parent);
            }
        }
        public static void buildSternBrocot(TreeNode node, int depth){
            String[] leftFraction = getLeftFraction(node).split("/");
            String[] rightFraction = getRightFraction(node).split("/");
            int numeratorSum = Integer.parseInt(leftFraction[0])+Integer.parseInt(rightFraction[0]);
            int denominatorSum = Integer.parseInt(leftFraction[1])+Integer.parseInt(rightFraction[1]);
            node.data = numeratorSum+"/"+denominatorSum;
            if (depth > 0){
                node.leftChild = new TreeNode(null,node,null,null);
                node.rightChild = new TreeNode(null,node,null,null);
                buildSternBrocot(node.leftChild,depth-1);
                buildSternBrocot(node.rightChild,depth-1);
            }
        }

        //Pre Order
        public ArrayList<String> preOrder(){
            ArrayList<String> elements = new ArrayList<>();
            preOrderHelper(elements,root);
            return elements;
        }
        public void preOrderHelper(ArrayList<String> elements, TreeNode node){
            if (node != null){
                elements.add(node.data);
                preOrderHelper(elements,node.leftChild);
                preOrderHelper(elements,node.rightChild);
            }
        }

        //In order
        public ArrayList<String> inOrder(){
            ArrayList<String> elements = new ArrayList<>();
            inOrderHelper(elements,root);
            return elements;
        }
        public void inOrderHelper(ArrayList<String> elements, TreeNode node){
            if (node != null){
                inOrderHelper(elements,node.leftChild);
                elements.add(node.data);
                inOrderHelper(elements,node.rightChild);
            }
        }

        //Post Order
        public ArrayList<String> postOrder(){
            ArrayList<String> elements = new ArrayList<>();
            postOrderHelper(elements,root);
            return elements;
        }
        public void postOrderHelper(ArrayList<String> elements, TreeNode node){
            if (node != null){
                postOrderHelper(elements,node.leftChild);
                postOrderHelper(elements,node.rightChild);
                elements.add(node.data);
            }
        }
    }

    public ArrayList<String> sternBrocotTreePreOrder(int depth) {
        if (depth >= 0) {
            SternBrocotTree t = new SternBrocotTree(depth);
            return t.preOrder();
        }
        return null;
    }
    public ArrayList<String> sternBrocotTreeInOrder(int depth) {
        if (depth >= 0) {
            SternBrocotTree t = new SternBrocotTree(depth);
            return t.inOrder();
        }
        return null;
    }
    public ArrayList<String> sternBrocotTreePostOrder(int depth) {
        if (depth >= 0) {
            SternBrocotTree t = new SternBrocotTree(depth);
            return t.postOrder();
        }
        return null;
    }

    public static int getDepth(TreeNode n){
        if (n == null) return -1;
        else{
            int left = getDepth(n.leftChild);
            int right = getDepth( n.rightChild);
            if (left>right) return 1+left;
            return 1+right;
        }
    }
//
//    @Override
//    public ArrayList<String> sternBrocotTreePreOrder(int depth) {
//        return null;
//    }

    public static boolean checker(ArrayList<String> t,ArrayList<String> s){
        if (t.size() != s.size()) return false;
        for (int i = 0; i < t.size(); i++) {
            if (!t.get(i).equals(s.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] testArray = new int[1];
        System.out.println(testArray);
        int[] testArray2 = new int[6];
        System.out.println(testArray2);
        SternBrocotTree tree = new SternBrocotTree(3);
        System.out.println(tree);
        System.out.println(tree);
        System.out.println(getDepth(tree.root));

        Lab6Tester k = new Lab6Tester();
        System.out.println(k.listPrefixCalc(""));

        int depth = 3;
        Lab7Tester tester = new Lab7Tester();
        ArrayList<String> t = tester.sternBrocotTreePreOrder(depth);
        System.out.println(t);
        t = tester.sternBrocotTreeInOrder(depth);
        System.out.println(t);
        t = tester.sternBrocotTreePostOrder(depth);
        System.out.println(t);

    }
}
