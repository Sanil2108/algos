import java.util.Scanner;

public class Program {
    public static int min(int a, int b){return (a>b)?b:a;}
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int total=in.nextInt();
        int[] solution=new int[total];
        solution[0]=0;
        for(int i=1;i<n+1;i++){
            solution[i]=in.nextInt();
        }
        for(int i=n+1;i<total;i++){
            int temp=0;
            for(int j=i-1;j>=0;j--){
                int temp2=solution[j]+solution[i-j];
                temp=(temp>temp2)?temp:temp2;
            }
            solution[i]=temp;
        }
        for(int i=0;i<solution.length;i++){System.out.println(solution[i]);}
    }
}
