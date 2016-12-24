import java.util.Scanner;

/**
 * Created by Admin on 18-06-2016.
 */
public class LeastCommonMultiple {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        long first=in.nextLong();
        long second=in.nextLong();
        long bigger;
        long smaller;
        if (first>second){
            bigger=first;
            smaller=second;
        }else {
            bigger=second;
            smaller=first;
        }
        for (long i=bigger;i<=bigger*smaller;){
            if ((i)%smaller==0){
                System.out.print(i);
                return;
            }
            i+=bigger;
        }
        System.out.print("-1");
    }
}
