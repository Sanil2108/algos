import java.util.*;
import java.lang.*;
class HeapSort1{

    ArrayList<Integer> contents;
    int currentIndex = 0;

    public HeapSort1(){
        contents=new ArrayList<Integer>();
    }

    public void insert(int value){
        if(currentIndex>0){
            contents.add(currentIndex,
                    new Integer(value));
            int tempIndex=currentIndex;
            while(contents.get(tempIndex)>contents.get(tempIndex/2)){
                int a = contents.get(tempIndex);
                int b = contents.get((int)(tempIndex)/2);
                contents.set(tempIndex, b);
                contents.set((int)tempIndex/2, a);
                tempIndex=(int)tempIndex/2;
            }
            currentIndex++;
        }else{
            contents.add(currentIndex++,
                    new Integer(value));
        }
    }

    public void traverseByLevel(){
        for(int i=0;i<contents.size();i++){
            int level=(int)(Math.log(i+1)/Math.log(2));
            for(int j=0;j<level;j++){
                System.out.print("--");
            }
            System.out.println(contents.get(i));
        }
    }

//    private void traverseTree(int i, int before, int levels){
//        if(2*i-1<contents.size()) {
//            for (int i2 = 0; i2 < before; i2++) {
//                System.out.print("-");
//            }
//            System.out.println(contents.get(i - 1));
//            if (levels - before > 1) {
//                if (i == 1) {
//                    traverseTree(2, ++before, levels);
//                    traverseTree(3, ++before, levels);
//                } else {
//                    traverseTree(2 * i, ++before, levels);
//                    traverseTree(2 * i + 1, ++before, levels);
//                }
//            }
//        }
//    }

//    public void traverseTree(){
//        double t=Math.log(contents.size())/Math.log(2);
//        if(t>=(int)t && t<((int)t+1)){
//            t=(int)t;
//        }else{
//            t=(int)t+1;
//        }
//
//
//        t++;                            //t is just the number of levels or height, counting from 1
//
//        int height=(int)t;
//        traverseTree(1, 0, height);
//    }

    public void swap(int i, int j){
        int a=contents.get(i);
        int b=contents.get(j);
        contents.set(j, a);
        contents.set(i, b);
    }

    public int[] getChildren(int i){
        i=i+1;
        int[] children;
        if(i==1){
            if(contents.size()==1){
                children=new int[1];
                children[0]=contents.get(1);
            }else{
                children=new int[2];
                children[0]=contents.get(1);
                children[1]=contents.get(2);
            }
        }else{
            if(contents.size()==2*i){
                children=new int[1];
                children[0]=contents.get(2*i-1);
            }else{
                children=new int[2];
                children[0]=contents.get(2*i-1);
                children[1]=contents.get(2*i);
            }
        }
        return children;
    }

    public int[] getChildrenIndex(int i){

        i=i+1;
        int[] children;
        if(i==1){
            if(contents.size()==1){
                children=new int[1];
                children[0]=1;
            }else{
                children=new int[2];
                children[0]=1;
                children[1]=2;
            }
        }else{
            if(contents.size()==2*i){
                children=new int[1];
                children[0]=2*i-1;
            }else{
                children=new int[2];
                children[0]=2*i-1;
                children[1]=2*i;
            }
        }
        return children;
    }

    public void arrange(int index){
        int[] children=getChildrenIndex(index);
        boolean arranged=true;
        for(int i=0;i<children.length && children[i]<contents.size();i++){
            if(contents.get(children[i]) > contents.get(index)){
                arranged=false;
            }
        }
        if(!arranged){
            int max_child=0;
            for(int i=0;i<children.length;i++){
                if(contents.get(children[i]) > contents.get(index)){
//                    swap(children[i], index);
//                    arrange(children[i]);
//                    return;
                    if(contents.get(children[i])>contents.get(children[max_child])){
                        max_child=i;
                    }
                }
            }
            swap(children[max_child], index);
            arrange(children[max_child]);
            return;
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> A){
        if(contents.size()==0){
            return A;
        }
        swap(0, currentIndex-1);
        System.out.print(contents.get(currentIndex-1)+"\t");
        A.add(new Integer(contents.get(currentIndex-1)));
//        int a=contents.get(0);
//        int b=contents.get(currentIndex-1);
//        contents.set(currentIndex-1, a);
//        contents.set(0, b);
        contents.remove(currentIndex-1);
        arrange(0);
        currentIndex--;
        sort(A);
        return A;
    }

    public static void main(String[] args){
        HeapSort1 heapWithArray=new HeapSort1();
        heapWithArray.insert(8);
        heapWithArray.insert(4);
        heapWithArray.insert(7);
        heapWithArray.insert(1);
        heapWithArray.insert(3);
        heapWithArray.insert(5);
        heapWithArray.insert(17);
        heapWithArray.insert(12);
        heapWithArray.traverseByLevel();
        ArrayList<Integer> A=new ArrayList<>();
        A=heapWithArray.sort(A);
        System.out.println();
        for(int i=0;i<A.size();i++){
            System.out.print(A.get(i)+"\t");
        }
    }
}