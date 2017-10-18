import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int n=in.nextInt();
            int[][] arr=new int[n][n];
            for(int j=0;j<n;j++){
                String temp=in.next();
                for(int k=0;k<n;k++){
                    arr[j][k]=(int)temp.charAt(k);
                }
            }

            for(int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    int[] temp=new int[n];
                    for(int i2=0;i2<n;i2++){
                        temp[i2]=arr[k][i2];
                    }
                    temp=mergeSort(temp);
                    for(int i2=0;i2<n;i2++){
                        arr[k][i2]=temp[i2];
                    }
                }
            }

//            for(int j=0;j<n;j++){
//                for(int k=0;k<n;k++){
//                    System.out.print((char)arr[j][k]);
//                }
//                System.out.println();
//            }

            /* At this point the array arr is sorted lexicographically horizontally.*/

            boolean lexicographic=true;
            for(int j=0;j<n-1;j++){
                for(int k=0;k<n;k++){
                    if(arr[j][k]>arr[j+1][k]){
                        lexicographic=false;
                    }
                }
            }
            System.out.println(lexicographic);
        }
    }

    public static int[] mergeSort(int[] A){
        if(A.length<2){return A;}
        else{
            int[] array1=new int[A.length/2];
            int[] array2=new int[A.length-A.length/2];
            for(int i=0;i<A.length/2;i++){
                array1[i]=A[i];
            }
            for(int i=0;i<A.length-A.length/2;i++){
                array2[i]=A[i+(A.length/2)];
            }
            array1=mergeSort(array1);
            array2=mergeSort(array2);
            return combine(array1, array2, A);
        }
    }

    public static int[] combine(int[] A, int[] B, int[] C){
        int i=0;
        int j=0;
        int k=0;
        while(j<A.length&&k<B.length){
            if(A[j]<B[k]){
                C[i]=A[j];
                j++;
            }else{
                C[i]=B[k];
                k++;
            }
            i++;
        }
        while(j<A.length){
            C[i]=A[j];
            i++;
            j++;
        }
        while(k<B.length){
            C[i]=B[k];
            k++;
            i++;
        }
        return C;
    }
}