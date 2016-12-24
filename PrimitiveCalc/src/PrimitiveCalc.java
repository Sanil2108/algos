/**
 * Created by Admin on 16-07-2016.
 */
public class PrimitiveCalc {
    public static int DPChange(int money, int[] coins){
        int[] MinNumCoins=new int[money+1];
        MinNumCoins[0]=0;
        for(int m=1;m<=money;m++){
            coins[0]=1;
            coins[1]=1;
            coins[2]=(m-1)*3;
            MinNumCoins[m]=10000;
            for(int i=0;i<coins.length;i++){
                if(m>=coins[i]){
                    int NumCoins=MinNumCoins[m-coins[i]]+1;
                    if(NumCoins<MinNumCoins[m]){
                        MinNumCoins[m]=NumCoins;
                    }
                }
            }
        }
        return MinNumCoins[money];
    }

    public static void main(String[] args){
        System.out.println(DPChange(
                9, new int[]{1, 5, 6}
        ));
    }
}
