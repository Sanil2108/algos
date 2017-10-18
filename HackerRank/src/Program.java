import java.util.Scanner;

/**
 * Created by Admin on 09-07-2016.
 */
public class Program {

    public static int[] getDigits(int n){
        int numberOfDigits=(""+n).length();
        int[] digits=new int[numberOfDigits];
        for(int i=0;i<numberOfDigits;i++){
            digits[numberOfDigits-1-i]=(n%(int)Math.pow(10, i+1)-n%(int)Math.pow(10, i))/(int)Math.pow(10, i);
//            System.out.println(digits[numberOfDigits-1-i]);
        }
        return digits;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int divisibleNumbers=0;
            int[] temp=getDigits(n);
            for(int i=0;i<temp.length;i++){
                if(temp[i]!=0&&n%temp[i]==0){
                    divisibleNumbers++;
                }
            }
            System.out.println(divisibleNumbers);
        }
    }

}
