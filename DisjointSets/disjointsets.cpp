#include<iostream>
using namespace std;
class DisjointSets{
    public:
    int *rank;
    int *parent;
    int *elements;
    int size;
    void makeSet(int i){
        parent[i]=i;
        rank[i]=0;
    }
    DisjointSets(int size){
        this->size=size;
        rank=new int[size];
        elements=new int[size];
        parent=new int[size];
        for(int i=0;i<size;i++){
            makeSet(i);
        }
    }
    int find(int element){
        while(element!=parent[element]){
            element=parent[element];
        }
        return element;
    }
    void union1(int element1, int element2){
        int parent1=find(element1);
        int parent2=find(element2);
        if(parent1==parent2){
            return;
        }
        if(rank[parent1]>rank[parent2]){
            parent[parent2]=parent1;
        }else{
            parent[parent1]=parent2;
            if(rank[parent1]==rank[parent2]){
                rank[parent2]++;
            }
        }
    }
    void print(){
        for(int i=0;i<size;i++){
            cout<<i<<"\t";
        }
        cout<<"\n";
        for(int i=0;i<size;i++){
            cout<<parent[i]<<"\t";
        }
        cout<<"\n";
        for(int i=0;i<size;i++){
            cout<<rank[i]<<"\t";
        }
        cout<<"\n\n";
    }
};
int main(){
    
    return 0;
}