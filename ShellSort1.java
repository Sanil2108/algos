class ShellSort1{
	public static int[] shellSort(int[] A){
		int k=(A.length/2);
		while(k>=1){
			for(int i=0;i<A.length-k;i++){
				if(A[i]>A[i+k]){
					int temp = A[i];
					A[i]=A[i+k];
					A[i+k]=temp;
					for(int j=i;j>k;j-=k){
						if(i<k){
							break;
						}else{
							if(A[j]<A[j-k]){
								int temp2=A[j];
								A[j]=A[j-k];
								A[j-k]=temp2;
							}
						}
					}
				}
			}
			k=k/2;
		}
		return A;
	}

	public static void main(String[] args){
		int[] D={
			1, 5, 2, 10, 8, 12, 4, 3, 2
		};
		int[] C=shellSort(D);
		for(int i=0;i<C.length;i++){
			System.out.print(C[i]+"\t");
		}
	}
}