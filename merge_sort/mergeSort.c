#include <stdio.h>
#include <conio.h>
void mergesort(int a[],int low,int high);
void merge(int a[],int lowL,int highL,int lowR,int highR);
int main()
{   
    int a[30]={1, 7, 4, 3},n,low;
    n=4;
    printf("Traversing ...\n");
    for(low=0;low<n;low++){
        printf("%d\t",a[low]);
    }
    mergesort(a,0,n-1);
    printf("\n\nTraversing ...\n");
    for(low=0;low<n;low++){
        printf("%d\t",a[low]);
    }
    getch();

}

void mergesort(int a[],int low,int high)
{
    int mid,i;
    if(low<high){
        mid=(low+high)/2;
        mergesort(a,low,mid);
        mergesort(a,mid+1,high);
        merge(a,low,mid,mid+1,high);
    }
}

void merge(int a[],int lowL,int highL,int lowR,int highR)
{
    int temp[50];
    int i,j,k;
    
    i=lowL;
    j=lowR;
    k=0;
        
    while(i<=highL && j<=highR){
        if(a[i]<a[j]){
            temp[k++]=a[i++];
        }else{
            temp[k++]=a[j++];
        }
    }
        
    while(i<=highL){
        temp[k++]=a[i++];
    }
        
    while(j<=highR){
        temp[k++]=a[j++];
    }
        
    for(i=lowL,j=0;i<=highR;i++,j++){
        a[i]=temp[j];
    }

}