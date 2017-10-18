import java.util.Scanner;

public class HighestCommonDivisor {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);

        long numerator=in.nextInt();
        long originalNumerator=numerator;
        long denominator=in.nextInt();
        long smaller;

        if (numerator<denominator) {
            smaller = numerator;
        }else {
            smaller=denominator;
        }

        for (long i=smaller;i>=1;i--){
            if (numerator%i==0&&
                    denominator%i==0){
                numerator/=i;
                break;
            }
        }

        System.out.println(originalNumerator/numerator);
    }
}
