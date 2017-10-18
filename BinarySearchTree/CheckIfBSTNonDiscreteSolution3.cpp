#include <stdlib.h>
#include <iostream>

using namespace std;

//original solution

struct Node{
    int value;
    struct Node* right;
    struct Node* left;
    int level;
};

class BinarySearchTree{
public:
    int size;
    struct Node* root;
    struct Node** arr;

    int* arrLNR;
    int arrLNRi;

    //level of root is 0 and it increments going downward
    int* arrLNRlevel;
    int arrLNRleveli;

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
        arrLNR=new int[size];
        arrLNRlevel=new int[size];
        arrLNRleveli=0;
        traverseLNR(root, INT32_MIN, INT32_MAX);
    }

    bool isBst=true;
    void traverseLNR(struct Node *root, int min, int max){
        if(root!=NULL){
            if(root->left!=NULL){
                traverseLNR(root->left, min, root->value);
            }
            if((root->value<min || root->value>=max) && root->value!=INT32_MAX){
                isBst=false;
                return;
            }
//            cout<<root->value<<" ";
            *(arrLNRlevel+arrLNRleveli++)=root->level;
            *(arrLNR+arrLNRi++)=root->value;
            if(root->right!=NULL){
                traverseLNR(root->right, root->value, max);
            }
        }
    }

    ~BinarySearchTree(){
        free(root);
        free(arr);
    }
};

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
    if(b.isBst){
        cout<<"CORRECT";
    }else{
        cout<<"INCORRECT";
    }

}

int main(){

    problem();
    return 0;
}