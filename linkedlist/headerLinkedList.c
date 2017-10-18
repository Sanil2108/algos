#include <stdio.h>

struct node {
        int element;
        struct node *next;
};

struct node * start;
struct node * header;

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
    header->element++;
    p->element=element;
    p->next=header->next;
    header->next = p;
}

void insertBack(int value){
    struct node * ptr=start;
    struct node * new=(struct node *)malloc(sizeof(struct node));
    header->element++;
    new->element = value;
    new->next=NULL;
    if(header->next != NULL){
        while(ptr->next != NULL){
            ptr=ptr->next;
        }
        ptr->next=new;
    }else{
        header->next = new;
    }
    ptr->next=new;
}

void delete (int target){
    struct node* p=header->next;
    struct node* temp=header;
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
    struct node * temp=header;
    while(temp->next->next != NULL){
        temp=temp->next;
    }
    temp->next = NULL;
}

void deleteFront(){
    header->next=header->next->next;
}

struct node* linearSearch(int target){
    struct node * p=header->next;
    int n=0;
    while(p!=NULL){
        if(p->element==target){
            printf("Found at position %d\n\n", n);
            return p;
        }
        p=p->next;
        n++;
    }
}
    
void main(){
    int i, temp;
    struct node * p;
    start = (struct node *)malloc(sizeof(struct node));
    header = (struct node *)malloc(sizeof(struct node));
    start=header;
    header->element = 0;
    header->next=NULL;
    for(i=1;i<=5;i++){
        insertFront(i);
    }
    traverse();
    // deleteFront();
    deleteBack();
    // insertFront(-1);
    // deleteFront();
    linearSearch(2);
    traverse();
}