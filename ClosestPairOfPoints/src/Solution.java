/**
 * Created by Admin on 05-08-2016.
 */
public class Solution {
    public static int min(int a, int b){if(a>b){return b;}else{return a;}}
    public static int min(int a, int b, int c){return min(min(a, b), c);}
    public static int[] merge(int[] X){
        if(X.length<2){
            return X;
        }else{
            int[] P=new int[X.length/2];
            int[] Q=new int[X.length-X.length/2];
            for(int i=0;i<P.length;i++){P[i]=X[i];}
            for(int i=P.length;i<P.length+Q.length;i++){Q[i]=X[i];}
            P=merge(P);
            Q=merge(Q);
            return combine(P, Q);
        }
    }
    public static int[] combine(int[] A, int[] B){

    }
    public static void main(String[] args){

    }
}

