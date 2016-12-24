/**
 * Created by Admin on 06-07-2016.
 */
public class Factoring {

    public static boolean isPrime(int n){
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static int getNextPrime(int n){
        for(int i=n+1;i<n+100;i++){
            if(isPrime(i)){
                return i;
            }
        }
        return -1;
    }

    public static void printPrimeFactors(int n){
        while(!isPrime(n)){
            for (int i = 2; i < n / 2; ) {
                if (n % i == 0) {
                    n /= i;
                    System.out.println(i);
                }
                i = getNextPrime(i);
            }
        }
        System.out.println(n);

//        if(isPrime(n)){
//            System.out.println(n);
//            return;
//        }else {
//            for (int i = 2; i < n / 2; ) {
//                if (n % i == 0) {
//                    n /= i;
//                    System.out.println(i);
//                    printPrimeFactors(n);
//                }
//                i = getNextPrime(i);
//            }
//        }
    }

    public static void main(String[] args){
//        for (int i=2;i<100;i++){
//            System.out.print("\n"+i);
//            if (isPrime(i)){
//                System.out.print("\tPRIME");
//            }else {
//                System.out.print("\tCOMPOSITE");
//            }
//        }

//        System.out.println(getNextPrime(2));

        printPrimeFactors(765);

    }

}
