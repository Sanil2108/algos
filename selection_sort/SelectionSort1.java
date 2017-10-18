import java.util.*;
class SelectionSort1{
	public static int[] selectionSort1(int[] A){
		for(int i=0;i<A.length-1;i++){
			int min=i;
			for(int j=i+1;j<A.length;j++){
				if(A[min]>A[j]){
					min = j;
				}

			}
			int temp=A[i];
			A[i]=A[min];
			A[min]=temp;
		}
		return A;
	}
	public static void main(String[] args){
		int[] A={
            1, 8, 6, 3, 10, 9
        };
        A=selectionSort1(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
	}
}