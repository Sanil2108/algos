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
    struct Node* root;

    BinarySearchTree(){
        root=NULL;
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

    void insert(int value){insert(value, root);}

    void traverseNLR(){traverseNLR(root);}

    void traverseNLR(struct Node *root){
        if(root!=NULL){
            cout<<root->value<<"\t";
        
            if(root->left!=NULL){
                traverseNLR(root->left);
            }
            if(root->right!=NULL){
                traverseNLR(root->right);
            }
        }
    }

    ~BinarySearchTree(){
        free(root);
    }
};

int main(){
    BinarySearchTree b;
    b.insert(10);
    b.insert(23);
    b.insert(8);
    b.insert(15);
    b.insert(1);
    b.insert(9);

    b.traverseNLR();
    cout<<"\n";

    return 0;
}