import java.util.Scanner;

/**
 * Created by Admin on 14-07-2016.
 */
public class NewYearChaos {
    public static int getIndex(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        while (T>0){
            handler(in);
            T--;
        }
    }
    public static void handler(Scanner in){
        int n=in.nextInt();

        int[] tempArray=new int[n];

        for(int i=0;i<n;i++){
            tempArray[i]=in.nextInt();
        }

        int[] bribesArray=new int[tempArray.length];
        for(int i=0;i<bribesArray.length;i++){
            bribesArray[i]=0;
        }

//        for (int i = 0; i < tempArray.length; i++) {
//            System.out.print(tempArray[i] + ", ");
//        }
//        System.out.println();
        int bribes=0;
        int currentIndex=0;
        while(currentIndex<tempArray.length){
            int indexOfCorrectElement=getIndex(tempArray, currentIndex+1);
            if(tempArray[currentIndex]!=currentIndex+1) {
                if (indexOfCorrectElement - currentIndex > 2) {

                } else {

                    bribes+=(indexOfCorrectElement-currentIndex);
                    bribesArray[currentIndex]+=(indexOfCorrectElement-currentIndex);

                    if(bribesArray[currentIndex]>2){
                        System.out.println("Too chaotic");
                        return;
                    }


                    int temp = tempArray[indexOfCorrectElement];
                    tempArray[indexOfCorrectElement] = tempArray[currentIndex];
                    tempArray[currentIndex] = temp;

                    int tempBribes= bribesArray[indexOfCorrectElement];
                    bribesArray[indexOfCorrectElement]=bribesArray[currentIndex];
                    bribesArray[currentIndex]=tempBribes;

//                    for (int i = 0; i < tempArray.length; i++) {
//                        System.out.print(tempArray[i] + ", ");
//                    }
//                    System.out.print("bribes++");
                }

//                System.out.println();
            }
            currentIndex++;
        }
        System.out.println(bribes);
//        for (int i = 0; i < tempArray.length; i++) {
//            System.out.println(tempArray[i] + "-" + bribesArray[i]);
//        }
    }
}
