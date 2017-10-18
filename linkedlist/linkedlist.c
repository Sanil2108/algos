#include <stdio.h>

struct node {
        int element;
        struct node *next;
};

struct node * start=NULL;

void traverse(){
    struct node * p=start;
    while(p->next != NULL){
        printf("%d\t", p->element);
        p=p->next;
    }
    printf("%d\n\n", p->element);
}

void insertFront(int element){
    struct node *p=(struct node *)malloc(sizeof(struct node));
    p->element=element;
    p->next=start;
    start = p;
}

void insertBack(int value){
    struct node * ptr=start;
    struct node * new=(struct node *)malloc(sizeof(struct node));
    new->element = value;
    new->next=NULL;
    if(start != NULL){
        while(ptr->next != NULL){
            ptr=ptr->next;
        }
        ptr->next=new;
    }else{
        start = new;
    }
}

void delete (int target){
    struct node* p=start->next;
    struct node* temp=start;
    while(p != NULL){
        if(p->element == target){
            temp->next=p->next;
            return;
        }
        temp=temp->next;
        p=p->next;
    }
}

void deleteBack(){
    struct node * temp=start;
    while(temp->next->next != NULL){
        temp=temp->next;
    }
    temp->next = NULL;
}

void deleteFront(){
    start=start->next;
}

struct node* linearSearch(int target){
    struct node * p=start;
    int n=0;
    while(p->next!=NULL){
        if(p->element==target){
            printf("Found at position %d", n);
            return p;
        }
        p=p->next;
        n++;
    }
}
    
void main(){
    int i, temp;
    struct node * p;
    // delete(0);
    for(i=0;i<5;i++){
        // scanf("%d", &temp);
        // start=insertFront(start, temp);
        // start=insertFront(start, i);
        // insertFront(i);
        insertBack(i);
    }
    traverse();
    deleteBack();
    // traverse(start);
    // deleteFront();
    // insertBack(-1);
    // delete(3);
    // linearSearch(start, 2);
    traverse();
}