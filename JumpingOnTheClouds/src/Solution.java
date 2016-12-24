import java.util.Scanner;

/**
 * Created by Admin on 18-07-2016.
 */
public class Solution {
    public static int min(int a, int b){if (a>b){return b;}else {return a;}}
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){arr[i]=in.nextInt();}
        System.out.println("\n"+dynamicApproach(arr));
    }
    public static int dynamicApproach(int[] arr){
        int[] solution=new int[arr.length];
        solution[0]=0;
        solution[1]=1;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==1){solution[i]=9999;}
            if(arr[i]!=1){
                solution[i]=min(solution[i-1]+1, solution[i-2]+1);
            }
//            System.out.print(solution[i]+", ");
        }
        return solution[arr.length-1];
    }
}
