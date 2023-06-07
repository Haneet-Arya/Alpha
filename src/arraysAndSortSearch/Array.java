package arraysAndSortSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
//        int[][] arr = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
//        reverseArray(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        arr = java.util.Arrays.stream(arr).sorted().toArray();
//        System.out.println(binarySearch(arr, 45));

//        makePairFromArray(arr);
//        printAllSubarrays(arr);

//        maxSubarraySumUsingPrefixSum(arr);
//        maxSubrraySumUsingKadane(arr);
//        transpose(arr);
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

        int[] arr = {11, 15, 6, 8, 9, 10};
        pairSum2(arr,16);

    }

    public static void pairSum2(int[] arr, int target){
        int pivot=-1;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]>arr[i+1]){
                pivot = i;
                break;
            }
        }
        int start = pivot+1;
        int end = pivot;
        while (start != end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                System.out.println(arr[start] + " " + arr[end]);
                start = (start + 1) % arr.length;
                end = (end + arr.length - 1) % arr.length;

            }else if(sum<target){
                start = (start + 1) % arr.length;
            }else{
                end = (end + arr.length - 1) % arr.length;
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        List<Integer> temp = new ArrayList<>();
        while(start<end){
            int twoSum = nums[start] + nums[end];
            if(temp.contains(-twoSum)){
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                list.add(-twoSum);
                ret.add(list);
                temp.add(nums[start]);
                temp.add(nums[end]);
            }else if(twoSum>0){
                temp.add(nums[end]);
                end--;
            }else{
                temp.add(nums[start]);
                start++;
            }
        }
        return ret;
    }


    public int largest(int[] arr) {
        int largest = Integer.MIN_VALUE; //- infinity
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) largest = arr[i];
        }
        return largest;
    }


    //    TC = O(N), SC = O(1)
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public static void makePairFromArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void printAllSubarrays(int[] arr) {
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.print("Sum = " + sum);
                maxSum = Math.max(maxSum, sum);
                minSum = Math.min(minSum, sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Maxsum = " + maxSum);
        System.out.println("Minsum = " + minSum);
    }


    public static void maxSubarraySumUsingPrefixSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int[] prefix = new int[arr.length];
        // making prefix array
        for (int i = 0; i < arr.length; i++) {
            prefix[i] = (i == 0) ? arr[i] : prefix[i - 1] + arr[i];
        }
        for (int start = 0; start < arr.length; start++) {
            for (int end = 0; end < arr.length; end++) {
                curSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];
            }
            maxSum = Math.max(curSum, maxSum);
        }
        System.out.println("MaxSum = " + maxSum);
    }


    public static void maxSubrraySumUsingKadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int allNeg = 0;
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) max = j;
            if (j > 0) allNeg = 1;
            currSum += j;
            if (currSum < 0) currSum = 0;
            maxSum = Math.max(currSum, maxSum);
        }
        if (allNeg == 0) maxSum = max;
        System.out.println(maxSum);
    }

    public static int binarySearch(int[] numbers, int key) {
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == key) return -1;
            else if (numbers[mid] < key) {
                start = mid + 1;
            } else if (numbers[mid] > key) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
//                    System.out.println(temp);
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(nums));
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        System.out.println(java.util.Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int prev = i - 1;
            while (prev >= 0 && nums[prev] > cur) {
                nums[prev + 1] = nums[prev];
                prev--;
            }
            nums[prev + 1] = cur;
        }
        System.out.println(java.util.Arrays.toString(nums));
    }

    public static void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] countArray = new int[max + 1];
        for (int num : nums) {
            countArray[num]++;
        }
//        int i = 0;
//        int j = 0;
//        while (i < countArray.length && j < nums.length) {
//            if(countArray[i]>0){
//                nums[j] = i;
//                countArray[i]--;
//                j++;
//            }
//            if(countArray[i]<=0){
//                i++;
//            }
//        }
        int j = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                nums[j] = i;
                j++;
                countArray[i]--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //    Transpose
    public static void transpose(int[][] num) {
        int[][] transpose = new int[num[0].length][num.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                transpose[j][i] = num[i][j];
            }
        }
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

    }


}
