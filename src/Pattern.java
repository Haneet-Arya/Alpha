public class Pattern {
    public static void main(String[] args) {
//        for(int i = 0;i<4;i++){
//            for(int j = 0;j<5;j++){
//                if(i==0||i==3) System.out.print("*");
//                else{
//                    if(j==0||j==4) System.out.print("*");
//                    else System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

//        for(int i = 1;i<5;i++){
//            for(int j= 1;j<5-i;j++ ){
//                System.out.print(" ");
//            }
//            for(int j = 1;j<=i;j++ ){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        for(int i = 0;i<5;i++){
            for(int j = 0;j<=4-i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }

        int l = 1;

        for(int i = 0;i<6;i++){
            for(int j = 0;j<i;j++){
                System.out.print(l++ +" ");
            }
            System.out.println();
        }

//        int l = 1;
//        for(int i = 0;i<5;i++){
//            int k = l;
//            for(int j = 0;j<=i;j++){
//                System.out.print(k + " ");
//                k=(k==1)?0:1;
//            }
//            System.out.println();
//            l=(l==1)?0:1;
//        }
//        int n = 12;
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<n;j++){
//                if(i<n/2){
//                    if(j<=i || j>=n-1-i){
//                        System.out.print("*");
//                    }
//                    else{
//                        System.out.print(" ");
//                    }
//                }
//                else{
//                    if(j<=n-1-i || j>=i){
//                        System.out.print("*");
//                    }
//                    else{
//                        System.out.print(" ");
//                    }
//                }
//
//
//            }
//            System.out.println();
//        }
//        int n =7;
//        for(int i = 1;i<=n;i++){
//            for(int j =0;j<n-i;j++){
//                System.out.print(" ");
//            }
//            for(int j = 0;j<n;j++){
//                if(i==1 || i==n || j==0||j==n-1) {
//                    System.out.print("*");
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
    }
}
