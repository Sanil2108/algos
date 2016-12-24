import java.util.Scanner;

public class Program {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int[] solution=new int[t];
        int oldHighest=3;
        for(int i=1, value=3;i<t;i++,value--){
            if(value==0){oldHighest*=2;value=oldHighest;}
            solution[i]=value;

            System.out.print(i+"\t"+value+"\n");
        }
    }
}
