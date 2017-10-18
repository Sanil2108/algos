#include <stdlib.h>
#include <iostream>

using namespace std;

//original solution

struct Node{
    float value;
    struct Node* right;
    struct Node* left;
    int level;
};

class BinarySearchTree{
public:
    int size;
    struct Node* root;
    struct Node** arr;

    float* arrLNR;
    int arrLNRi;

    //level of root is 0 and it increments going downward
    // float* arrLNRlevel;
    // int arrLNRleveli;

    BinarySearchTree(int size){
        root=NULL;
        this->arr=new struct Node*[size];
        this->size=size;
    }

    void insert(float value, struct Node* root){
        if(root==NULL){
            this->root = (struct Node*)malloc(sizeof(struct Node));
            this->root->value=value;
            this->root->left=NULL;
            this->root->right=NULL;
            return;
        }
        if(value>=root->value){
            if(root->right!=NULL){
                insert(value, root->right);
            }else{
                struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
                newNode->value=value;
                newNode->left=NULL;
                newNode->right=NULL;
                root->right=newNode;
            }
        }else{
            if(root->left!=NULL){
                insert(value, root->left);
            }else{
                struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
                newNode->value=value;
                newNode->left=NULL;
                newNode->right=NULL;
                root->left=newNode;
            }
        }
    }

    void initElement(int index, float value){
        struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
        newNode->value=value;
        newNode->left=NULL;
        newNode->right=NULL;
        this->arr[index]=newNode;
        if(index==0){
            newNode->level=0;
            root=newNode;
        }
    }

    void assignChildren(int index, int left, int right){
        if(left!=-1){
            arr[index]->left=arr[left];
            arr[left]->level=arr[index]->level+1;
        }
        if(right!=-1){
            arr[index]->right=arr[right];
            arr[right]->level=arr[index]->level+1;
        }
    }

    void traverseLNR(){
        arrLNRi=0;
        arrLNR=new float[size];
        // arrLNRlevel=new int[size];
        // arrLNRleveli=0;
        traverseLNR(root);
    }

    void traverseLNR(struct Node *root){
        if(root!=NULL){
            if(root->left!=NULL){
                if((int)root->value==(int)root->left->value){
                    root->left->value=root->value+0.001;
                }
                traverseLNR(root->left);
            }
//            cout<<root->value<<" ";
            // *(arrLNRlevel+arrLNRleveli++)=root->level;
             *(arrLNR+arrLNRi++)=root->value;
            if(root->right!=NULL){
                if((int)root->value==(int)root->right->value){
                    root->right->value=root->value+0.001;
                }
                traverseLNR(root->right);
            }
        }
    }

    ~BinarySearchTree(){
        free(root);
        free(arr);
    }
};

bool checkIfSorted(float * a, int n){
    for(int i=0;i<n-1;i++){
        float temp=*(a+i);
        float temp2=*(a+i+1);
        if(!(*(a+i)<*(a+i+1))){
            return false;
        }
    }
    return true;
}

void problem(){
    int n;
    cin>>n;
    int arr[n][3];
    BinarySearchTree b(n);
    for(int i=0;i<n;i++){
        int t1, t2, t3;
        cin>>t1;
        cin>>t2;
        cin>>t3;
        arr[i][0]=t1;
        arr[i][1]=t2;
        arr[i][2]=t3;
        b.initElement(i, t1);
    }

    for(int i=0;i<n;i++){
        b.assignChildren(i, arr[i][1], arr[i][2]);
    }

    b.traverseLNR();
    if(checkIfSorted(b.arrLNR, n)){
        cout<<"CORRECT";
    }else{
        cout<<"INCORRECT";
    }

//    cout<<"\n";
//    b.traverseLNR();
}

int main(){

    problem();

    return 0;
}