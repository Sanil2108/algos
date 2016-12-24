
public class Matrice {
    public enum Type{IdentityM, ZeroM, OneM}
    private static int _id=0;
    private int[][] main;
    private int orderP;
    private int orderQ;

    public Matrice scalarMultiplication(int k){
        for(int i=0;i<orderP;i++){
            for(int j=0;j<orderQ;j++){
                main[i][j]=k*main[i][j];
            }
        }
        return this;
    }

    public static boolean equals(Matrice m1, Matrice m2){
        if(m1.getOrderP()!=m2.orderP||m1.orderQ!=m2.orderQ){
            return false;
        }
        int[][] m1Main=m1.getMain();
        int[][] m2Main=m2.getMain();
        for (int i=0;i<m1.getOrderP();i++){
            for (int j=0;j<m2.getOrderQ();j++){
                if (m1Main[i][j]!=m2Main[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

//    public static int getCofactor(Matrice m1, int i, int j){
//        int finalAns=1;
//        for(int i2=0;i2<100;i2++){
//            if(i==2&&j==2){
//
//            }else{
//
//            }
//        }
//        return finalAns;
//    }

//    public static int getDeterminant(Matrice m1){
//        int[][] main=m1.getMain();
//        int det=0;
//        for(int i=0;i<m1.orderP;i++){
//
//            det+=main[0][i]*getDeterminantofOrder2(
//                    new Matrice(2, 2, {{main}})
//            )
//        }
//    }

    private static int getDeterminantofOrder2(Matrice m1){
        if(m1.orderP>2||m1.orderQ>2){
            System.out.println("Matrice exceed order 2, ERROR in Matrice.getDeterminant(Matrice)");
            return -1;
        }
        int[][] main=m1.getMain();
        return (main[0][0]*main[1][1]-main[0][1]*main[1][0]);
    }

    public static Matrice multiplyMatrice(Matrice m1, Matrice m2){
        //m1 is of order pxq, m2 is of order qxr
        if(m1.getOrderQ()!=m2.getOrderP()){System.out.println("Order is wrong");return null;}
        int p=m1.orderP;
        int q=m1.orderQ;
        int r=m2.orderQ;

        int[][] m1Main=m1.getMain();
        int[][] m2Main=m2.getMain();

        int[][] finalAns=new int[p][r];
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                int total=0;
                for(int k=0;k<q;k++){
                    total+=(m1Main[i][k]*m2Main[k][j]);
                }
                finalAns[i][j]=total;
            }
        }
        return new Matrice(p, r, finalAns);
    }

    public static Matrice subtractMatrice(Matrice m1, Matrice m2){
        Matrice finalAns;
        if(m1.getOrderP()!=m2.getOrderP()||
                m1.getOrderQ()!=m2.getOrderQ()){
            System.out.println("Order of matrices are different");
            return null;
        }
        int[][] sum=new int[m1.getOrderP()][m1.getOrderQ()];
        int[][] m1Main=m1.getMain();
        int[][] m2Main=m2.getMain();
        for(int i=0;i<m1.getOrderP();i++){
            for(int j=0;j<m1.getOrderQ();j++){
                sum[i][j]=m1Main[i][j]-m2Main[i][j];
            }
        }
        finalAns=new Matrice(m1.getOrderP(), m1.getOrderQ(), sum);
        return finalAns;
    }

    public static Matrice addMatrice(Matrice m1, Matrice m2){
        Matrice finalAns;
        if(m1.getOrderP()!=m2.getOrderP()||
                m1.getOrderQ()!=m2.getOrderQ()){
            System.out.println("Order of matrices are different");
            return null;
        }
        int[][] sum=new int[m1.getOrderP()][m1.getOrderQ()];
        int[][] m1Main=m1.getMain();
        int[][] m2Main=m2.getMain();
        for(int i=0;i<m1.getOrderP();i++){
            for(int j=0;j<m1.getOrderQ();j++){
                sum[i][j]=m1Main[i][j]+m2Main[i][j];
            }
        }
        finalAns=new Matrice(m1.getOrderP(), m1.getOrderQ(), sum);
        return finalAns;
    }

    public static Matrice getTranspose(Matrice matrice){
        int[][] transpose=new int[matrice.getOrderQ()][matrice.getOrderP()];
        int[][] main=matrice.getMain();
        for(int i=0;i<matrice.getOrderP();i++){
            for (int j=0;j<matrice.getOrderQ();j++){
                transpose[j][i]=main[i][j];
            }
        }
        Matrice transposeMatrix=new Matrice(matrice.getOrderQ(), matrice.getOrderP(), transpose);
        return transposeMatrix;
    }

    public Matrice(int orderP, int orderQ, int[][] main){
        this.main=main;
        this.orderP=orderP;
        this.orderQ=orderQ;
    }

    public Matrice(int orderP, int orderQ, Type type){
        this.orderP=orderP;
        this.orderQ=orderQ;
        switch (type){
            case IdentityM:
                if(orderP!=orderQ){
                    System.out.println("OrderP and OrderQ should be same. making a Matrix of order P");
                }
                main=new int[orderP][orderP];
                for(int i=0;i<orderP;i++){
                    for(int j=0;j<orderP;j++){
                        if(i==j){
                            main[i][j]=1;
                        }else{
                            main[i][j]=0;
                        }
                    }
                }
                break;
            case ZeroM:
                main=new int[orderP][orderQ];
                for(int i=0;i<orderP;i++){
                    for(int j=0;j<orderQ;j++){
                        main[i][j]=0;
                    }
                }
                break;
            case OneM:
                main=new int[orderP][orderQ];
                for(int i=0;i<orderP;i++){
                    for(int j=0;j<orderQ;j++){
                        main[i][j]=1;
                    }
                }
        }
    }

    public static int get_id() {
        return _id;
    }

    public int[][] getMain() {
        return main;
    }

    public int getOrderP() {
        return orderP;
    }

    public int getOrderQ() {
        return orderQ;
    }

    public static void printMatrix(Matrice matrice){
        for(int i=0;i<matrice.getOrderP();i++){
            for(int j=0;j<matrice.getOrderQ();j++){
                System.out.print(matrice.getMain()[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
