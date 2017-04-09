import java.util.*;
import java.lang.*;
//Done using arrays instead of ArrayList<Integer>.
//This will increase overall speed
class HeapSort2{

    Integer[] contents;
    int currentIndex = 0;

    public HeapSort2(int size){
        contents=new Integer[size];
    }

    public void insert(int value){
        if(currentIndex>0){
            contents[currentIndex]=new Integer(value);
            // contents.add(currentIndex,
            //         new Integer(value));
            int tempIndex=currentIndex;
            while(contents[tempIndex]>contents[tempIndex/2]){
                int a = contents[tempIndex];
                int b = contents[(int)(tempIndex)/2];
                contents[tempIndex]=b;
                contents[(int)(tempIndex/2)]=a;
                tempIndex=(int)tempIndex/2;
            }
            currentIndex++;
        }else{
            contents[currentIndex++] = new Integer(value);
            // contents.add(currentIndex++,
            //         new Integer(value));
        }
    }

    public void traverseByLevel(){
        for(int i=0;i<contents.length;i++){
            int level=(int)(Math.log(i+1)/Math.log(2));
            for(int j=0;j<level;j++){
                System.out.print("--");
            }
            System.out.println(contents[i]);
        }
    }

    public void swap(int i, int j){
        int a=contents[i];
        int b=contents[j];
        contents[j]=a;
        contents[i]=b;
    }

    public int[] getChildren(int i){
        i=i+1;
        int[] children;
        if(i==1){
            if(contents.length==1){
                children=new int[1];
                children[0]=contents[1];
            }else{
                children=new int[2];
                children[0]=contents[1];
                children[1]=contents[2];
            }
        }else{
            if(contents.length==2*i){
                children=new int[1];
                children[0]=contents[2*i-1];
            }else{
                children=new int[2];
                children[0]=contents[2*i-1];
                children[1]=contents[2*i];
            }
        }
        return children;
    }

    public int[] getChildrenIndex(int i){

        i=i+1;
        int[] children;
        if(i==1){
            if(contents.length==1){
                children=new int[1];
                children[0]=1;
            }else{
                children=new int[2];
                children[0]=1;
                children[1]=2;
            }
        }else{
            if(contents.length==2*i){
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
        for(int i=0;i<children.length && children[i]<contents.length;i++){
            if(contents[children[i]] > contents[index]){
                arranged=false;
            }
        }
        if(!arranged){
            int max_child=0;
            for(int i=0;i<children.length;i++){
                if(contents[children[i]] > contents[index]){
//                    swap(children[i], index);
//                    arrange(children[i]);
//                    return;
                    if(contents[children[i]]>contents[children[max_child]]){
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
        if(currentIndex==0){
            return A;
        }
        swap(0, currentIndex-1);
        System.out.print(contents[currentIndex-1]+"\t");
        A.add(new Integer(contents[currentIndex-1]));
//        int a=contents.get(0);
//        int b=contents.get(currentIndex-1);
//        contents.set(currentIndex-1, a);
//        contents.set(0, b);


        // contents.remove(currentIndex-1);
        

        arrange(0);
        currentIndex--;
        sort(A);
        return A;
    }

    public static void main(String[] args){
        HeapSort2 heapWithArray=new HeapSort2(8);
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