import java.util.Scanner;

/**
 * Created by Admin on 02-07-2016.
 */
public class Solution {

    public static boolean isADecentNumber(long number){
        String numberStr=""+number;
        int numberOfThrees=0;
        int numberOfFives=0;

        for(int i=0;i<numberStr.length();i++){
            if(numberStr.charAt(i)=='3'){
                numberOfThrees++;
            }else if(numberStr.charAt(i)=='5'){
                numberOfFives++;
            }else{
                return false;
            }
        }

        if(numberOfThrees%5==0&&numberOfFives%3==0){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int numberOfDigits=in.nextInt();
            long highestNumber=-1;
            String jStr="";
            for(int j=0;j<numberOfDigits;j++){
                jStr=jStr+"3";
            }
            String jMaxStr="";
            for(int j=0;j<numberOfDigits;j++){
                jMaxStr=jMaxStr+"5";
            }

            int temp=0;
            for(long j=Long.parseLong(jStr);j<=Long.parseLong(jMaxStr);){
                if(highestNumber<j){
                    if(isADecentNumber(j)) {
                        highestNumber = j;
                    }
                }

                if(temp==0){
                    j+=2;
                    temp=1;
                }else if(temp==1){
                    j+=8;
                    temp=0;
                }
            }

            System.out.println(highestNumber);
//            System.out.print(jStr);
        }



//        int test=in.nextInt();
//        System.out.println(isADecentNumber(test));
    }

}
