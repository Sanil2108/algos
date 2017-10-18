class CountSort1{
    static int[] countSort1(int[] A){
        int max=A[0];
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
        }
        int[] C=new int[max+1];
        for (int i=0;i<A.length;i++){
            C[A[i]]++;
        }

        int Ai=0;
        for(int i=0;i<C.length;i++){
            if(C[i]!=0){
                A[Ai]=i;
                C[i]--;
                i--;
                Ai+=1;
            }
        }
        return A;
    }
    public static void main(String[] args){
        int[] A={
            1, 8, 6, 3, 10, 9
        };
        A=countSort1(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}