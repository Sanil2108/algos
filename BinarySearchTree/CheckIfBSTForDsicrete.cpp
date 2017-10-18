#include <stdlib.h>
#include <iostream>

using namespace std;

struct Node{
    int value;
    struct Node* right;
    struct Node* left;
};

class BinarySearchTree{
public:
    int size;
    struct Node* root;
    struct Node** arr;

    int* arrLNR;
    int arrLNRi;

    BinarySearchTree(int size){
        root=NULL;
        this->arr=new struct Node*[size];
        this->size=size;
    }

    void insert(int value, struct Node* root){
        if(root==NULL){
            this->root = (struct Node*)malloc(sizeof(struct Node));
            this->root->value=value;
            this->root->left=NULL;
            this->root->right=NULL;
            return;
        }
        if(value>root->value){
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

    void initElement(int index, int value){
        struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
        newNode->value=value;
        newNode->left=NULL;
        newNode->right=NULL;
        this->arr[index]=newNode;
        if(index==0){
            root=newNode;
        }
    }

    void assignChildren(int index, int left, int right){
        if(left!=-1){
            arr[index]->left=arr[left];
        }
        if(right!=-1){
            arr[index]->right=arr[right];
        }
    }

    void traverseLNR(){
        arrLNRi=0;
        arrLNR=new int[size];
        traverseLNR(root);
    }

    void traverseLNR(struct Node *root){
        if(root!=NULL){
            if(root->left!=NULL){
                traverseLNR(root->left);
            }
//            cout<<root->value<<" ";
            *(arrLNR+arrLNRi++)=root->value;
            if(root->right!=NULL){
                traverseLNR(root->right);
            }
        }
    }

//    void traverseLRN(){traverseLRN(root);}
//
//    void traverseLRN(struct Node *root){
//        if(root!=NULL){
//
//            if(root->left!=NULL){
//                traverseLRN(root->left);
//            }
//            if(root->right!=NULL){
//                traverseLRN(root->right);
//            }
//            cout<<root->value<<" ";
//        }
//    }
//
//    void traverseNLR(){
//        traverseNLR(root);
//    }
//
//    void traverseNLR(struct Node *root){
//        if(root!=NULL){
//            cout<<root->value<<" ";
//
//            if(root->left!=NULL){
//                traverseNLR(root->left);
//            }
//            if(root->right!=NULL){
//                traverseNLR(root->right);
//            }
//        }
//    }

    ~BinarySearchTree(){
        free(root);
        free(arr);
    }
};

bool checkIfSorted(int * a, int n){
    for(int i=0;i<n-1;i++){
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
//    cout<<"\n";
//    for(int i=0;i<n;i++){
//        cout<<*(b.arrLNR+i)<<" ";
//    }
    if(checkIfSorted(b.arrLNR, n)){
        cout<<"CORRECT\n";
    }else{
        cout<<"INCORRECT\n";
    }
    // b.traverseNLR();
    // cout<<"\n";
    // b.traverseLRN();
    // cout<<"\n";


}

int main(){

    problem();

    return 0;
}