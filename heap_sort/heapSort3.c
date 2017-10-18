#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int * contents;
int currentIndex=0;
int size=0;                                                 //Size of contents

void insert(int value){
    //Declarations
    int tempIndex;
    int temp;                                               //for swapping

    //Code
    size++;
    if(currentIndex>0){
        *(contents+currentIndex)=value;
        tempIndex = currentIndex;
        while(*(contents+tempIndex) > *(contents+tempIndex/2)){
            temp = *(contents+tempIndex);
            *(contents+tempIndex) = *(contents+tempIndex/2);
            *(contents+tempIndex/2) = temp;
            tempIndex = tempIndex/2;
        }
        currentIndex++;
    }else{
        *(contents+currentIndex++) = value;
    }
}

void traverseByLevel(){
    //Declarations
    int i=0, j;
    int level;

    //Code
    for(i=0;i<size;i++){
        level=(int)(log(i+1)/log(2));
        for(j=0;j<level;j++){
            printf("--");
        }
        printf("%d\n", *(contents+i));
    }
}

void swap(int i, int j){
    int temp = *(contents+i);
    *(contents+i)=*(contents+j);
    *(contents+j)=temp;
}

int* getChildren(int i){
    //Declarations
    int *p;
    int children[2];

    //To ensure by the calling function the number of children
    children[1]=0;

    //Code
    i=i+1;
    if(i==1){
        if(currentIndex==2){
            children[0]=*(contents+1);
        }else{
            children[0]=*(contents+1);
            children[1]=*(contents+2);
        }
    }else{
        if(currentIndex==2*i){
            children[0]=*(contents+(2*i-1));
        }else{
            children[0]=*(contents+(2*i-1));
            children[1]=*(contents+(2*i));
        }
    }
    p=children;
    
    return p;
}


int* getChildrenIndex(int i){
    //Declarations
    int *p;
    int children[2];

    //To ensure by the calling function the number of children
    children[1]=0;

    //Code
    i=i+1;
    if(i==1){
        if(currentIndex==2){
            children[0]=1;
        }else{
            children[0]=1;
            children[1]=2;
        }
    }else{
        if(currentIndex==2*i){
            children[0]=2*i-1;
        }else{
            children[0]=2*i-1;
            children[1]=2*i;
        }
    }
    p=children;

    return p;
}

void arrange(int index){
    //Declarations
    int * children;
    int arranged = 1;                                   //Supposed to work as a boolean
    int i;
    int childrenLength=0;
    int max_child=0;

    //Code
    if((index==0 && currentIndex>1) || 
    (currentIndex > 2*index + 1)){
        children=getChildrenIndex(index);
        if(*children != 0){
            childrenLength++;
        }
        if(*(children+1) != 0){
            childrenLength++;
        }

        for(i=0;i<childrenLength;i++){
            if(*(contents+(*(children+i))) > *(contents+index)){
                arranged=0;
            }
        }

        if(arranged != 1){
            for(i=0;i<childrenLength;i++){
                if(*(contents+(*(children+i))) > *(contents+index)){
                    if(*(contents+(*(children+i))) > *( contents+(*(children+max_child)) )){
                        max_child=i;
                    }
                }
            }
            swap(*(children+max_child), index);
            arrange(*(children+max_child));
            return;
        }
    }
}

int* sort(int* p){
    //Declarations
    // int * p;


    //Code
    // p=A;
    if(currentIndex == 0){
        return p;
    }
    swap(0, currentIndex-1);
    *(p+currentIndex-1) = *(contents+(currentIndex-1));
    currentIndex--;
    arrange(0);
    sort(p);
    return p;
}

void main(){
    int *p = calloc(11, 4);
    int i;
    contents=calloc(11, 4);
    insert(1);
    insert(2);
    insert(3);
    insert(8);
    insert(4);
    insert(4);
    insert(10);
    insert(9);
    insert(6);
    insert(12);
    insert(13);
    p=sort(p);
    i=0;
    while( *(p+i) != NULL){
        printf("%d\t", *(p+i));
        i+=1;
    }
}