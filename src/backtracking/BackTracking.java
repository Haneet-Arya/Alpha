package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking {
    static int countNQueens = 0;
    public static void main(String[] args) {
//        int[] arr = new int[5];
//        backtrackArray(arr, 0);
//        System.out.println(Arrays.toString(arr));
//        subsetsOfStrings("abc","",0);
//        findPermutationsOfString("abc","");
//        int n = 5;
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = 'x';
//            }
//        }
//        if(nQueens(board, 0)) {
//            printBoard(board);
//        }else{
//            System.out.println("Solution not ppissible");
//        }
//        int n = 36828800;
//        System.out.println(gridWays(0,0,4,4));
//        int m[][] = {{1, 0, 0, 0},
//            {1, 1, 0, 1},
//            {1, 1, 0, 0},
//            {0, 1, 1, 1}};
//        System.out.println(findPath(m,4));
        System.out.println(knightTour(3,3));
    }

    public static ArrayList<ArrayList<Integer>> knightTour(int n, int m) {

        // Write your code here.
        int[][] board = new int[n][m];
        for(int i = 0; i<n;i++){
            for(int j = 0; j < m;j++){
                board[i][j]=-1;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        knightUtil(board, 0, 0, 0);
        for(int i = 0; i < n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<m;j++){
                temp.add(board[i][j]);
            }
            res.add(temp);
        }
        return res;
    }

    public static boolean knightUtil(int[][] board,int row, int col, int moves){
        if(moves>=board.length*board[0].length-1){
            // base case
            System.out.println("Base Case");
            return true;
        }
        System.out.println(row + " " + col +" " +moves);
        board[row][col]=moves;
        if(isSafe(board, row+2, col+1)){
            if(knightUtil(board,row+2,col+1,moves+1)){
                return true;
            }
        }
        if(isSafe(board, row-2, col+1)){
            if(knightUtil(board, row-2, col+1, moves+1)){
                return true;
            }
        }
        if(isSafe(board, row+2, col-1)){
            if(knightUtil(board, row+2, col-1, moves+1)){
                return true;
            }
        }
        if(isSafe(board, row-2, col-1)){
            if(knightUtil(board, row-2, col-1, moves+1)){
                return true;
            }
        }
        if(isSafe(board, row+1, col+2)){
            if(knightUtil(board, row+1, col+2, moves+1)){
                return true;
            }
        }
        if(isSafe(board, row-1, col+2)){
            if(knightUtil(board, row-1, col+2, moves+1)){
                return true;
            }
        }if(isSafe(board, row+1, col-2)){
            if(knightUtil(board, row+1, col-2, moves+1)){
                return true;
            }
        }if(isSafe(board, row-1, col-2)){
            if(knightUtil(board, row-1, col-2, moves+1)){
                return true;
            }
        }
        board[row][col]=-1;
        return false;

    }
    public static boolean isSafe(int[][] board, int row, int col){
        return (row>=0 && row<board.length && col>=0 && col < board[0].length && board[row][col]==-1);
    }
    static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        helper(m,"",0,0);
        return res;
    }
    public static void helper(int[][] m, String ans, int row, int col){
        System.out.println(row + " " + col);
        if(row==m.length-1 && col==m.length-1){
            res.add(ans);
            return;
        }
        if(m[row][col]==0){
            return;
        }
        m[row][col]=0;
        if(row!=0){
            if(m[row-1][col]==1) {
                helper(m, ans + "U", row - 1, col);
            }
        }if(col!=0){
            if(m[row][col-1]==1) {
                helper(m, ans + "L", row, col - 1);
            }
        }if(row!=m.length-1){
            if(m[row+1][col]==1) {
                helper(m, ans + "D", row + 1, col);
            }
        }if(col!=m.length-1){
            if(m[row][col+1]==1) {
                helper(m, ans + "R", row, col + 1);
            }
        }
        m[row][col]=1;
    }

    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }else if(i==n || j==n){
            return 0;
        }
        return gridWays(i + 1, j, n, m) + gridWays(i, j + 1, n, m);
    }

    public static boolean nQueens(char[][] board, int row) {
        if( row == board.length){
//            printBoard(board);
            countNQueens++;
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                if(nQueens(board, row + 1)){// recursion
                    return true;
                }
                board[row][i] = 'x'; // backtracking step
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board,int row,int col){
//        vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
//        diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
//        diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------Chess Board----------");
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
//        System.out.println("---------Chess Board----------");
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
