import java.util.Scanner;

/**
 * Created by Admin on 17-06-2016.
 */
public class FibonacciNumbers {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        long m=in.nextLong();
        System.out.println(fibonacci2(n, m));
    }

    public static long fibonacci(long n){
        if (n==0){
            return 0;
        }else if (n==2||n==1){
            return 1;
        }else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static long fibonacci2(long n, long m){
        long first=1;
        long second=0;
        for (int i=0;i<n;i++){
//            System.out.print(first+"\t");
            long temp=second;
            second=first+second;
            first=temp;
            if (second>m){
                second%=m;
            }
        }
        return second;
    }
}
