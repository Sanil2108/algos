import java.util.Scanner;

/**
 * Created by Admin on 06-08-2016.
 */
public class Program {
    public static int max(int a, int b){if(a>b){return a;}else{return b;}}
    public static int max(int a, int b, int c){return max(max(a, b), c);}
    public static int[] lis(int[] arr){
        int[] solution=new int[arr.length];
        solution[0]=1;
        for(int i=1;i<arr.length;i++){
            int temp=0;
            if(arr[i]>arr[i-1]){temp=1;}
            solution[i]=solution[i-1]+temp;
        }
        return solution;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n+1];
        for(int i=0;i<n;i++){arr[i]=in.nextInt();}
        arr[n]=arr[n-1];
        int[] temp=lis(arr);
        int[] arr2=new int[temp.length+1];
        for(int i=1;i<arr2.length;i++){
            arr2[i]=temp[i-1];
        }
        for(int i=1;i<arr2.length-1;i++){
            System.out.print(arr2[i]+", ");
        }
        int[] path=new int[arr2[arr2.length-1]];
        for(int i=arr2.length-1, j=0;i>0;i--){
            if(arr2[i-1]!=arr2[i]){
                path[j]=arr[i-1];
                j++;
            }
        }
        System.out.println();
        for(int i=path.length-1;i>=0;i--){
            System.out.print(path[i]+", ");
        }

    }
}
