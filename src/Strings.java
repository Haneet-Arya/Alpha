public class Strings {
    public static void main(String[] args) {
        System.out.println(compress("aaabbcccdd"));
    }
//    String Compression
    public static String compress(String str){
        char[] s = str.toCharArray();
        char prev = s[0];
        StringBuilder res = new StringBuilder();
        res.append(prev);
        int count = 1;
        for(int i = 1; i< s.length; i++){
            if(s[i]==prev) {
                count++;
                if(i+1==s.length && count > 1) res.append(count);
            }
            else{
                if(count>1) {
                    res.append(count);
                }
                count = 1;
                prev = s[i];
                res.append(s[i]);
            }
        }
        return res.toString();
    }
    // shortest path
    public static double shortestPath(String str){
        int vertical = 0;
        int horizontal = 0;
        for(int i = 0; i<str.length();i++){
            switch (str.charAt(i)){
                case 'W':
                    horizontal--;
                    System.out.println("West");
                    break;
                case 'E':
                    horizontal++;
                    System.out.println("East");
                    break;
                case 'N':
                    vertical++;
                    System.out.println("North");
                    break;
                case 'S':
                    vertical--;
                    System.out.println("South");
                    break;
            }
        }
        System.out.println(horizontal + " " + vertical);
        return Math.sqrt((double) (vertical * vertical) + (double) (horizontal * horizontal));
    }
}
