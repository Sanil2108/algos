//import java.util.Random;
//import java.util.Scanner;
//
//public class MaxPairwiseProduct {
//
//    public static void main(String [] args){
//        int totalNumberOfTimesTestRan=0;
////        Scanner in=new Scanner(System.in);
//        for (;;){
//            totalNumberOfTimesTestRan++;
//            Random random=new Random();
//
////            int n = in.nextInt();
//            int n=random.nextInt(10)+2;
//            long[] array = new long[n];
//
//            for (int i = 0; i < n; i++) {
//                array[i] = random.nextInt(1000)+1;
//            }
//
//            if (maxPairwiseProduct(array)==maxPairwiseProductFast(array)){
//                System.out.println("OK\nafter " + totalNumberOfTimesTestRan);
//            }else {
//                System.out.println("Problem:\nNumber returned by fast = "+maxPairwiseProductFast(array)+"\nNumber returned by other =   " +
//                        maxPairwiseProductFast(array) + "");
//
//                for (int i=0;i<array.length;i++){
//                    System.out.print("\n"+array[i]);
//                }
//                return;
//            }
//        }
//
//    }
//
//    public static long maxPairwiseProductFast(long[] array){
//        long firstN=0;
//        long secondN=0;
//        for (int i=0;i<array.length;i++){
//            long temp=array[i];
//            if (temp>firstN){
//                secondN=firstN;
//                firstN=temp;
//            }else if (temp>secondN){
//                secondN=temp;
//            }
//        }
//        return firstN*secondN;
//    }
//
//    public static long maxPairwiseProduct(long [] array){
//        long total=1;
//        for (int i=0;i<array.length;i++){
//            for (int j=i+1;j<array.length;j++){
//                if (array[i]*array[j]>total){
//                    total=array[i]*array[j];
//                }
//            }
//        }
//        return total;
//    }
//}

import java.util.Scanner;

public class MaxPairwiseProduct {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long firstN=0;
        long secondN=0;
        for (int i=0;i<n;i++){
            long temp=in.nextInt();
            if (temp>firstN){
                secondN=firstN;
                firstN=temp;
            }else if (temp>secondN){
                secondN=temp;
            }
        }
        System.out.println(firstN*secondN);
    }
}

