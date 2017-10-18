class InsertionSort1{
    public static int[] insertionSort1(int[] A){
        for(int i=1;i<A.length;i++){
            int pos=i;
            for(int j=i;j>-1;j--){
                if(A[j]>A[i]){
                    pos=j;
                }
            }
            int temp=A[i];
            for(int j=i;j>pos;j--){
                A[j]=A[j-1];
            }
            A[pos]=temp;
        }
        return A;
    }
    public static void main(String[] args){
        int[] A={
            1, 8, 6, 3, 10, 9
        };
        A=insertionSort1(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}