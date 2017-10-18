#include <stdlib.h>
#include <iostream>

using namespace std;

struct Node {
    int level;
    struct Node* parent;
    struct Node* left;
    struct Node* right;
    int value;
};

class MaxHeap{
public:
    struct Node * root;
    MaxHeap(){
        root=NULL;
    }

    void startSiftUp(struct Node * newNode){
        struct Node *parent=newNode->parent;
        if(parent==NULL){
            return;
        }
        if(newNode->value<parent->value){
            return;
        }
        int newNodeValue=newNode->value;
        newNode->value=parent->value;
        parent->value=newNodeValue;
        startSiftUp(parent);
    }

    struct Node* find(int value, struct Node* root){
        if(root->value==value){
            return root;
        }else{
            if(root->left!=NULL){
                struct Node* rootLeft=find(value, root->left);
                if(rootLeft!=NULL){
                    return rootLeft;
                }
            }
            if(root->right!=NULL){
                struct Node* rootRight=find(value, root->right);
                if(rootRight!=NULL){
                    return rootRight;
                }
            }
            return NULL;
        }
    }

    struct Node* startSiftDown(struct Node * root){
        if(root->left==NULL && root->right==NULL){
//            if(root==root->parent->left){
//                root->parent->left=NULL;
//            }
//            if(root==root->parent->right){
//                root->parent->right=NULL;
//            }
            return root;
        }
        if(root->left!=NULL && root->right!=NULL){
            if(root->value<root->left->value && root->value<root->right->value){
                if(root->left->value>root->right->value){
                    int temp2=root->left->value;
                    root->left->value=root->value;
                    root->value=temp2;
                    return startSiftDown(root->left);
                }else{
                    int temp3=root->right->value;
                    root->right->value=root->value;
                    root->value=temp3;
                    return startSiftDown(root->right);
                }
            }else{
                if(root==root->parent->left){
                    root->parent->left=NULL;
                }
                if(root==root->parent->right){
                    root->parent->right=NULL;
                }
                return root;
            }
        }else if(root->left!=NULL){
            if(root->value<root->left->value){
                int temp2=root->left->value;
                root->left->value=root->value;
                root->value=temp2;
                return startSiftDown(root->left);
            }else{
                if(root==root->parent->left){
                    root->parent->left=NULL;
                }
                if(root==root->parent->right){
                    root->parent->right=NULL;
                }
                return root;
            }
        }else if(root->right!=NULL){
            if(root->value<root->right->value){
                int temp2=root->right->value;
                root->right->value=root->value;
                root->value=temp2;
                return startSiftDown(root->right);
            }else{
                if(root==root->parent->left){
                    root->parent->left=NULL;
                }
                if(root==root->parent->right){
                    root->parent->right=NULL;
                }
                return root;
            }
        }
    }

    struct Node* extractMax(){
        struct Node* leaf=getLeaf();

        struct Node* tempRoot=(struct Node*)malloc(sizeof(struct Node));
        tempRoot->value=root->value;
        tempRoot->left=NULL;
        tempRoot->right=NULL;
        tempRoot->parent=NULL;

        int temp=leaf->value;
        leaf->value=root->value;
        root->value=temp;

        if(leaf->parent->left==leaf){
            leaf->parent->left=NULL;
        }else{
            leaf->parent->right=NULL;
        }

        startSiftDown(root);

        return tempRoot;
    }

    void remove(struct Node * ptr){
    }

    void insertNode(int value){
        struct Node * newNode=(struct Node *)malloc(sizeof(struct Node));
        newNode->left=NULL;
        newNode->right=NULL;
        newNode->value=value;
        if(root==NULL){
            newNode->level=0;
            newNode->parent=NULL;
            root=newNode;
            return;
        }

        struct Node* ptr=getLeaf();
        newNode->parent=ptr;
        newNode->level=ptr->level+1;
        ptr->left=newNode;
        startSiftUp(newNode);
    }

    void insertNode(int value, int where){
        struct Node * newNode=(struct Node *)malloc(sizeof(struct Node));
        newNode->left=NULL;
        newNode->right=NULL;
        newNode->value=value;
        if(root==NULL){
            newNode->parent=NULL;
            root=newNode;
            return;
        }

        struct Node* ptr=getLeaf();
        newNode->parent=ptr;
        newNode->level=ptr->level+1;
        if(where==0){
            ptr->left=newNode;
        }else{
            ptr->right=newNode;
        }
        startSiftUp(newNode);
    }


    void traverseLNR(struct Node * root){
        //LNR Depth-First traversal
        if(root->left!=NULL){
            traverseLNR(root->left);
        }
        cout<<root->value<<"\n";
        if(root->right!=NULL){
            traverseLNR(root->right);
        }
    }

    void traverseNLR(struct Node * root){
        //NLR Depth-First traversal
        for(int i=0;i<root->level;i++){
            cout<<"---";
        }
        cout<<root->value<<"\n";
        if(root->left!=NULL){
            traverseNLR(root->left);
        }
        if(root->right!=NULL){
            traverseNLR(root->right);

        }
    }

    struct Node* getLeaf(){
        struct Node* ptr=root;
        while(1){
            if(ptr->left==NULL && ptr->right==NULL){
                return ptr;
            }
            if(ptr->left!=NULL){
                ptr=ptr->left;
                continue;
            }
            if(ptr->right!=NULL){
                ptr=ptr->right;
                continue;
            }
        }
    }

};

int main(){
    MaxHeap maxHeap;
    maxHeap.insertNode(7, 0);
    maxHeap.insertNode(8, 1);
    maxHeap.insertNode(10, 0);
    maxHeap.insertNode(9, 1);
    maxHeap.insertNode(12, 1);
    maxHeap.insertNode(6, 0);
    maxHeap.insertNode(11, 1);
    maxHeap.traverseNLR(maxHeap.root);
    cout<<"Max - "<<maxHeap.extractMax()->value<<"\n";
    maxHeap.traverseNLR(maxHeap.root);
    cout<<"Max - "<<maxHeap.extractMax()->value<<"\n";
    maxHeap.traverseNLR(maxHeap.root);
    cout<<"Max - "<<maxHeap.extractMax()->value<<"\n";
    maxHeap.traverseNLR(maxHeap.root);
    cout<<"Max - "<<maxHeap.extractMax()->value<<"\n";
    maxHeap.traverseNLR(maxHeap.root);
    // cout<<maxHeap.find(9, maxHeap.root)->parent->value;
    return 0;
}