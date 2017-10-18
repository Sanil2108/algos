#include <stdlib.h>
#include <iostream>

using namespace std;

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
        traverseLNR(root);
    }

    void traverseLNR(struct Node *root){
        if(root!=NULL){
            if(root->left!=NULL){
                traverseLNR(root->left);
            }
//            cout<<root->value<<" ";
            *(arrLNRlevel+arrLNRleveli++)=root->level;
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

    int index;
    void traverseForArray(struct Node* root, int* arr){
        if(root->left!=NULL){
            traverseForArray(root->left, arr);
        }
        arr[++index]=root->value;
        if(root->right!=NULL){
            traverseForArray(root->right, arr);
        }
    }

    bool bruteForceForNode(struct Node* i){
        struct Node* right=i->right;
        struct Node* left=i->left;

        //checking the right
        if(i->right!=NULL) {
            int *arrRight = new int[size];
            for (int i = 0; i < size; i++) {
                arrRight[i] = -1;
            }
            index = -1;
            traverseForArray(right, arrRight);
            for (int i2 = 0; i2 < size; i2++) {
                int temp = arrRight[i2];
                if (arrRight[i2] != -1 && arrRight[i2] < i->value) {
                    return false;
                }
            }
        }

        //checking the left
        if(i->left!=NULL) {
            int *arrLeft = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                arrLeft[i2] = -1;
            }
            index = -1;
            traverseForArray(left, arrLeft);
            for (int i2 = 0; i2 < size; i2++) {
                int temp = arrLeft[i2];
                if (arrLeft[i2] != -1 && arrLeft[i2] >= i->value) {
                    return false;
                }
            }
        }

        return true;
    }

    bool bruteForce(struct Node * root){
        if(root->left!=NULL){
            if(bruteForce(root->left)==false){
                return false;
            }
        }
        if(bruteForceForNode(root)==false){
            return false;
        }
        if(root->right!=NULL){
            if(bruteForce(root->right)==false){
                return false;
            }
        }
        return true;
//        cout<<bruteForceForNode(root);
    }
};

bool checkIfSorted2(int * a, int n, int* level){
    for(int i=1;i<n-1;i+=1){
        if(!( (*(a+i-1)<*(a+i)) && (*(a+i)<=*(a+i+1)) )){
            return false;
        }
        if((*(a+i)==*(a+i+1)) && *(level+i)<*(level+i+1)){
            i++;
        }
    }
    return true;
}

void problemBruteForce(){
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
    // for(int i=0;i<n;i++){
    //     cout<<*(b.arrLNR+i)<<" ";
    // }
    // cout<<"\n";
    // for(int i=0;i<n;i++){
    //     cout<<*(b.arrLNRlevel+i)<<" ";
    // }

    if(b.bruteForce(b.root)){
        cout <<"CORRECT";
    }else {
        cout <<"INCORRECT";
    }

//    if(b.bruteForce()){
    // if(checkIfSorted2(b.arrLNR, n, b.arrLNRlevel)){
//        cout<<"CORRECT\n";
//    }else{
//        cout<<"INCORRECT\n";
//    }


}

int main(){

    problemBruteForce();

    return 0;
}