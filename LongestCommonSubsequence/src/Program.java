import java.util.Scanner;

/**
 * Created by Admin on 06-08-2016.
 */
public class Program {
    public static final int BUFFER_VALUE=10;
    public static int max(int a, int b){if(a>b){return a;}else{return b;}}
    public static int max(int a, int b, int c){return max(max(a, b), c);}
    public static int[][] lcs(String str1, String str2, int[][] arr){
        //Unnecessary bullshit
        for(int i=0;i<str1.length()+1;i++){arr[i][0]=0;}
        for(int i=0;i<str2.length()+1;i++){arr[0][i]=0;}
        //Unnecessary bullshit ended
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                int temp=-BUFFER_VALUE;
                if(str1.charAt(i-1)==str2.charAt(j-1)){temp=1;}
                arr[i][j]=max(arr[i-1][j-1]+temp, arr[i-1][j], arr[i][j-1]);
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str1=in.nextLine();
        String str2=in.nextLine();
        int[][] arr=new int[str1.length()+1][str2.length()+1];
        arr=lcs(str1, str2, arr);

        //Printing
        for(int i=0;i<str1.length()+1;i++){
            for(int j=0;j<str2.length()+1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //figuring out the path
        char[] path=new char[arr[str1.length()][str2.length()]];
        int k=0;
        for(int i=str1.length();i>0;){
            for(int j=str2.length();j>0;){
                int temp=-BUFFER_VALUE;
                if(str1.charAt(i-1)==str2.charAt(j-1)){temp=1;}
                if(max(arr[i-1][j-1]+temp, arr[i-1][j], arr[i][j-1])==arr[i-1][j-1]+temp){
                    if(str1.charAt(i-1)!=str2.charAt(j-1)){
                        System.out.println("Something got fucked up");
                    }else{
                        path[k]=str1.charAt(i-1);
                        k++;
                        i--;
                        j--;
                    }
                }
                else if(max(arr[i-1][j-1]+temp, arr[i-1][j], arr[i][j-1])==arr[i-1][j]){i--;}
                else if(max(arr[i-1][j-1]+temp, arr[i-1][j], arr[i][j-1])==arr[i][j-1]){j--;}
            }
        }
        for(int i=path.length-1;i>=0;i--){System.out.print(path[i]+", ");}
        System.out.println();
    }
}
