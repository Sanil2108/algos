import java.util.Scanner;

/**
 * Created by Admin on 15-07-2016.
 */
public class Solution {
    public static int[] algroithm1(){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt()-1;
        int d1 = in.nextInt();
        int d2 = in.nextInt();

        int[] temp=new int[n+1];
        for (int i2 = n, j=0; i2 >=0; i2--, j++) {
            int temp2=i2 * d1 + (n - i2) * d2;
            if(!contains(temp, temp2)) {
                temp[j] = temp2;
//                System.out.print(temp2+" ");
            }
        }
//        System.out.println();
        return temp;
    }

//    public static int[] divideAndConquer(int[] arr, int numberOfStonesLeft, int diff, int d1, int d2, int currIndex){
//        if(numberOfStonesLeft==0){
//            arr[0]+=diff;
//            return arr;
//        }
//        numberOfStonesLeft--;
//        int[] arr1=divideAndConquer(arr, numberOfStonesLeft, d1, d1, d2);
//        int[] arr2=divideAndConquer(arr, numberOfStonesLeft, d2, d1, d2);
//
//        return combine(arr1, arr2);
//    }

    public static int[] combine(int[] arr1, int[] arr2){
        int[] newArr=new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
            newArr[i]=arr1[i];
        }
        for(int i=0;i<arr2.length;i++){
            newArr[arr1.length+i]=arr2[i];
        }
        return newArr;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
//        int T=in.nextInt();
//        for(int i=0;i<T;i++) {
//        }
    }

    public static boolean contains(int[] A, int target){
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                return true;
            }
        }
        return false;
    }
}
