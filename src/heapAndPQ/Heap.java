package heapAndPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    List<Integer> list = new ArrayList<>();

    public void add(int e){ // O(logn)
        list.add(e);
        int x = list.size()-1; // x is child index
        int par = (x-1)/2; // parent index
        while (list.get(x) < list.get(par)) { // use greater than for max heap
            int temp = list.get(x);
            list.set(x, list.get(par));
            list.set(par, temp);
            x = par;
            par = (x-1)/2;
        }
    }
    // get min
    public int peek(){
        if(list.isEmpty()) return -1;
        return list.get(0);
    }

    public int remove(){
//        swap the first and last element
        int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);

//        delete last
        list.remove(list.size() - 1);

//        heapify
        heapify(0);
        return temp;
    }

    private void heapify(int i) { // O(logn)

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
//        min will become max for max heap
        if (left < list.size() && list.get(left) < list.get(min)) {// use greater than for max heap
            min = left;
        }
        if (right < list.size() && list.get(right) < list.get(min)) {// use greater than for max heap
            min = right;
        }
        if (min != i) {
//            swap
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
            heapify(min);
        }
    }

    public static void heapSort(int[] arr){ // nlogn
        int n = arr.length;
        // build max heap
        for (int i = n / 2; i >= 0; i--) { // node of index greater than n/2 will be already a heap as they are leaf nodes
            // only for non leaf nodes
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            // push the largest element to last
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
//            call for heapify neglecting the value pushed to last
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }
    public static void main(String[] args) {
//        Heap heap = new Heap();
//        heap.add(21);
//        heap.add(2);
//        heap.add(5);
//        heap.add(0);
//        while (!heap.isEmpty()) {
//            System.out.println(heap.peek());
//            heap.remove();
//        }
//        this heap is also called Priority queue
//        This data structure is used for heap sort

        int[] arr = {5, 7, 2, 1, 9};
        heapSort(arr); // ascending order for descending use min heap instead max heap
        System.out.println(Arrays.toString(arr));

    }
}
