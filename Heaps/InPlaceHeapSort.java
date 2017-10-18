import java.util.Scanner;

class InPlaceHeapSort{
    int size;
    int[] heap;
    int currentIndexToInsert=0;

    int[] conversions;
    int conversionsI=0;

    int n;

    InPlaceHeapSort(int size){
        this.size=size;
        heap=new int[size];
        conversions=new int[size*2];
    }

    public void buildHeap(int[] A){
        heap=A;
        n=heap.length;
        for(int i=A.length/2;i>=0;i--){
            siftDown(i);
        }
        currentIndexToInsert=heap.length-1;
    }

    public int extractMin(){
        int temp=heap[0];
        heap[0]=heap[n-1];
        heap[n-1]=temp;
        n--;

        siftDown(0);

        return temp;
    }

    public void siftDown(int index){
        int left=2*(index+1)-1;
        int right=2*(index+1);
        if(left<n && right<n){
            //both the left and right child exist
            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    conversions[conversionsI]=index;
                    conversionsI++;
                    conversions[conversionsI]=left;
                    conversionsI++;
                    siftDown(left);
                } else {
                    int temp = heap[right];
                    conversions[conversionsI]=index;
                    conversionsI++;
                    conversions[conversionsI]=right;
                    conversionsI++;
                    heap[right] = heap[index];
                    heap[index] = temp;
                    siftDown(right);
                }
            }
        }else if(left<n){
            //only left child exists
            if(heap[index]>heap[left]) {
                int temp = heap[left];
                conversions[conversionsI]=index;
                conversionsI++;
                conversions[conversionsI]=left;
                conversionsI++;
                heap[left] = heap[index];
                heap[index] = temp;
                siftDown(left);
            }
        }else if(right<n){
            //only right child exists
            if(heap[right]<heap[index]) {
                int temp = heap[right];
                conversions[conversionsI]=index;
                conversionsI++;
                conversions[conversionsI]=right;
                conversionsI++;
                heap[right] = heap[index];
                heap[index] = temp;
                siftDown(right);
            }
        }
    }

    public void siftUp(int index){
        if (index==0){
            return;
        }
        if(heap[index]<heap[((index+1)/2)-1]){
            int temp=heap[index];
            heap[index]=heap[((index+1)/2)-1];
            heap[((index+1)/2)-1]=temp;
            int temp2=((index+1)/2)-1;

//            System.out.println(temp2+" "+index);
            conversions[conversionsI]=temp2;
            conversionsI++;
            conversions[conversionsI]=index;
            conversionsI++;

            siftUp(((index+1)/2)-1);
        }
    }

    public void insert(int a){
        heap[currentIndexToInsert]=a;
        siftUp(currentIndexToInsert);
        currentIndexToInsert++;
    }

    void traverse(){
        for(int i=0;i<heap.length;i++){
            System.out.print(heap[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args){
//        int[] A={1,3,2,4,5,9,10,8,7,15,13,12,11,14,6};
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] A=new int[n];
        for(int i=0;i<A.length;i++){
            A[i]=scanner.nextInt();
        }
        InPlaceHeapSort heap2=new InPlaceHeapSort(A.length);
        heap2.buildHeap(A);

        System.out.println(heap2.conversionsI/2);
        for(int i=0;i<heap2.conversionsI;i=i+2){
            System.out.println(heap2.conversions[i]+" "+
                heap2.conversions[i+1]);
        }
//        for(int i=0;i<A.length;i++){
//            System.out.println(heap2.extractMin());
//        }
//        for(int i=0;i<A.length;i++){
//            System.out.println(heap2.heap[i]);
//        }
    }
}