package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeClass {
    //    Queue using Deque
    Deque<Integer> q = new ArrayDeque<>();

    public void add(int x) {
        q.addLast(x);
    }
    public int remove(){
        return q.removeFirst();
    }
    public static void main(String[] args) {
        DequeClass d = new DequeClass();
        d.add(5);
        d.add(15);
        d.add(54);
        d.add(51);
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());
    }
}
