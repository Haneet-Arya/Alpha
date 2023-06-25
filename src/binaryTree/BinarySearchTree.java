package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root = insert(null, 21);
        insert(root, 43);
        insert(root, 41);
        insert(root, 49);
        insert(root, 50);
        insert(root, 47);
//        inOrder(root);
//        System.out.println();
//        System.out.println(search(root, 43));
//        printInRange(root,20,48);
       rootToPath(root,new ArrayList<>());
    }

    public static void rootToPath(Node root, List<Node> list) {
        list.add(root);
        if (root.left == null && root.right == null) {
            System.out.println(list);
            list.remove(root);
            return;
        }
        if (root.left != null) {
            rootToPath(root.left,list);
        }
        if (root.right != null) {
            rootToPath(root.right,list);
        }
        list.remove(root);
    }

    public static void printInRange(Node root, int start, int end){
        if(root==null) return;
        if (root.val >= start && root.val <= end) {
            printInRange(root.left, start, end);
            System.out.println(root.val);
            printInRange(root.right,start,end);
        } else if (root.val < start) {
            printInRange(root.right,start,end);
        }else{
            printInRange(root.left,start,end);
        }

    }

    public static boolean search(Node root, int val) {
        if(root==null) return false;
        if(root.val==val) return true;
        return search(root.left, val) || search(root.right, val);
    }

    public static Node delete(Node root, int val) {
        if(root == null) return null;
        if (root.val < val) {
            root.right =  delete(root.right, val);
        } else if (root.val > val) {
            root.left =  delete(root.left, val);
        }else{// found the value
            if (root.left == null && root.right == null) {
//                leaf node
                return null;
            } else if (root.left == null) {
//                right child only
                return root.right;
            } else if (root.right == null) {
//                left child only
                return root.left;
            }else{
//                both left and right child then get the inorder successor. and replace the current val
//                with it and delete the successor node
//                inorder successor will be just bigger than current val while doing inorder traversal
//                it will be leftmost element of right part
                Node iS = inorderSuccessor(root.right);
                root.val = iS.val;
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        if(root.left==null) return root;
        return inorderSuccessor(root.left);
    }

    public static void inOrder(Node root) {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    static class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
