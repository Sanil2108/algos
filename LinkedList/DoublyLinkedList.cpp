#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

struct node{
    int value;
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

    void pushFront(int value){
        struct node* n = (struct node *)malloc(sizeof(struct node));
        n->value = value;
        n->prev = NULL;
        n->next = head;
        if(head == NULL){
            tail=n;
        }
        if(head != NULL){
            head->prev = n;
        }
        head = n;
    }

    struct node * popFront(){
        struct node * p = head;
        if(head->next != NULL){
            head=head->next;
            head->prev = NULL; 
        }
        return p;
    }

    void pushBackWithoutTail(int val){
        struct node * p = head;
        struct node * newNode = (struct node *)malloc(sizeof(struct node));
        newNode->value = val;
        if(head == NULL){
            head=newNode;
            newNode->prev=NULL;
            newNode->next=NULL;
            return;
        }
        while(p->next != NULL){
            p=p->next;
        }
        p->next=newNode;
        newNode->next=NULL;
        newNode->prev=p;
    }

    void pushBackWithTail(int val){
        struct node *n=(struct node *)malloc(sizeof(struct node));
        n->value=val;
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

    struct node* topBackWithoutTail(){
        if(head==NULL){
            return NULL;
        }
        struct node * p = head;
        if(head->next==NULL){
            return p;
        }
        while(p->next->next!=NULL){
            p=p->next;
        }
        return p->next;
    }

    struct node* topbackWithTail(){
        return tail;
    }

    struct node * popBackWithoutTail(){
        if(head==NULL){
            return NULL;
        }
        struct node * p = head;
        if(head->next==NULL){
            head=NULL;
            return p;
        }
        while(p->next->next!=NULL){
            p=p->next;
        }
        struct node * save=p->next;
        p->next=NULL;
        return save;
    }

    struct node * popBackWithTail(){
        struct node *p=tail;
        tail->prev=NULL;
        return p;
    }

    void printNextPrev(){
        struct node * p=head;
        cout<<"Previous\tCurrent\t\tNext\n";
        while(p!=NULL){
            if(p->prev != NULL){
                cout<<p->prev->value<<"\t\t";
            }else{
                cout<<"NULL\t\t";
            }
            cout<<p->value<<"\t\t";
            if(p->next != NULL){
                cout<<p->next->value<<"\t\t";
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
            cout<<p->value<<"\t";
            p=p->next;
        }
        cout<<"\n";
    }

    struct node * find(int value){
        struct node* p=head;
        while(p!=NULL){
            if(p->value==value){
                return p;
            }
            p=p->next;
        }
        return NULL;
    }
};

int main(){
    return 0;
}