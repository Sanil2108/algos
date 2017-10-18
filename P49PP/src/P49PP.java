import java.util.Scanner;

public class P49PP {

    public static void main(String [] args){

        int[] arrayOfAllNumbers=new int[4];
        Scanner in=new Scanner(System.in);
        int number=in.nextInt();

        for (int i=0;i<4;i++){
            arrayOfAllNumbers[i]=
                    (int)((number%Math.pow(10, 4-i)-number%Math.pow(10,3-i))/Math.pow(10,3-i));
        }

    }
}
