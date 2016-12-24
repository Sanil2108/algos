import java.util.Scanner;

/**
 * Created by Admin on 02-07-2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        char[] timeArray=time.toCharArray();
        int hour=Integer.parseInt(timeArray[0]+"")*10+
                Integer.parseInt(timeArray[1]+"");
        if(timeArray[8]=='P'){
            if(hour!=12) {
                hour += 12;
            }

        }else{
            if(hour==12){
                hour=0;
            }
        }

        if(hour>=10&&hour<20) {
            timeArray[0]='1';
        }else if(hour>=20){
            timeArray[0]='2';
        }else{
            timeArray[0]='0';
        }
        timeArray[1]=(char)(hour%10+48);
        timeArray[8]=' ';
        timeArray[9]=' ';
        System.out.println(timeArray);
    }
}
