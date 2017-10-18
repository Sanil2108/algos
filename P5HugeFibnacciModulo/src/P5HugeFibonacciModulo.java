/**
 * Created by Admin on 23-06-2016.
 */
public class P5HugeFibonacciModulo {
    public static int[] findPsianoPeriod(int number, int divisor){
        int[] PsianoPeriod=new int[1];
        for(int i=2;i<20;i++){
            PsianoPeriod=new int[i];

            //setup the array PsianoPeriod
            for(int j=0;j<i;j++){
                PsianoPeriod[j]=(int)(fibonacci2()%divisor);
            }
        }

        return PsianoPeriod;
    }
    public static long fibonacci2(long n){
        long first=1;
        long second=0;
        for (int i=0;i<n;i++){
//            System.out.print(first+"\t");
            long temp=second;
            second=first+second;
            first=temp;
        }
        return second;
    }
    public static void main(String[] args){
    }
}
