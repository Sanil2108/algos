import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 02-07-2016.
 */
public class CoveringSegments {
    public static ArrayList<Segment> mainSegments;

    public static class Segment{
        long start, end;
        Segment(long start, long end){
            this.start=start;
            this.end=end;
        }
    }

    public static void pointsInput(long start, long end){

        for(int i=0;i<mainSegments.size();i++){

            if(start>mainSegments.get(i).end||end<mainSegments.get(i).start){


            }else {

                if (start > mainSegments.get(i).start) {
                    mainSegments.get(i).start = start;
                }
                if (end < mainSegments.get(i).end) {
                    mainSegments.get(i).end = end;
                }

                return;
            }
        }


        Segment segment=new Segment(start, end);
        mainSegments.add(segment);

    }

    public static void printSegments(){
        for(int i=0;i<mainSegments.size();i++){

//            if(mainSegments.get(i).start!=mainSegments.get(i).end) {
//                System.out.println(mainSegments.get(i).start + " " + mainSegments.get(i).end);
//            }else{
//                System.out.println(mainSegments.get(i).end);
//            }

            System.out.println(mainSegments.get(i).end);
        }
    }

    public static void main(String[] args){
        mainSegments=new ArrayList<>();
        Segment segment=new Segment(0, 1000000000);
        mainSegments.add(segment);

        Scanner in = new Scanner(System.in);
        int numberOfCases=in.nextInt();

        for(int i=0; i<numberOfCases; i++){
            long start=in.nextLong();
            long end=in.nextLong();
            pointsInput(start, end);
        }

        System.out.println(mainSegments.size());
        printSegments();
    }
}
