package recursion;

public class Recursion {
     static String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) {
//        int[] arr = {1, 2, 4};
//        long time = System.currentTimeMillis();
//        System.out.println(optimisedPower(2, 30));
//        System.out.println(System.currentTimeMillis()-time);
//        time = System.currentTimeMillis();
//        System.out.println(power(2, 30));
//        System.out.println(System.currentTimeMillis()-time);
//        System.out.println(pairFriends(3))  ;

//        printBinString(3,0,new StringBuilder());
//        int[] arr = {1, 2, 4, 1};
//        findAllOccurances(arr, 1, 0);
//        convertToEnglish(1947,"");
        substringWithSameCharStartEnd("aba", 0,0,0);
    }

    public static void substringWithSameCharStartEnd(String str, int start, int end,int count) {
        if (start == str.length()) {
            System.out.println(count);
            return;
        }
        else if (end == str.length()) {
            substringWithSameCharStartEnd(str,start+1, start+1, count);
        }
        else if (str.charAt(start) == str.charAt(end)) {
            count++;
            substringWithSameCharStartEnd(str,start,end+1,count);
        }else{
            substringWithSameCharStartEnd(str,start,end+1,count);
        }

    }

    public static void convertToEnglish(int n, String str) {
        if(n==0){
            System.out.println(str);
            return;
        }
        str = numbers[n % 10] + " " + str;
        convertToEnglish(n/10, str);
    }


    public static void findAllOccurances(int[] arr, int key, int index) {
        if(index==arr.length) return;
        if(arr[index] == key) System.out.print(index + " ");
        findAllOccurances(arr, key, index+1);
    }

    public static void printNumberDec(int n) {
        if(n==0) return;
        System.out.println(n);
        printNumberDec(n - 1);
    }

    public static void printNumberInc(int n) {
        if(n==0) return;
        printNumberInc(n - 1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n==1) return 1;
        return n * factorial(n - 1);
    }

    public static int sumOfFirstNNaturalNumbers(int n) {
        if(n==1) return 1;
        return n + sumOfFirstNNaturalNumbers(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if(n==1) return 1;
        return fibonacci(n-1) + fibonacci(n - 2);
    }

    public static boolean isSorted(int i, int j, int[] arr) {
        if(j > arr.length-1) return true;
        if (arr[i] > arr[j]) return false;
        return isSorted(j, j + 1, arr);
    }
//    O(n)
    public static boolean isSorted(int i, int[] arr) {
        if(i == arr.length-1) return true;
        if (arr[i] > arr[i+1]) return false;
        return isSorted(i + 1, arr);
    }

    public static int lastOccurrence(int[] arr, int key, int i) {
        if(i==arr.length) return -1;
        int isFound = lastOccurrence(arr, key, i + 1);
        if(isFound==-1 && arr[i] == key) return i;
        return isFound;
    }
    public static int power(int a, int n){
        if(n==1) return a;
        return a * power(a, n - 1);
    }
    public static int optimisedPower(int a, int n){
        if(n==1) return a;
        if((n & 1)==1){
            int temp = optimisedPower(a, n/2);
            return a * temp * temp;
        }else{
            int temp = optimisedPower(a, n/2);
            return temp * temp;
        }
    }

    public static String removeDuplicates(String str, int index, StringBuilder stringBuilder, boolean[] map) {
        if(index==str.length()) return stringBuilder.toString();
        if(!map[str.charAt(index)-'a']){
            stringBuilder.append(str.charAt(index));
            map[str.charAt(index) - 'a'] = true;
        }
        index++;
        return removeDuplicates(str, index, stringBuilder, map);
    }

//    Pairing Friends with 2 or remain single
    public static int pairFriends(int n){
        if(n == 1 || n == 2) return n;
        int totalWays = pairFriends(n - 1) + (n - 1) * pairFriends(n - 2);
        return totalWays;
    }

    public static void printBinString(int n, int lastPlace, StringBuilder bin) {
//        base case
        if(n==0){
            System.out.println(bin);
            return;
        }
//        if(lastPlace==0){
//            printBinString(n - 1, 0, bin.append(0));
//            printBinString(n - 1, 1, bin.append(1));
//        }else{
//            printBinString(n - 1, 0, bin.append(0));
//        }
        printBinString(n-1, 0, new StringBuilder(bin).append(0));
        if(lastPlace == 0){
            printBinString(n - 1, 1, new StringBuilder(bin).append(1));
        }
    }
}
