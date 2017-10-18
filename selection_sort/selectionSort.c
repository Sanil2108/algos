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
void selectionSort(int A[10], int n){
	int i, j, smallest, temp;
	for(i=0;i<n;i++){
		smallest=i;
		for(j=i;j<n;j++){
			if(A[j]<A[smallest]){
				smallest=j;
			}
		}
		temp=A[i];
		A[i]=A[smallest];
		A[smallest]=temp;
	}
	traversal(A, n);
}
void main(){
    int A[10]={101, 13, 12, 72, 50};
    traversal(A, 5);
    selectionSort(A, 5);
    getch();
}