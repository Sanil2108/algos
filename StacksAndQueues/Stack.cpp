#include <iostream>
#include <string>

using namespace std;

class Stack{
    public:
    int top;
    int m_size;
    int *A;

    Stack(int size){
        m_size=size;
        A=new int[size];
        top=-1;
    }

    void print(){
        for(int i=0;i<=top;i++){
            cout<<A[i]<<"\t";
        }
        cout<<"\n";
    }  

    void push(int value){
        if(top==m_size-1){
            return;
        }
        A[++top]=value;
    }

    int pop(){
        if(top==-1){
            return -1;
        }
        int item=A[top--];
        return item;
    }
};

int main(){
    return 0;
}