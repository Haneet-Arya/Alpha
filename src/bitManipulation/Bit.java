package bitManipulation;

public class Bit {
    public static void main(String[] args) {
//        System.out.println(5<<2);
//        System.out.println(5>>1)
//        System.out.println(isEven(5));
//        getIthBit(3,1);
//        clearIthBit(3,1);

//        System.out.println(fastExpRec(2,5));
//        swap(5, 10);
        System.out.println(add1(3));
    }

    public static boolean isEven(int a){
        return (a & 1) == 0;
    }
    public static void getIthBit(int n, int i){
        int bitMask = 1 << i;
        if((n&bitMask)==0) System.out.println(0);
        else System.out.println(1);
    }
    public static void setIthBit(int n, int i){
        int bitMask = 1 << i;
        System.out.println(n | bitMask);
    }
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1 << i);
        System.out.println(n & bitMask);
        return n & bitMask;
    }
    public static int updateIthBit(int n, int i, int newBit){
//        if(newBit==1) setIthBit(n, i);
//        else clearIthBit(n, i);

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;

    }
    public static int clearLastIBits(int n, int i){
        int bitMask = (~0) << i;
        return n & bitMask;
    }
    public static int clearBitRange(int n, int start, int end){
        int a = (~0) << end;
//        int b = ~((~0) << start);
        int b = (1 << start) - 1;
        return n & (a | b);
    }
    public boolean isPowerOf2(int n){
        return (n & (n-1)) == 0;
    }
    public static int countOne(int n){
        int count = 0;
//        no of bits in a number = logn+1
//        so time complexity = O(logn)
        while(n!=0){
            if((n&1)==1) count++;
            n = n >> 1;
        }
        return count;
    }

    public static int fastExp(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if((n&1)!=0){
                ans = ans*a;
            }
            a=a*a;
            n = n >> 1;
        }
        return ans;
    }
    public static int fastExpRec(int n, int pow){
        if(pow <= 1) return n;
        if((pow & 1)==1) return n * fastExpRec(n * n, pow / 2);
        else return fastExpRec(n * n, pow / 2);
    }
    public static void swap(int a, int b){
        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
    public static int add1(int a) {
        return -~a;
    }
}
