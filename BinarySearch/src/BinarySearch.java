import java.util.Scanner;

/**
 * Created by Admin on 08-07-2016.
 */
public class BinarySearch {
    public static long binarySearch(long[] A, int start, int end, long target){
        int n=(start+end)/2;
        if (target!=A[n]&&end-start==1){
            return -1;
        }
        if(target==A[n]){
            return n;
        }else {
            if(target>A[n]){
                return binarySearch(A, n, end, target);
            }else if(target<A[n]){
                return binarySearch(A, start, n, target);
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        long[] A=new long[]{1, 4, 6, 7, 9};
//        System.out.print(binarySearch(A, 0, A.length, 11));

        Scanner in=new Scanner(System.in);

        int sizeOfArray=in.nextInt();
        long[] A=new long[sizeOfArray];
        for(int i=0;i<sizeOfArray;i++){
            A[i]=in.nextLong();
        }

        int numberOfTargets=in.nextInt();
        long[] targets=new long[numberOfTargets];
        for(int i=0;i<numberOfTargets;i++){
            targets[i]=in.nextLong();
        }

        for (int i=0;i<numberOfTargets;i++){
            System.out.print(binarySearch(A, 0, A.length, targets[i])+" ");
        }

    }
}
