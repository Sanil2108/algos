import java.util.Scanner;

/**
 * Created by Admin on 17-07-2016.
 */
public class Solution {
    public static int min(int a, int b){if(a>b){return b;}else{return a;}}
    public static int min(int a, int b, int c){return min(min(a, b), c);}
    public static int[][] computeEditDistance(int m, int n, String str1, String str2){
        int[][] arr=new int[m+1][n+1];
        arr[0][0]=0;
        for(int i=1;i<m+1;i++){arr[i][0]=i;}
        for(int i=1;i<n+1;i++){arr[0][i]=i;}
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int diff;
                if(str1.charAt(i)==str2.charAt(j)){diff=0;}else{diff=1;}
                arr[i][j]=min(arr[i-1][j]+1, arr[i][j-1]+1, arr[i-1][j-1]+diff);
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str2=in.nextLine();
        String str1=in.nextLine();
        str1="0"+str1;
        str2="1"+str2;
        int[][] arr=computeEditDistance(str1.length()-1, str2.length()-1, str1, str2);
        System.out.println(arr[str1.length()-1][str2.length()-1]);
    }
}
