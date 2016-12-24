import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        while(findSmallest(arr)!=1000){
            int numberOfSticksCut=0;
            int smallest=findSmallest(arr);
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=1000) {
                    arr[i] -= smallest;
                    numberOfSticksCut++;
                }
                if(arr[i]<=0){
                    arr[i]=1000;
                }
            }

            System.out.println(numberOfSticksCut);
        }
    }

    public static int findSmallest(int[] array){
        int smallest=100000;
        for(int i=0;i<array.length;i++){
            if(smallest>array[i]){
                smallest=array[i];
            }
        }
        return smallest;
    }
}
