public class PolyMultiplication{

    public static int[] multiplyPoly(int[] A, int[] B){
        if(A.length!=B.length){
            return new int[]{-1};
        }
        int[] answer=new int[2*A.length-1];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                answer[i+j]+=A[i]*B[j];
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] answer=multiplyPoly(new int[]{3, 2, 1},
                new int[]{4, 4, 1});
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+"x^"+(answer.length-1-i)+" + ");
        }
    }
}