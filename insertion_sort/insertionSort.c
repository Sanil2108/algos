#include <stdio.h>
#include <conio.h>
#define N 10

void traversal(int A[N], int n){
	int i;
	printf("Traversing ...\n");
	for(i=0;i<n;i++){
		printf("%d\t", A[i]);
	}
	printf("\n");
}
void insertionSort(int A[10], int n){
	int i, j, k, pos, currPos, temp;
	for(i=1;i<n;i++){
		pos=i;
		currPos=i;
		temp=A[i];
		for(j=i;j>=0;j--){
			if(A[j]>A[i]){
				pos=j;
			}
		}

		for(k=currPos;k>pos;k--){
			A[k]=A[k-1];
		}
		A[pos]=temp;

	}
	traversal(A, n);
}
void main(){
    int A[10]={5, 2, 2, 11, 5};
    traversal(A, 5);
    insertionSort(A, 5);
    getch();
}