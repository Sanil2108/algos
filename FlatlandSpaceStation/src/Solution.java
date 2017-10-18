import java.util.Scanner;

/**
 * Created by Admin on 16-08-2016.
 */
public class Solution {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] spaceStationCities=new int[m];
        for(int i=0;i<m;i++) {
            spaceStationCities[i] = in.nextInt();
        }
        int solution=0;
        for(int i=0;i<n;i++){
            int temp=99999;
            for(int j=0;j<m;j++){
                int temp2=i-spaceStationCities[j];
                temp2=(temp2>=0)?temp2:-temp2;
                temp=(temp2<temp)?temp2:temp;
            }
            solution=(solution>temp)?solution:temp;
        }
        System.out.println(solution);
    }
}
