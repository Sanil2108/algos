import java.util.*;
class MergeSort1{
	public static int[] mergeSort(int[] A, int start, int end){
		int mid=(start+end)/2;
		if(end-start==1){
			int[] temp={A[start]};
			return temp;
		}else{
			return sort(mergeSort(A, start, mid), mergeSort(A, mid, end));
		}
	}

	public static int[] mergeSort(int[] A){
		return mergeSort(A, 0, A.length);
	}

	public static int[] sort(int[] A, int[] B){
		int i=0;
		int j=0;
		int k=0;
		int[] C = new int[A.length+B.length];
		while(i<A.length && j<B.length){
			if(A[i]>B[j]){
				C[k]=B[j];
				j++;
			}else{
				C[k]=A[i];
				i++;
			}
			k++;
		}

		while(i<A.length){
			C[k]=A[i];
			k++;
			i++;
		}

		while(j<B.length){
			C[k]=B[j];
			k++;
			j++;
		}

		return C;
	}

	public static void main(String[] args){
		int[] A={
			1, 3, 4, 10
		};
		int[] B={
			4, 5, 9
		};
		int[] D={
			1, 5, 2, 10, 8, 12, 4, 3, 2
		};
		int[] C=mergeSort(D);
		for(int i=0;i<C.length;i++){
			System.out.print(C[i]+"\t");
		}
	}
}