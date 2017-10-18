import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static char[] reduceString(char[] charArray){
        for(int i=1;i<charArray.length;i++){
            if(charArray[i]!='1'&&charArray[(i-1)]!='1') {
                if (charArray[i] == charArray[i-1]) {
                    charArray=shiftCharArray(charArray, i-1);
                    return reduceString(charArray);
                }
            }
        }
        return charArray;
    }

    public static char[] shiftCharArray(char[] array, int index){
        char[] newArray=new char[array.length-2];
        for(int i=0;i<index;i++){
            newArray[i]=array[i];
        }
        for(int i=index+2;i<array.length;i++){
            newArray[i-2]=array[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        char[] newArray=reduceString(str.toCharArray());
        if (newArray.length!=0) {
            for (int i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i]);
            }
        }else{
            System.out.println("Empty String");
        }
    }
}