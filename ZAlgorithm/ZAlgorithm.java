import java.util.*;
class Solution1{
    public static int Z(char[] text, int patternLength){
        int[] Z=new int[text.length];
        int counter=0;
        for(int i=1;i<Z.length;i++){
            int j=0;
            while(i+j<text.length && text[i+j]==text[j]){
                j++;
            }
            Z[i]=j;
            if(i+j>=text.length){
                if(Z[i]==patternLength){
                    counter++;
                }
                continue;
            }
            if(j>1){
                int l=i;
                int r=i+j-1;
                if(Z[i]==patternLength){
                    counter++;
                }
                i++;
                for(int k=1;k<=r-l;k++){
                    if(Z[k]+i>r){

                        int t=0;
                        l=i;
                        while(text[t+r-l+1]==text[r+t+1]){
                            t++;
                        }
                        Z[i]=t+Z[k];
                    }else{
                        Z[i]=Z[k];
                        if(Z[i]==patternLength){
                            counter++;
                        }
                        i++;
                    }
                }
            }

            if(Z[i]==patternLength){
                counter++;
            }
        }

//        for(int i=0;i<Z.length;i++){
//            if(Z[i]==patternLength){
//                counter++;
//            }
//            System.out.print(Z[i]+"\t");
//        }
//        System.out.println();
        return counter;

    }
    static int occurrence(String pattern, String text){
        return Z((pattern+"$"+text).toCharArray(), pattern.length());
    }
    public static void main(String[] args){
//        Z("aabxaabxcaabxaabxay".toCharArray());
        Scanner in=new Scanner(System.in);
        String pattern=in.next();
        String text=in.next();
        System.out.println(occurrence(pattern, text));
//        System.out.println();
    }
}