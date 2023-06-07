package linkedList;

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size=0;

    public void addFirst(int data) { // O(1)
//        new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

//        newNode next = head
        newNode.next = head;
//        changing head
        head = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if(index>=size){
            System.out.println("Index Problem");
            return;
        }
        int i = 0;
        Node temp = head;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    public int removeFirst(){
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            return removeFirst();
        }else if(size==1){
            return removeFirst();
        }
        Node prev = head;
        for(int i = 0; i < size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) { // O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recSearch(int key){ // O(n)
        return recSearchHelper(head, key);
    }

    public int recSearchHelper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int res = recSearchHelper(head.next,key);
        return (res==-1)?-1:res+1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head; // head becomes tail
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid
    }

    public boolean checkPalindrome(){
        if (head == null || head.next==null) {
            return true;
        }

        // mid
        Node mid = findMid(head);

//         reverse second half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // head of right half
        Node left = head;

        //check left half = right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;

    }
    public Node removeCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                Node prev = null;
                while(fast!=slow){
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                prev.next = null; // removing cycle
                return slow; // returning the position where cycle starts
            }

        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(12);
        ll.addLast(13);
        ll.addLast(12);
        ll.addLast(10);
        ll.tail.next = ll.head.next;
//        ll.removeCycle(ll.head);
//        ll.removeFirst();
//        ll.removeLast();
//        ll.reverse();
//        System.out.println(ll.checkPalindrome());
        ll.print();
//        ll.findMid(ll.head);
//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.recSearch(3));

    }

}
