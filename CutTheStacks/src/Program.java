import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 11-07-2016.
 */
public class Program {

    public static int findHieght(int[] A){
        int height=0;
        for(int i=0;i<A.length;i++){
            height+=A[i];
        }
        return height;
    }

    public static void stressTest(){
        Random random=new Random();
        for(int t=0;t<10;t++){
            int array1size=random.nextInt(10);
            int array2size=random.nextInt(10);
            int array3size=random.nextInt(10);

            int[] stack1=new int[array1size];
            int[] stack2=new int[array2size];
            int[] stack3=new int[array3size];

            int stack1Index=0, stack2Index=0, stack3Index=0;
            System.out.print(array1size+" "+array2size+" "+array3size+"\n");

            for(int i=0;i<stack1.length;i++){
                stack1[i]=random.nextInt(10);
                System.out.print(stack1[i]+" ");
            }
            System.out.println();
            for(int i=0;i<stack2.length;i++){
                stack2[i]=random.nextInt(10);
                System.out.print(stack2[i]+" ");
            }
            System.out.println();
            for(int i=0;i<stack3.length;i++){
                stack3[i]=random.nextInt(10);
                System.out.print(stack3[i]+" ");
            }


            int stack1Height=findHieght(stack1);
            int stack2Height=findHieght(stack2);
            int stack3Height=findHieght(stack3);

            while (stack1Height!=stack2Height||stack2Height!=stack3Height){
                if(stack1Height>stack2Height&&stack1Height>stack3Height){
                    stack1Height-=stack1[stack1Index];
                    stack1[stack1Index]=0;
                    stack1Index++;

                }
                else if(stack2Height>stack3Height&&stack2Height>stack1Height){
                    stack2Height-=stack2[stack2Index];
                    stack2[stack2Index]=0;
                    stack2Index++;

                }
                else if(stack3Height>stack2Height&&stack3Height>stack1Height){
                    stack3Height-=stack3[stack3Index];
                    stack3[stack3Index]=0;
                    stack3Index++;

                }
//            System.out.print(findHieght(stack1)+", "+findHieght(stack2)+", "+findHieght(stack3)+"\n");
            }
            System.out.println("\n"+stack1Height);
        }
    }

    public static void main(String[] args){
        stressTest();
    }

    public static void stacks(){

        Scanner in=new Scanner(System.in);
        int stack1Cylinders=in.nextInt();
        int stack2Cylinders=in.nextInt();
        int stack3Cylinders=in.nextInt();

        int[] stack1=new int[stack1Cylinders];
        int[] stack2=new int[stack2Cylinders];
        int[] stack3=new int[stack3Cylinders];

        int stack1Index=0, stack2Index=0, stack3Index=0;

        for(int i=0;i<stack1.length;i++){
            stack1[i]=in.nextInt();
        }
        for(int i=0;i<stack2.length;i++){
            stack2[i]=in.nextInt();
        }
        for(int i=0;i<stack3.length;i++){
            stack3[i]=in.nextInt();
        }

        int stack1Height=findHieght(stack1);
        int stack2Height=findHieght(stack2);
        int stack3Height=findHieght(stack3);

        while (stack1Height!=stack2Height||stack2Height!=stack3Height){
            if(stack1Height>stack2Height&&stack1Height>stack3Height){
                stack1Height-=stack1[stack1Index];
                stack1[stack1Index]=0;
                stack1Index++;

            }
            else if(stack2Height>stack3Height&&stack2Height>stack1Height){
                stack2Height-=stack2[stack2Index];
                stack2[stack2Index]=0;
                stack2Index++;

            }
            else if(stack3Height>stack2Height&&stack3Height>stack1Height){
                stack3Height-=stack3[stack3Index];
                stack3[stack3Index]=0;
                stack3Index++;

            }
//            System.out.print(findHieght(stack1)+", "+findHieght(stack2)+", "+findHieght(stack3)+"\n");
        }
        System.out.println(stack1Height);
    }

}
