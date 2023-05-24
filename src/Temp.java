import java.util.*;

public class Temp {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        System.out.println(Arrays.toString(searchRange(arr,5)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        int first = 0;
        int last = nums.length-1;
        while(first<=last){
            System.out.println("while");
            int mid = (first+last)/2;
            if(nums[mid]==target){
                // check if any number is before
                start = mid;
                for(int i = start-1;i>=0;i--){
                    if(nums[i]==nums[start]){
                        start=i;
                    }
                }
                end = mid;
                for(int i = end+1; i< nums.length;i++){
                    if(nums[i]==nums[end]){
                        end=i;
                    }
                }
                break;
            }else if(nums[mid]<target)first = mid+1;
            else last = mid-1;
        }
        int[] res = new int[2];
        res[0] = start;
        res[1] = end;
        return res;
    }

}