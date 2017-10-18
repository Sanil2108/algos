#include <stdio.h>

struct node {
        struct node * previous;
        int element;
        struct node *next;
};

struct node * start=NULL;

void traverse(){
    struct node * p=start;
    printf("\n\nCurrent\tPrevious\tNext\n");
    while(p != NULL){
        if(p->previous != NULL && p->next != NULL){
            printf("%d\t%d\t\t%d\n", p->element, p->previous->element, p->next->element);
        }else if(p->previous == NULL){
            printf("%d\tNULL\t\t%d\n", p->element, p->next->element);
        }else{
            printf("%d\t%d\t\tNULL\n", p->element, p->previous->element);
        }
        p=p->next;
    }
}

void insertFront(int element){
    struct node *p=(struct node *)malloc(sizeof(struct node));
    p->element=element;
    p->next=start;
    start = p;
    if(p->next != NULL){
        start->next->previous = p;
    }
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
        new->previous=ptr;
    }else{
        start = new;
        new->previous=NULL;
    }
}

void delete (int target){
    struct node* p=start->next;
    struct node* temp=start;
    while(p != NULL){
        if(p->element == target){
            p->next->previous = p->previous;
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
    start->next->previous=NULL;
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
    // struct node * p;
    for(i=0;i<5;i++){
        // scanf("%d", &temp);
        // start=insertFront(start, temp);
        // start=insertFront(start, i);
        insertBack(i);
        // insertFront(i);
    }
    traverse();
    deleteBack();
    traverse(start);
    // deleteFront();
    // insertBack(-1);
    // delete(3);
    // linearSearch(2);
    traverse();
}