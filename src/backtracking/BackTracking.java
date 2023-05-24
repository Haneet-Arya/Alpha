package backtracking;

import java.util.Arrays;

public class BackTracking {
    public static void main(String[] args) {
//        int[] arr = new int[5];
//        backtrackArray(arr, 0);
//        System.out.println(Arrays.toString(arr));
//        subsetsOfStrings("abc","",0);
        findPermutationsOfString("abc","");
    }

    public static void findPermutationsOfString(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutationsOfString(newStr, ans+curr);
        }
    }

    public static void subsetsOfStrings(String str, String ans, int i){
        if(i>=str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else {
                System.out.println(ans);
            }
            return;
        }
//        Yes
        subsetsOfStrings(str, ans + str.charAt(i), i + 1);
//        No
        subsetsOfStrings(str, ans, i + 1);

    }
    public static void backtrackArray(int[] arr, int i){
        if (i >= arr.length) { // base case
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[i] = i+1;
        backtrackArray(arr, i + 1); // recursion
        arr[i]-=2; // backtracking step
    }
}
