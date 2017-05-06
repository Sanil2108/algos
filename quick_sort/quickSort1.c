#include <stdio.h>
#include <stdlib.h>

int* A=NULL;
int n;

int partition(int start, int end, int pivot){
    int* newA=(int *)calloc(n, sizeof(int));
    int k=start;
    int pivotPos;
    int i;

    for(i=0;i<start;i++){
        *(newA+i)=*(A+i);
    }

    for(i=end;i<n;i++){
        *(newA+i)=*(A+i);
    }

    for(i=start;i<end+1;i++){
        if(*(A+i)<pivot){
            *(newA+k)=*(A+i);
            k++;
        }
    }
    pivotPos=k;
    *(newA+k)=pivot;
    k++;

    i=0;
    while(k<end+1){
        if(*(A+i)>pivot){
            *(newA+k)=*(A+i);
            k++;
        }
        i++;
    }
    A=newA;
    return pivotPos;
}

void quickSort(int start, int end){
    int pivot;
    int pivotPos;
    if(end==start){
        return;
    }else{
        pivot=*(A+start);
        pivotPos=partition(start, end, pivot);
        quickSort(start, pivotPos);
        quickSort(pivotPos+1, end);
    }
}

int main(){
    int i;

    scanf("%d", &n);
    A=(int *)calloc(n, sizeof(int));
    for(i=0;i<n;i++){
        scanf("%d", (A+i));
    }
    quickSort(0, n-1);
    // partition(1, 3, *(A+2));
    for(i=0;i<n;i++){
        printf("%d ", *(A+i));
    }
    return 0;
}