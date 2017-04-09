import java.util.*;
import java.lang.*;
class HeapWithArray{

    ArrayList<Integer> contents;
    int currentIndex = 0;

    public HeapWithArray(){
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

    private void traverseTree(int i, int before, int levels){
        for(int i2=0;i2<before;i2++){
            System.out.print("-");
        }
        System.out.println(contents.get(i));
        if(levels-before!=1){
            if(i==0){
                traverseTree(1, ++before, levels);
                traverseTree(2, ++before, levels);
            }else{
                traverseTree(2*i, ++before, levels);
                traverseTree(2*i+1, ++before, levels);
            }
        }
    }

    public void traverseTree(){
        double t=Math.log(contents.size())/Math.log(2);
        if(t>=(int)t && t<((int)t+1)){
            t=(int)t;
        }else{
            t=(int)t+1;
        }

        
        t++;                            //t is just the number of levels or height, counting from 1                                                                                                             

        int height=(int)t;
        traverseTree(0, 0, height);
    }

    public static void main(String[] args){
        HeapWithArray heapWithArray=new HeapWithArray();
        heapWithArray.insert(1);
        heapWithArray.insert(2);
        heapWithArray.insert(3);
        heapWithArray.insert(4);
        heapWithArray.insert(5);
        heapWithArray.insert(6);
        heapWithArray.insert(7);
        heapWithArray.insert(8);
        heapWithArray.traverseByLevel();
        heapWithArray.traverseTree();
    }
}