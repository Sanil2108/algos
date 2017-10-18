#include <stdio.h>

struct node {
        int element;
        struct node *next;
};

struct node * header=NULL;
struct node * start=NULL;

void traverse(){
    struct node * p=start;
    do{
        printf("%d\t", p->element);
        p=p->next;
    }while(p != start);
    printf("\n\n");
}

void insertFront(int element){
    struct node *p=(struct node *)malloc(sizeof(struct node));
    p->element=element;
    p->next=start;
    start = p;
    while(p != start){
        p=p->next;
    }
    p->next=start;
    // p->next = start
}

void insertBack(int value){
    struct node * ptr=header;
    struct node * new=(struct node *)malloc(sizeof(struct node));
    new->element = value;
    new->next=NULL;
    if(header != NULL){
        while(ptr->next != header){
            ptr=ptr->next;
        }
        ptr->next=new;
    }else{
        header = new;
    }
    new->next=header;
}

void delete (int target){
    struct node* p=start->next;
    struct node* temp=start;
    while(p != start){
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
    while(temp->next->next != start){
        temp=temp->next;
    }
    temp->next = start;
}

void deleteFront(){
    start=start->next;
}

struct node* linearSearch(int target){
    struct node * p=start;
    int n=0;
    while(p->next!=start){
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
    header->next = NULL;
    header->element=0;
    start->next = header;
    for(i=0;i<5;i++){
        // scanf("%d", &temp);
        // insertFront(i);
        insertBack(i);
    }
    traverse();
    // deleteBack();
    // deleteFront();
    // insertBack(-1);
    // delete(3);
    // linearSearch(2);
    // traverse();
}