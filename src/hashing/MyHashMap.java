package hashing;

import java.util.LinkedList;

public class MyHashMap{
    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n = 0;
        private int N;
        private LinkedList<Node>[] buckets; // N = buckets.length

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) %n;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(Node e: ll){
                if(e.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        private void rehash(){
            
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
            n++;
        }
    }

    public static void main(String[] args) {

    }
}
