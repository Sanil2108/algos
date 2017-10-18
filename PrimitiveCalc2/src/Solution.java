import java.util.Scanner;

/**
 * Created by Admin on 18-07-2016.
 */
public class Solution {
    public static int[] findChainArray(int[] array, int n){
        int[] chainedArr=new int[array.length];
        for(int i=array.length-1, j=0;i>0;j++){
            if(i%3==0) {
                if (i % 2 == 0) {
                    if (min(array[i - 1], array[i / 2], array[i / 3]) == array[i - 1]) {
                        i = i - 1;
                    } else if (min(array[i - 1], array[i / 2], array[i / 3]) == array[i / 2]) {
                        i = i / 2;
                    } else {
                        i = i / 3;
                    }
                }else{
                    if (min(array[i - 1], array[i / 3]) == array[i - 1]) {
                        i = i - 1;
                    } else {
                        i = i / 3;
                    }
                }
            }else if(i%2==0){
                if (min(array[i - 1], array[i / 2]) == array[i - 1]) {
                    i = i - 1;
                } else if (min(array[i - 1], array[i / 2]) == array[i / 2]) {
                    i = i / 2;
                }
            }else{
                i=i-1;
            }
            chainedArr[j]=i;
        }
        return chainedArr;
    }
    public static int min(int a, int b){if(a>b){return b;}else{return a;}}
    public static int min(int a, int b, int c){return min(min(a, b), c);}
    public static int[] primitiveCalc(int n){
        int[] solution=new int[n];
        solution[0]=0;
        solution[1]=0;
        for(int i=2;i<n;i++){
            if(i%3==0){
                if(i%2==0){solution[i]=min(solution[i-1]+1, solution[i/3]+1, solution[i/2]+1);}         //instead of computing solution[i/3],
                else{solution[i]=min(solution[i-1]+1, solution[i/3]+1);}                                //and solution [i/2] and
            }else if(i%2==0){solution[i]=min(solution[i-1]+1, solution[i/2]+1);}                        //solution [i-1], store them in variables
            else{solution[i]=solution[i-1]+1;}                                                          //and use those variables instead.
        }
        System.out.println(solution[n-1]);
        return solution;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] solution=primitiveCalc(n+1);
//        for(int i=1;i<solution.length;i++){
//            System.out.print(solution[i]+" ");
//        }
        int[] arr=findChainArray(solution, n);

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print(n);
    }
}
