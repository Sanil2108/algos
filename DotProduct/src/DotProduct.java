import java.util.*;

public class DotProduct {

    public static long[] insertionSort(long[] array){
        long[] newArray = new long[array.length];
        newArray[0]=array[0];
        for(int i=1;i<array.length;i++){
            boolean temp=false;
            for(int j=0;j<=i;j++){
                if(array[i]<newArray[j]){
                    newArray=moveRight(newArray, j);
                    newArray[j]=array[i];
                    temp=true;
                    j=i;
                }
            }
            if(!temp){
                newArray[i]=array[i];
            }
        }
        return newArray;
    }

    public static long[] moveRight(long[] array, int targetIndex){    //targetIndex place will be cleared
        long[] newArray=new long[array.length];
        for(int i=0;i<targetIndex;i++){
            newArray[i]=array[i];
        }
        for(int i=targetIndex;i<array.length-1;i++){
            newArray[i+1]=array[i];
        }
        return newArray;
    }


//    private static long minDotProduct(int[] a, int[] b) {
//        for(int i=0;i<)
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }

        b=insertionSort(b);
        a=insertionSort(a);

        long total=0;
        for(int i=0;i<a.length;i++){
            total+=(a[i]*b[b.length-i-1]);
        }

//        System.out.println(minDotProduct(a, b));
//
//        int[] array=new int[]{
//                -4, 6, 7, 1, 3
//        };
//        array=insertionSort(array);
//        for(int i=0;i<array.length;i++){
//            System.out.print(array[i]+", ");
//        }

        System.out.println(total);
    }
}

