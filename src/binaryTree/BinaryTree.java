package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int idx = -1;
    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node buildTree(int[] arr) {
        idx++;
        if(arr[idx]==-1) return null;
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    public static void preOrder(Node root) {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root) {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root) {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                continue;
            }
            System.out.print(curNode.data +" ");

            if (curNode.left != null) {
                queue.add(curNode.left);

            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }

        }
    }
    public static int getHeight(Node root){
        if(root==null) return 0;
        int leftHeight = (root.left == null) ? 0 : getHeight(root.left);
        int rightHeight = (root.right == null) ? 0 : getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) +1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    //    longest length between two leaf nodes
    public static int diameterOfTree(Node root) { // Approach 1 O(n^2)
        if(root==null) return 0;
        int leftD = diameterOfTree(root.left);
        int rightD = diameterOfTree(root.right);
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight + rightHeight+1, Math.max(leftD, rightD));
    }
//    approach 2
    static class Info{
        int height,diameter;

        public Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

    @Override
    public String toString() {
        return "Height: " + height + " Diameter: " + diameter;
    }
}

    public static Info diameter2(Node root) { // O(n)
        if (root == null) {
            return null;
        }
        Info left = diameter2(root.left);
        Info right = diameter2(root.right);
        int leftHeight = 0;
        int rightHeight = 0;
        int leftD = 0;
        int rightD = 0;
        if (left != null) {
            leftHeight = left.height;
            leftD = left.diameter;
        }
        if (right != null) {
            rightD = right.diameter;
            rightHeight = right.height;
        }
        return new Info(Math.max(leftHeight, rightHeight)+1, Math.max(leftHeight + rightHeight + 1, Math.max(leftD, rightD)));
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
//        System.out.println(root.data);
//        preOrder(root);
//        inOrder(root);
//        levelOrder(root);
//        System.out.println(getHeight(root));
//        System.out.println(countNodes(root));
//        System.out.println(sumOfNodes(root));
//        System.out.println(diameterOfTree(root));
//        System.out.println(diameter2(root));
    }
}
