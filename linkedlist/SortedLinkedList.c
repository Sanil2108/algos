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

void insert(int value){
    struct node * ptr=start;
    struct node * new=(struct node *)malloc(sizeof(struct node));
    new->element = value;
    new->next=NULL;
    if(start != NULL){
        if(ptr->element >= value){
            new->element=value;
            new->next=start;
            start = new;
            return;
        }
        while(ptr->next != NULL && ptr->element <= value){
            ptr=ptr->next;
        }
        new->next=ptr->next;
        ptr->next=new;
    }else{
        start = new;
    }
}


void delete (int target){
    struct node* p=start->next;
    struct node* temp=start;
    while(p != NULL && p->element<=target){
        if(p->element == target){
            temp->next=p->next;
            return;
        }
        temp=temp->next;
        p=p->next;
    }
}

struct node* linearSearch(int target){
    struct node * p=start;
    int n=0;
    while(p->next!=NULL && p->element<=target){
        if(p->element==target){
            printf("Found at position %d, iterated %d times\n", n);
            return p;
        }
        printf("iterated %d times\n", n+1);
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
        // printf("Inserted");
        // insertBack(start, i);
        insert(10-i);
    }
    insert(6);
    insert(1);
    traverse();
    // deleteBack();
    // traverse(start);
    // deleteFront();
    // insertBack(-1);
    delete(6);
    // linearSearch(3);
    traverse();
}