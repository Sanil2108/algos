import java.util.Scanner;

/**
 * Created by Admin on 20-06-2016.
 */
public class P50CPS {

    public static int getNextPrime(int n){
        int max=100;
        if (n>10000){
            max=200;
        }
        if (n>100000){
            max=400;
        }
        for (int i=n;i<n+max;){
            i++;
            if (checkPrime(i)){
                return i;
            }
        }
        return 2;
    }

    public static boolean checkPrime(int n){
        for (int i=2;i<n;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    
    public static int checkConsecutivePrimeSum(int n, int startPrime){
//        System.out.print(n+"\t\t");
        int n2=n;
        int largestChain=0;
        for (int i=startPrime;i<n;){
            if (n2==0){
//                System.out.println("SUCCESS");
                return largestChain;
            }
            if (n2<0){
//                System.out.println("FAIL");
                return -1;
            }
            n2-=i;
//            System.out.print(i+"\t");
            largestChain++;
            i=getNextPrime(i);
        }
        return -1;
    }

    public static void main(String [] args){

//        for (int i=0;i<10;i++) {
//            Scanner scanner=new Scanner(System.in);
//            int n=scanner.nextInt();
//            System.out.println(getNextPrime(n));
//        }
//

//        int n2=n;
//
//        for (int i=2;i<n;){
//            for (int j=getNextPrime(i);j<n;j++){
//
//            }
//        }

        int largestChain=1;
        int largestChainNumber=1;

        for (int j=1000, k=1;j<100000;j=getNextPrime(j),k++) {
            for (int i = 2; i < j; i = getNextPrime(i)) {
                if (checkConsecutivePrimeSum(j, i)!=-1) {
                    if (largestChain<checkConsecutivePrimeSum(j,i)){
                        largestChain=checkConsecutivePrimeSum(j,i);
                        largestChainNumber=j;
                    }
                    break;
                }
            }
            if (k%10==0){
                if (k%100==0){
                    System.out.println();
                }
                System.out.print("\t"+j);
            }
        }


        System.out.println("\n\n\n\n"+largestChainNumber+" at "+largestChain);

        for (int i=11;i<1000000;){
            System.out.print(getNextPrime(i)+"\n");
            i=getNextPrime(i);
        }

    }

}
