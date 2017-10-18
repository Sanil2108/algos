#include <iostream>
#include <string>

using namespace std;

class CustomArray{
    public:
    int m_size;
    int * m_arr;
    int lastFilled;

    CustomArray(int size){
        m_size = size;
        m_arr = new int[size];
        lastFilled = 0;
    }

    void print(){
        for(int i=0;i<lastFilled;i++){
            cout<<m_arr[i]<<"\t";
        }
        cout<<"\n";
    }

    void insert(int val){
        m_arr[lastFilled++]=val;
    }

    void insert(int i, int val){
        for(int j=m_size-1; j>=i; j--){
            m_arr[j]=m_arr[j-1];
        }
        m_arr[i] = val;
        lastFilled++;
    }

    void remove(int i){
        for(int j=i;j<m_size-1;j++){
            m_arr[j]=m_arr[j+1];
        }
        lastFilled--;
    }

};

int main(){
    CustomArray c(10);
    c.insert(1);
    c.insert(2);
    c.print();
    c.insert(3);
    c.insert(4);
    c.print();
    c.insert(1, 5);
    c.print();
    c.remove(2);
    c.print();
    return 0;
}