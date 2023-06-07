package stack;

import java.util.Arrays;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        pushAtBottom(stack, 1);
//        reverseStack(stack);
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//        StockSpanner ss = new StockSpanner();
//        System.out.println(ss.next(100));
//        System.out.println(ss.next(80));
//        System.out.println(ss.next(60));
//        System.out.println(ss.next(70));
//        System.out.println(ss.next(60));
//        System.out.println(ss.next(75));
//        System.out.println(ss.next(85));

        int[] arr = {6, 8, 8, 1, 3};
        System.out.println(Arrays.toString(greaterElement(arr)));
    }



    public static int[] greaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            res[i] = (!stack.isEmpty())?stack.peek():-1;
            stack.push(arr[i]);
        }
        return res;
    }

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int curr = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, curr);
    }

    public static void pushAtBottom(Stack<Integer> stack, int item){
        if(stack.isEmpty()){
            stack.push(item);
            return;
        }
        int cur = stack.pop();
        pushAtBottom(stack, item);
        stack.push(cur);
    }
}
class StockSpanner {
    Stack<Helper> st;
    static int count = -1;
    int price;
    int index;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        Helper ht = new Helper(++count, price);
        while(!st.isEmpty()){
            Helper temp = st.peek();
//            System.out.println(temp.price);
            if(temp.price<=price){
                st.pop();
            }else{
                break;
            }
        }
        if(!st.isEmpty()){
            Helper temp = st.peek();
//            System.out.println(index + " " + temp.index);
            st.push(ht);
            return count-temp.index;
        }
//        System.out.println(this.price);
        st.push(ht);
        return count+1;
    }
    class Helper{
        int price;
        int index;
        public Helper(int index, int price){
            this.index = index;
            this.price = price;
        }
    }
}
