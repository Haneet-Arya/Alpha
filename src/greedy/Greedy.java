package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy {
    public static void main(String[] args) {
//        Driver for Fractional Knapsack
//        Scanner sc = new Scanner(System.in);
//        Item[] items = new Item[3];
//        for (int i = 0; i < 3; i++) {
//            items[i] = new Item(sc.nextInt(), sc.nextInt());
//        }
//        System.out.println(new Solution().fractionalKnapsack(50, items, 3));
//        System.out.println(kLargestOdd(-3,3,2));

//        System.out.println((char) ('a'+22));
        System.out.println(findPages(new int[]{15, 10, 19, 10, 5, 18, 7},7,5));

    }
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int min = A[0];
        int max = 0;
        int res = 0;
        for(int e: A){
            max+=e;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        while(min<=max){
            int mid = (max+min)>>1;
            System.out.println(mid);
            if(allocationPossible(mid,M,A)){
                max=mid-1;
                res = mid;
            }else{
                min = max+1;
            }
        }
        return res;
    }
    public static boolean allocationPossible(int mid, int M, int[] arr){
        int student = 1;
        int pages = 0;
        for(int e: arr){
            if(e>mid) return false;
            if(e+pages>mid){
                pages = e;
                student++;
            }else{
                pages+=e;
            }
        }
        return student<M;
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        return 0;
    }
    public static int kLargestOdd(int start, int end, int k){
        int oddFound = 0;
        for(int i = end;i>=start;i--){
            if((i&1)==1){
                oddFound++;
                if(oddFound==k) return i;
            }
        }
        return -1;
    }

    public static int maxBalancedString(String str){
        int l = 0;
        int r = 0;
        int count = 0;
        for (char e : str.toCharArray()) {
            if(e=='R'){
                r++;
            }else{
                l++;
            }
            if(l==r) {
                count++;
                l=0;
                r=0;
            }

        }
        return count;
    }

}




/*
Test Cases
60 10
100 20
120 30
 */
class Solution implements Comparator<Item>
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item[] arr, int n)
    {
        // Your code here
        double totalValue = 0;
        int totalWeight = 0;
        Arrays.sort(arr,this.reversed());
        for(Item item: arr){
            if(totalWeight+item.weight>W){
                int remainWeight = W-totalWeight;
                double remainValue = ((double)item.value/(double)item.weight) *remainWeight;
                totalValue+=remainValue;
                break;
            }
            totalValue += item.value;
            totalWeight +=item.weight;
        }
        System.out.println();
        return totalValue;

    }

    public int compare(Item a, Item b){
        int cmp = Double.compare((double) a.value / (double) a.weight, (double) b.value / (double) b.weight);
        System.out.println(cmp + " " + a.value + " " + b.value);
        return cmp;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

