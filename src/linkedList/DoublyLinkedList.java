package linkedList;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node prev,next;
        public Node(int val){
            data = val;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void printReverse(){
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public int removeFirst(){
        if (head == null) {
            System.out.println("Empty List");
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp.data;
    }

    public void addLast(int val) {
        if (tail == null) {
            addFirst(val);
            return;
        }
        Node temp = new Node(val);
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
        size++;
    }

    public int removeLast() {
        if (tail == null) {
            System.out.println("Empty List");
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp.data;
    }

    public void reverse() {
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = temp.prev;
            temp.prev = next;
            temp = next;
        }
        Node tempTail = tail;
        tail = head;
        head = tempTail;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(20);
        dll.addLast(2);
        dll.addLast(1);
        dll.addLast(3);
        dll.addLast(5);
//        System.out.println(dll.size);
        dll.print();
//        System.out.println(dll.removeFirst());
//        System.out.println(dll.size);
//        System.out.println(dll.removeLast());
//        dll.printReverse();
        dll.reverse();
        dll.print();
//        dll.printReverse();
    }
}
