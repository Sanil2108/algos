#include <iostream>
#include <string>

using namespace std;

class Queue{
    public:
    int F;
    int R;
    int* m_arr;
    int m_size;
    
    Queue(int size){
        m_size=size;
        m_arr=new int[size];
        F=0;
        R=1;
    }

    void enqueue(int value){
        if(R==m_size){
            R=0;
        }
        if(F==R){
            cout<<"Overflow\n";
            return;
        }
        m_arr[R++]=value;
    }

    int dequeue(){
        if(F==0 && R==0){
            cout<<"Queue is empty bc\n";
            return -1;
        }
        if(F==m_size-1){
            F=0;
        }
        m_arr[++F]=0;
    }

    void print(){
        for(int i=0;i<m_size;i++){
            cout<<m_arr[i]<<"\t";
        }
        cout<<"\n";
    }
};

int main(){
    return 0;
}