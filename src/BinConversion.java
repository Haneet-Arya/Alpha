public class BinConversion {
    public static void main(String[] args) {
        decToBin(11);
//        System.out.println(2 + 100 * 0);
    }

    public static void decToBin(int n) {
        int pow = 0;
        int bin = 0;
        while (n > 0) {
            int rem = n % 2;
            bin = bin + (rem * (int) Math.pow(10, pow));
            System.out.println(bin);
            n = n / 2;
            pow++;
        }
        System.out.println(bin);
    }
}
