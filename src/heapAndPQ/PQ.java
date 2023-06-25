package heapAndPQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQ {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(5);
//        pq.add(4);
//        pq.add(9);
//        pq.add(1);
//        System.out.println(pq);
//        while (!pq.isEmpty()) {
//            System.out.println(pq.remove());
//        }

        System.out.println(minTime(new int[]{1, 2, 3, 4, 5}, 5,5));
    }
    // Minimum time required to fill given N slots
    public static int minTime(int[] arr, int n, int size){
        Arrays.sort(arr);
        int maxDist = Integer.MIN_VALUE;
        for(int i = 0; i < size-1;i++){
            maxDist = Math.max(maxDist, arr[i + 1] - arr[i] - 1);
        }
        maxDist = Math.max(maxDist, arr[0] - 1);
        maxDist = Math.max(maxDist, n - arr[size - 1]);

        maxDist--;
        return maxDist;
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] vis = new boolean[n];
//        for(int e: arr){
//            q.add(e);
//            vis[e - 1] = true;
//        }
//        int time = 0;
//        while (!q.isEmpty()) {
//            int qSize = q.size();
//            for (int i = 0; i < qSize; i++) {
//                int cur = q.poll();
//                int left = cur-1;
//                int right = cur+1;
//                if(left>0 && !vis[left-1]){
//                    vis[left-1] = true;
//                    q.add(left);
//                }
//                if(right<=n && !vis[right-1]){
//                    vis[right-1] = true;
//                    q.add(right);
//                }
//            }
//            time++;

//        }
//        return time;

    }
    static class Help implements Comparable<Help>{

        @Override
        public int compareTo(Help o) {
            return 0;
        }
    }
}
