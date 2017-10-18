import java.util.Scanner;

public class Program {
    public static int min(int a, int b){return (a>b)?b:a;}
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        int[][] sol=new int[arr.length-1][arr.length-1];

        for(int l=1;l<arr.length-1;l++){
            for(int i=0;i<arr.length-1-l;i++){
                int temp=(l!=1)?sol[i+1][i+l]+(arr[i]*arr[i+l-1]*arr[i+l+1]):Integer.MAX_VALUE;
                sol[i][i+l]=min(sol[i][i+l-1]+(arr[i]*arr[i+l]*arr[i+l+1]),
                        temp);

//                The complete algorithm is
//                sol[i][i+l]=min(sol[i][i+l-1]+(arr[i]*arr[i+l]*arr[i+l+1]),
//                        sol[i+1][i+l]+(arr[i]*arr[i+l-1]*arr[i+l+1]));
            }
        }

        for(int i=0;i<arr.length-1;i++){
            System.out.println();
            for(int j=0;j<arr.length-1;j++){
                System.out.print("\t\t\t"+sol[i][j]);
            }
        }
    }
}
