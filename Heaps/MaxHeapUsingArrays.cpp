#include <iostream>
#include <stdlib.h>

using namespace std;

class BinaryDynamicMaxHeap{
    public:
    int size;
    int n;
    int* A;
    int lastElement;

    BinaryDynamicMaxHeap(int n){
        size=n*2;
        A=new int[size];
        for(int i=0;i<size;i++){
            *(A+i) = 0;
        }
        lastElement=0;
    }

    void siftUp(int e){
        if(e==0){
            return;
        }
        if(A[e]>A[(int)((e-1)/2)]){
            int temp=A[e];
            A[e]=A[(int)((e-1)/2)];
            A[(int)((e-1)/2)]=temp;
            siftUp((int)((e-1)/2));
        }
    }

    void insert(int value){
        if(n+1>size){
            // array needs resizing
            // size=n*2;
            // int *temp=new int[size];
            // for(int i=0;i<n+1;i++){
            //     temp[i]=A[i];
            // }
            // for(int i=n+1;i<size;i++){
            //     A[i]=0;
            // }
            // A=temp;
        }
        A[lastElement]=value;
        n++;
        siftUp(lastElement);
        lastElement++;
    }

    int extractMax(){
        int max=A[0];
        A[0]=A[lastElement-1];
        A[lastElement--]=0;
        n--;
        siftDown(0);
        return max;
    }

    void siftDown(int e){
        int leftChildIndex=2*(e+1);
        int rightChildIndex=2*(e+1)-1;
        int a = A[e];
        int b=A[leftChildIndex];
        int c=A[rightChildIndex];
        if(A[e]>=A[leftChildIndex] && A[e]>=A[rightChildIndex]){
            return;
        }
        int temp;
        if(A[leftChildIndex]>A[rightChildIndex]){
            temp=leftChildIndex;
        }else{
            temp=rightChildIndex;
        }
        int temp2 = A[temp];
        A[temp] = A[e];
        A[e]=temp2;
        siftDown(temp);
    }

    void printArr(){
        for(int i=0;i<n;i++){
            cout<<A[i]<<"\t";
        }
        cout<<"\n";
    }

    void traverse_depth_first_nlr(int e){
        cout<<A[e]<<"\t";
        if(2*(e+1)-1 < n){
            //left child exists
            traverse_depth_first_nlr(2*(e+1)-1);
        }
        if(2*(e+1) < n){
            //right child exists
            traverse_depth_first_nlr(2*(e+1));
        }
    }

    void traverse_depth_first_lnr(int e){
        if(2*(e+1)-1 < n){
            //left child exists
            traverse_depth_first_nlr(2*(e+1)-1);
        }
        cout<<A[e]<<"\t";
        if(2*(e+1) < n){
            //right child exists
            traverse_depth_first_nlr(2*(e+1));
        }
    }
};

int main(){
    BinaryDynamicMaxHeap m(6);
    m.insert(1);
//    m.printArr();
//    cout<<"\n";
    m.insert(2);
//    m.printArr();
//    cout<<"\n";
    m.insert(3);
//    m.printArr();
//    cout<<"\n";
    m.insert(4);
//    m.printArr();
//    cout<<"\n";
    m.insert(5);
//    m.printArr();
//    cout<<"\n";
    m.insert(6);
//    m.printArr();
//    cout<<"\n";
    m.insert(7);
//    m.printArr();
//    cout<<"\n";
    m.insert(8);
    m.insert(9);
//    m.printArr();
//    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    cout<<"\nMAX  - "<<m.extractMax()<<"\n";
    m.printArr();
    cout<<"\n";
    // cout<<"MAX  - "<<m.extractMax()<<"\n";
    // m.traverse_depth_first_nlr(0);
    // cout<<"MAX  - "<<m.extractMax()<<"\n";
    // m.traverse_depth_first_nlr(0);
    // cout<<"MAX  - "<<m.extractMax()<<"\n";
    return 0;
}