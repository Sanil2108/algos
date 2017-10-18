import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 20-07-2016.
 */
public class Knapsack {
    public static int max(int a, int b){if(a>b){return a;}else{return b;}}
    public static int max(int a, int b, int c){return max(max(a, b), c);}
    public static int[] withRepetitions(int[] W, int[] V, int w){
        int[] solution=new int[w];
        solution[0]=0;
        for(int i=1;i<w;i++){
            int maxValue=0;
            for(int j=0;j<W.length;j++){
                if(i>=W[j]){
                    int temp=solution[i-W[j]]+V[j];
                    if(temp>maxValue){
                        maxValue=temp;
                    }
                }
            }
            solution[i]=maxValue;
        }
        return solution;
    }

    public static int[] withoutRepetitions(int[] W, int[] V, int w){
        int[][] solution=new int[w][W.length];
        for(int i=0;i<W.length;i++){solution[0][i]=0;}
        int temp;
        if(W[0]>1){temp=0;}else{temp=V[0];}
        for(int i=1;i<w;i++){solution[i][0]=temp;}
        for(int i=1;i<w;i++){
            for(int j=1;j<W.length;j++){
                if(i>=W[j]){
                    solution[i][j]=
//                            max(V[j]+solution[i-W[j]][i-W[j]], solution[i][j-1]);
//                            max(V[j]+solution[i-W[j]][j-1], solution[i][j-1]);
                            max(V[j]+solution[i-W[j]][j-1], solution[i][j-1], solution[i-1][j]);    //New approach, haven't tried yet
                }else{
                    solution[i][j]=solution[i][j-1];
                }
            }
        }

//        int[] solution=new int[w];
//        solution[0]=0;
//        for(int i=1;i<w;i++){
//            int maxValue=0;
//            for(int j=0;j<W.length;j++){
//                if(i>=W[j]){
//                    int temp=solution[i-W[j]]+V[j];
//                    if(temp>maxValue){
//                        maxValue=temp;
//                    }
//                }
//            }
//            solution[i]=maxValue;
//        }
//        return solution;

//        for(int i=0;i<w;i++){
//            for(int j=0;j<W.length;j++){
//                System.out.print(solution[i][j]+"\t");
//            }System.out.println();
//        }

        int [] finalAns=new int[w];
        for(int i=0;i<w;i++){
            finalAns[i]=solution[i][W.length-1];
        }
        return finalAns;

    }

    public static int takingGoldWithoutRepetitions(int[] W, int[] V, int w){
        int[][] solution=new int[w][W.length];
//        for(int i=0;i<W.length;i++){solution[0][i]=0;}
//        int temp;
//        if(W[0]>1){temp=0;}else{temp=V[0];}
//        for(int i=1;i<w;i++){solution[i][0]=0;solution[0][i]=0;}
        for(int i=1;i<w;i++){
            for(int j=1;j<W.length;j++){
                if(i>=W[j]){
                    solution[i][j]=
//                            max(V[j]+solution[i-W[j]][i-W[j]], solution[i][j-1]);
//                            max(V[j]+solution[i-W[j]][j-1], solution[i][j-1]);
                            max(V[j]+solution[i-W[j]][j-1], solution[i][j-1], solution[i-1][j]);    //New approach, haven't tried yet
                }else{
                    solution[i][j]=solution[i][j-1];
                }
            }
        }

//        System.out.println();
//        for(int i=0;i<w;i++){
//            for(int j=0;j<W.length;j++){
//                System.out.print(solution[i][j]+"\t");
//            }System.out.println();
//        }

//        int[] solution=new int[w];
//        solution[0]=0;
//        for(int i=1;i<w;i++){
//            int maxValue=0;
//            for(int j=0;j<W.length;j++){
//                if(i>=W[j]){
//                    int temp=solution[i-W[j]]+V[j];
//                    if(temp>maxValue){
//                        maxValue=temp;
//                    }
//                }
//            }
//            solution[i]=maxValue;
//        }
//        return solution;


//        int [] finalAns=new int[w];
//        for(int i=0;i<w;i++){
//            finalAns[i]=solution[i][W.length-1];
//        }
        return solution[w-1][W.length-1];

    }

    public static int takingGoldCOPIEDALGORITHM(int[] w, int W){
        int[][] res=new int[w.length+1][W+1];
        for(int i=0;i<=w.length;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0){res[i][j]=0;}
                else if(w[i-1]>j){res[i][j]=res[i-1][j];}
                else{
                    res[i][j]=max(w[i-1]+res[i-1][j-w[i-1]], res[i-1][j]);
                }
            }
        }

//        for(int i=0;i<W;i++){
//            for(int j=0;j<w.length;j++){
//                System.out.print(res[i][j]+"\t");
//            }System.out.println();
//        }
        return res[w.length][W];
    }

    public static void main(String[] args){

//        stressTest();
        Scanner in=new Scanner(System.in);
        int w=in.nextInt();
        int n=in.nextInt();
        int[] W=new int[n+1];
        for(int i=1;i<W.length;i++){
            W[i]=in.nextInt();
        }
        System.out.println(takingGoldWithoutRepetitions(W, W, w+1));
//        System.out.println(takingGoldCOPIEDALGORITHM(W, w));
//        int[] V=new int[n];
//        for(int i=0;i<V.length;i++){
//            V[i]=W[i];
//        }

//        int[] solution= withoutRepetitions(W, V, w+1);
//        for(int i=0;i<solution.length;i++){
//            System.out.print(solution[i]+" ");
//        }
//        System.out.println(solution[solution.length-1]);
    }

    public static void stressTest(){
        Scanner scanner=new Scanner(System.in);
        int W_CON=5;
        int n_CON=6;
        int w_CON=15;
        Random random=new Random();
        for(int i=0;i<1000;i++){
            int W=1+random.nextInt(W_CON-1);
            int n=1+random.nextInt(n_CON-1);
            int[] w=new int[n];
            int[] wTemp=new int[n+1];
            for(int j=0;j<n;j++){
                int temp=1+random.nextInt(w_CON-1);
                w[j]=temp;
                wTemp[j+1]=temp;
            }
            if(takingGoldCOPIEDALGORITHM(w,W)!=takingGoldWithoutRepetitions(wTemp, wTemp, W)){
                System.out.println("\n\nFAILED : ");
                System.out.println("n\t"+n+"\nW\t"+W+"\n");
                for(int k=0;k<n;k++){
                    System.out.print(w[k]+"\t");
                }
                System.out.println("\ntakingGoldCOPIEDALGORITHM - \t"+takingGoldCOPIEDALGORITHM(w, W)+
                "\ntakingGoldWithoutRepetitions - \t"+takingGoldWithoutRepetitions(w, w, W));
                scanner.nextLine();
            }else{
                System.out.println("PASSED : ");
                System.out.println("n\t"+n+"\tW\t"+W+"\t");
                for(int k=0;k<n;k++){
                    System.out.print(w[k]+"\t");
                }
            }
        }
    }
}
