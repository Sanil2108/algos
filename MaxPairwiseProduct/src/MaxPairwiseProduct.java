import java.util.Scanner;


public class MaxPairwiseProduct {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] array=new long[n];
        for(int i=0;i<n;i++){
            array[i]=scanner.nextInt();
        }

//        long maxValue=1;
        long maxNumber1=1;
        long maxNumber2=1;
        for (int i=0;i<n;i++){
            if (maxNumber1<array[i]){
                maxNumber1=array[i];
            }
            if(maxNumber2<array[i]&&
                    array[i]!=maxNumber1){
                maxNumber2=array[i];
            }
        }

        System.out.print(maxNumber1*maxNumber2);
    }
}
