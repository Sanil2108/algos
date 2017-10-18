/**
 * Created by Admin on 09-07-2016.
 */
public class MajorityElement {

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

    public static int[] mergeSort(int[] A){
        if(A.length<2){return A;}
        else{
            int[] array1=new int[A.length/2];
            int[] array2=new int[A.length-A.length/2];      //Fail-safe measure if A.length%2!=0
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

    public static void main(){
        int[] test=new int[]{
                3, 6, 1, 2, 9, 7, 5, 4
        };
        test=mergeSort(test);

    }
}
