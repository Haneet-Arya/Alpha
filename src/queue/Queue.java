package queue;

import java.util.*;

public class Queue {
//    int[] arr = new int[10];
//    int front = -1;
//    int rear = -1;
    int size = 0;

//    public void add(int n) {
//        if (size == arr.length) {
//            System.out.println("Queue is full");
//            return;
//        }
//        if(front==-1){
//            front = 0;
//        }
//        arr[++rear] = n;
//        size++;
//
//    }
//
//    public int remove(){
//        if(size==0){
//            System.out.println("Queue is empty");
//            return -1;
//        }
//        size--;
//        int temp = arr[front];
//        for (int i = 0; i < arr.length - 1; i++) {
//            arr[i] = arr[i + 1];
//        }
//        arr[arr.length - 1] = -1;
//        rear--;
//        return temp;
//    }
    public boolean isEmpty(){
        return size == 0;
    }
//    public void printQueue(){
//        while (!isEmpty()) {
//            System.out.println(remove());
//        }
//    }

    Node head = null;
    Node tail = null;

    public void add(int n) {
        if(head==null){
            head = new Node(n);
            tail = head;
            size++;
            return;
        }
        Node newNode = new Node(n);
        size++;
        tail.next = newNode;
        tail = newNode;
    }

    public int remove() {
        if (head == null) {
            System.out.println("Empty Queue");
            return -1;
        }
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = head;
        }
        size--;
        return temp.data;
    }
    public void printQueue(){
        while (!isEmpty()) {
            System.out.println(remove());
        }
    }
    public static void main(String[] args) {
//        Queue queue = new Queue();
//        java.util.Queue<Integer> queue = new LinkedList<>();
//        queue.add(2);
//        queue.add(12);
//        queue.printQueue();
//        queue.remove();
//        queue.add(22);
//        queue.add(26);
//        queue.printQueue();
//        while (!queue.isEmpty()) {
//            System.out.println(queue.remove());

//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.addLast(3);
//        deque.addLast(4);
//        deque.removeFirst();
//        deque.removeLast();

//        generating binary numbers using queue
//        java.util.Queue<String> q = new LinkedList<>();
//        q.add("1");
//        int i = 0;
//        while (i++ < 10) {
//            String s = q.peek();
//            System.out.println(q.remove());
//            q.add(s + '0');
//            q.add(s + '1');
//        }


//        java.util.Queue<Integer> q = new LinkedList<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        q.add(40);
//        q.add(50);
//        q.add(60);
//        q.add(70);
//        q.add(80);
//        q.add(90);
//        q.add(100);
//        reverseKElements(q,5);
//        System.out.println(q);
//        System.out.println(maxOfSubArrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6},3));
        maxOfSubArrays(new int[]{12, 1, 78, 90, 57, 89, 56},3);
    }


    //Maximum of all sub-arrays of size K
    public static void maxOfSubArrays(int[] arr, int k) {
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i) {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                    && arr[i] >= arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < arr.length; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }

    //        reverse first k elements in queue
    public static void reverseKElements(java.util.Queue<Integer> queue,int k) {
        Stack<Integer> stack = new Stack<>();
        int i =0;
        while (i++ < k) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        i=0;
        while (i++ < queue.size() - k) {
            queue.add(queue.poll());
        }
    }


    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}


