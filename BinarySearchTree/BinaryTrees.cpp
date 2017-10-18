#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;


struct treeNode{
    int value;
    struct treeNode * left;
    struct treeNode * right;
};

struct node{
    struct treeNode* treeNode;
    struct node* next;
    struct node* prev;
};

class DoublyLinkedList{
public:
    struct node * head;
    struct node * tail;

    DoublyLinkedList(){
        head = NULL;
        tail = NULL;
    }

    struct node* topFront(){
        return head;
    }

    struct node * dequeue(){
        struct node * p = head;
        if(head==NULL){
            return NULL;
        }
        if(head->next==NULL){
            head=NULL;
            tail=NULL;
            return p;
        }
        head=head->next;
        head->prev = NULL;
        return p;
    }

    void enqueue(struct treeNode * val){
        struct node *n=(struct node *)malloc(sizeof(struct node*));
        n->treeNode=val;
        if(head == NULL){
            head=n;
            n->prev=NULL;
            n->next=NULL;
            tail=n;
            return;
        }
        n->prev=tail;
        tail->next=n;
        tail=n;
    }

    struct node * getTail(){
        return tail;
    }

    struct node* topbackWithTail(){
        return tail;
    }

    void printNextPrev(){
        struct node * p=head;
        cout<<"Previous\tCurrent\t\tNext\n";
        while(p!=NULL){
            if(p->prev != NULL){
                cout<<p->prev->treeNode->value<<"\t\t";
            }else{
                cout<<"NULL\t\t";
            }
            cout<<p->treeNode->value<<"\t\t";
            if(p->next != NULL){
                cout<<p->next->treeNode->value<<"\t\t";
            }else{
                cout<<"NULL";
            }
            cout<<"\n";
            p=p->next;
        }
    }

    void print(){
        struct node * p=head;
        while(p!=NULL){
            cout<<p->treeNode->value<<"\t";
            p=p->next;
        }
        cout<<"\n";
    }

    bool empty(){
        return head==NULL;
    }
};

class BinaryTree{
public:
    struct treeNode * root;

    BinaryTree(int value){
        root=(struct treeNode*)malloc(sizeof(struct treeNode *));
        root->left=NULL;
        root->right=NULL;
        root->value=value;
    }

    void insert(int value, struct treeNode * root){
        if(root->value>value){
            if(root->left!=NULL){
                insert(value, root->left);
            }else{
                struct treeNode * newtreeNode = (struct treeNode*)malloc(sizeof(struct treeNode *));
                newtreeNode->left=NULL;
                newtreeNode->right=NULL;
                newtreeNode->value=value;
                root->left=newtreeNode;
                return;
            }
        }else{
            if(root->right!=NULL){
                insert(value, root->right);
            }else{
                struct treeNode * newtreeNode = (struct treeNode*)malloc(sizeof(struct treeNode *));
                newtreeNode->left=NULL;
                newtreeNode->right=NULL;
                newtreeNode->value=value;
                root->right=newtreeNode;
                return;
            }
        }
    }

    struct treeNode * getRoot(){
        return root;
    }

    void traverse_dfs_nlr(struct treeNode * root){
        cout<<root->value<<"\t";
        if(root->left!=NULL){
            traverse_dfs_nlr(root->left);
        }
        if(root->right!=NULL){
            traverse_dfs_nlr(root->right);
        }
    }

    void traverse_dfs_lnr(struct treeNode * root){
        if(root->left!=NULL){
            traverse_dfs_lnr(root->left);
        }
        cout<<root->value<<"\t";
        if(root->right!=NULL){
            traverse_dfs_lnr(root->right);
        }
    }

    void traverse_dfs_lrn(struct treeNode * root){
        if(root->left!=NULL){
            traverse_dfs_lrn(root->left);
        }
        if(root->right!=NULL){
            traverse_dfs_lrn(root->right);
        }
        cout<<root->value<<"\t";
    }

    void traverse_bfs(){
        DoublyLinkedList q;
        q.enqueue(root);
        struct treeNode* temp;
        while(!q.empty()){
            temp=q.dequeue()->treeNode;
            cout<<temp->value<<"\n";
            if(temp->left!=NULL){
                q.enqueue(temp->left);
            }
            if(temp->right!=NULL){
                q.enqueue(temp->right);
            }
        }
    }
};

int main(){
    return 0;
}
