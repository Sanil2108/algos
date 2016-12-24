/**
 * Created by Admin on 14-07-2016.
 */
public class MaxSubArray {
    public static int max(int a, int b){
        if (a>b){
            return a;
        }else{
            return b;
        }
    }
    public static int max(int a, int b, int c){
        return max(max(a, b), c);
    }
    public static int findMaxSumSubarray(int[] arr, int l, int h){
        int m=(l+h)/2;
        if(h-l<=1){
            return arr[l];
        }
        return max(findMaxSumSubarray(arr, l, m),
                findMaxSumSubarray(arr, m, h),
                findCrossingSum(arr, l, m, h));
    }
    public static int findCrossingSum(int[] arr, int l, int m, int h){
        int sum=0;
        int leftSum=Integer.MIN_VALUE;
        int rightSum=Integer.MIN_VALUE;
        for(int i=m;i>=0;i--){
            sum+=arr[i];
            if(sum>leftSum){
                leftSum=sum;
            }
        }
        sum=0;
        for(int i=m;i<h;i++){
            sum+=arr[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }
        return leftSum+rightSum;
    }
    public static void main(String[] args){
        int[] arr=new int[]{
                4, 7, 1, -10, 5
        };

        System.out.println(findMaxSumSubarray(arr, 0, arr.length));
    }

}
