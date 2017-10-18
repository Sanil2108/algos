/**
 * Created by Admin on 16-07-2016.
 */
public class Solution {
    public static int min3(int a, int b, int c){
        return min(min(a, b), c);
    }
    public static int min(int a, int b){
        if(a>b){return a;}
        else {return b;}
    }
    public static void main(String[] args){
        String str="0101010";
        char[] charArray=str.toCharArray();
        System.out.print(" - "+min3(check1(charArray), check2(charArray), check3(charArray)));
    }
    public static int check1(char[] charArray){
        int numberOfConversions=0;
        for(int i=0;i<charArray.length-2;i++){
            if(charArray[i]=='0'&&
                    charArray[i+1]=='1'&&
                    charArray[i+2]=='0'){
                charArray[i+1]='0';
                i=0;
                numberOfConversions++;
            }
        }
//        for(int i=0;i<charArray.length;i++){
//            System.out.print(charArray[i]);
//        }
        return numberOfConversions;
    }
    public static int check2(char[] charArray){
        int numberOfConversions=0;
        for(int i=0;i<charArray.length-2;i++){
            if(charArray[i]=='0'&&
                    charArray[i+1]=='1'&&
                    charArray[i+2]=='0'){
                charArray[i]='1';
                i=0;
                numberOfConversions++;
            }
        }
//        for(int i=0;i<charArray.length;i++){
//            System.out.print(charArray[i]);
//        }
        return numberOfConversions;
    }
    public static int check3(char[] charArray){
        int numberOfConversions=0;
        for(int i=0;i<charArray.length-2;i++){
            if(charArray[i]=='0'&&
                    charArray[i+1]=='1'&&
                    charArray[i+2]=='0'){
                charArray[i+2]='1';
                i=0;
                numberOfConversions++;
            }
        }
//        for(int i=0;i<charArray.length;i++){
//            System.out.print(charArray[i]);
//        }
        return numberOfConversions;
    }
}
