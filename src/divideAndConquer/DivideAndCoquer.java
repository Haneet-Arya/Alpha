package divideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class DivideAndCoquer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i< n;i++){
            arr[i] = sc.nextLong();
        }
//        quickSort(arr,0, arr.length-1);
//        String[] str = { "sun", "earth", "mars", "mercury"};
//        sortStringsUsingMergeSort(str,0,str.length-1);
//        System.out.println(Arrays.toString(str));
                System.out.println(countInversion(arr, 0, arr.length - 1));
    }
    static int countInversion(long[] arr, int start, int end){
        if(start>=end) return 0;
        int mid = start + (end-start)/2;
        int count = 0;
        count += countInversion(arr,start,mid);
        count+= countInversion(arr,mid+1,end);

        long[] temp = new long[start+end+1];
        int k = 0;
        int i = start;
        int j = mid+1;
        while(k < temp.length){
            if(i<=mid && j<=end){
                if(arr[i]<=arr[j]){
                    temp[k] = arr[i];
                    i++;
                }else{
                    temp[k] = arr[j];
                    j++;
//                    count += mid+1-i
//                    because the left part is sorted so all the number after the current value and before the start
//                    of right part will be greater, so all the inversions will be counted
//                    mid+1 is the starting of right part and i is the current index, so it will be subtracted
//                    to get number of values greater than the number which is in right part of the array
                    count+=mid+1-i;
                }
            }else if(i<=mid){
                temp[k] = arr[i];
                i++;
            }else if(j<=end){
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        k = 0;
        for(int s = start;s <= end; s++,k++){
            arr[s] = temp[k];
        }
        return count;
    }

    public static int countInversion(int[] arr, int start, int end){
//        base case
        if(start>=end) return 0;
        int count = 0;
        int mid = start + (end - start)/2;
        int leftInversion = countInversion(arr, start, mid);
        int rightInversion = countInversion(arr, mid + 1, end);
//        merging arrays
        int[] temp = new int[end-start+1];
        int i1 = start;
        int i2 = mid+1;
        int k = 0;
        while(k<temp.length){
            if(i1<= mid && i2<= end){
                if(arr[i2]<arr[i1]){
                    temp[k] = arr[i2];
                    count+=mid-i1+1;
                    i2++;
                }else{
                    temp[k] = arr[i1];
                    i1++;
                }
            }else if(i1<= mid){
                temp[k] = arr[i1];
                i1++;
            }else if(i2<=end){
                temp[k] = arr[i2];
                i2++;
            }
            k++;
        }
        k = 0;
        for(int i = start; i <= end; i++,k++){
            arr[i] = temp[k];
        }
        return count + leftInversion + rightInversion;
    }

    public static void sortStringsUsingMergeSort(String[] str,int start,int end){
        if(start>=end) return;
        int mid = start + (end-start)/2;
        sortStringsUsingMergeSort(str, start, mid);
        sortStringsUsingMergeSort(str, mid + 1, end);
        String[] temp = new String[end - start + 1];
        int k = 0;
        int i = start;
        int j = mid+1;
        while (k < temp.length) {
            if(i<=mid && j<=end){
                if(str[i].compareTo(str[j])<=0){
                    temp[k] = str[i];
                    i++;
                }else{
                    temp[k] = str[j];
                    j++;
                }
            }
            else if (i <= mid) {
                temp[k] = str[i];
                i++;
            }else{
                temp[k] = str[j];
                j++;
            }
            k++;
        }
        k=0;
        for (int l = start; l <= end; l++) {
            str[l] = temp[k];
            k++;
        }
    }

    //    Quick Sort
//    O(n^2) for worst case, O(nlogn) average case and O(1) space
//    Pivot and partition approach
//    Pivot can be a random number or median or first number or last number
//    Taking last element as pivot
    public static void quickSort(int[] arr, int start, int end) {
        if(start>=end) return;
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[end]) {
                int temp = arr[++j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
//        calling for left part
        quickSort(arr,start, j-1);
//        calling for right part
        quickSort(arr, j +1,end);
    }

//    merge sort
//    O(logn) time & O(n) space
    public static void mergeSort(int[] arr, int start, int end){
//        base case
        if(start>=end) return;
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
//        merging arrays
        int[] temp = new int[end-start+1];
        int i1 = start;
        int i2 = mid+1;
        int k = 0;
        while(k<temp.length){
            if(i1<= mid && i2<= end){
                if(arr[i2]<arr[i1]){
                    temp[k] = arr[i2];
                    i2++;
                }else{
                    temp[k] = arr[i1];
                    i1++;
                }
            }else if(i1<= mid){
                temp[k] = arr[i1];
                i1++;
            }else if(i2<=end){
                temp[k] = arr[i2];
                i2++;
            }
            k++;
        }
        k = 0;
        for(int i = start; i <= end; i++,k++){
            arr[i] = temp[k];
        }
    }
}
