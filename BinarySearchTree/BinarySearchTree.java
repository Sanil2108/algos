import java.util.ArrayList;

class BinarySearchTree{
    int[] arr;
    int n;

    public BinarySearchTree(int size){
        arr=new int[size];
        n=0;
    }
    

    public void insert(int i, int v){
        if(n==0){
            arr[0]=v;
            n++;
            return;
        }
        int left=2*i+1;
        int right=2*i+2;
        if(arr[left]==0 && arr[right]==0){
            if(arr[i]<v){
                arr[right]=v;
            }else{
                arr[left]=v;
            }
            n++;
            return;
        }else if(arr[left]==0){
            if(arr[i]>v){
                arr[left]=v;
                n++;
                return;
            }else{
                insert(right, v);
            }
        }else if(arr[right]==0){
            if(arr[i]<v){
                arr[right]=v;
                n++;
                return;
            }else{
                insert(left, v);
            }
        }else{
            if(arr[i]>v){
                insert(left, v);
            }else{
                insert(right, v);
            }
        }

    }

    public void printArr(){
        for (int i:arr){
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public void insert(int v){
        insert(0, v);
    }

    public int find(int i, int v){
        int left=2*i+1;
        int right=2*i+2;
        if(arr[i]==0){
            return i;
        }
        if(arr[i]==v){
            return i;
        }
        if(arr[left]==v){
            return left;
        }
        if(arr[right]==v){
            return right;
        }
        if(arr[right]==0){
            if(v<arr[i]){
                return find(left,v);
            }else{
                return right;
            }
        }else if(arr[left]==0){
            if(v>arr[i]){
                return find(right, v);
            }else{
                return left;
            }
        }else{
            if(arr[i]>v){
                return find(left,v);
            }else{
                return find(right,v);
            }
        }
    }

    public int find(int v){
        return find(0,v);
    }

    public int next(int i){
        int left=2*i+1;
        int right=2*i+2;
        if (arr[right]!=0){
            int ptr=right;
            int leftOfPtr=2*ptr+1;
            while(arr[leftOfPtr]!=0){
                ptr=leftOfPtr;
                leftOfPtr=2*ptr+1;
            }
            return ptr;
        }else{
            int parent=(i-1)/2;
            int ptr=i;
            while(arr[parent]<arr[ptr] && parent>0){
                parent=(parent-1)/2;
            }
            if(arr[parent]<arr[ptr]){
                return -1;
            }
            return parent;
        }
    }

    public void swap(int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public int previous(int i){
        int left=2*i+1;
        if(arr[left]!=0){
            int ptr=left;
            while(arr[ptr]!=0){
                ptr=2*ptr+2;
            }
            return (ptr-1)/2;
        }else{
            int parent=(i-1)/2;
            while(parent!=0 && arr[parent]>arr[i]){
                parent=(parent-1)/2;
            }
            if(parent==0 && arr[parent]>arr[i]){
                return -1;
            }else{
                return parent;
            }
        }
    }

    public void delete(int i){
        if(arr[i]==0){
            return;
        }
        int parent=(i-1)/2;
        int left=2*i+1;
        int right=2*i+2;
        if(arr[left]==0 && arr[right]==0){
            arr[i]=0;
        }else if(arr[left]==0 && arr[right]!=0){
            int next=next(i);
            arr[i]=arr[next];
            delete(next);
        }else if(arr[left]!=0 && arr[right]==0){
            int previous=previous(i);
            arr[i]=arr[previous];
            delete(previous);
        }else{
            int next=next(i);
            arr[i]=arr[next];
            delete(next);
        }
    }

    public ArrayList<Integer> rangeSearch(int x, int y){
        ArrayList<Integer> array=new ArrayList<>();
        int temp=next(find(x));
        while(arr[temp]<y){
            array.add(arr[temp]);
            temp=next(temp);
            if(temp==-1){
                return array;
            }
        }
        return array;
    }

    public static void main(String[] args){
        BinarySearchTree b=new BinarySearchTree(64);
        // b.printArr();
        b.insert(40);
        b.insert(70);
        b.insert(60);
        b.insert(80);
        b.insert(20);
        b.insert(10);
        b.insert(30);
        b.insert(25);
        b.insert(27);
        b.insert(5);
        b.insert(65);
        b.insert(75);
        b.insert(7);

        // b.insert(4);
        // b.insert(1);
        // b.insert(15);
        // b.insert(17);
        // b.insert(5);
        // b.insert(6);
        // b.insert(7);

        // b.insert(5);
        // b.insert(4);
        // b.insert(2);
        // b.insert(1);

        b.printArr();
        // System.out.println(b.find(10));
        // System.out.println(b.arr[b.next(b.find(7))]);

        // ArrayList<Integer> array=b.rangeSearch(5, 18);
        // for(int i:array){
        //     System.out.print(i+"\t");
        // }
//        System.out.println(b.arr[b.previous(b.find(5))]);
         b.delete(b.find(40));
         b.printArr();
    }
}