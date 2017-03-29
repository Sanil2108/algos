#include <stdio.h>
struct node{
    struct node * right;
    struct node * left;
    int info;
    int before;
};
void printNode(struct node * current){
    printf("\nLeft - %d\tRight - %d\nValue = %d\nBefore = %d",
        current->left, current->right, current->info, current->before);
}
struct node * createNode(struct node * root, int value){
    struct node * current = (struct node *)malloc(sizeof(struct node));
    current -> info = value;
    current -> before = root->before + 1;
    current -> right = NULL;
    current -> left = NULL;



    //It will first try to insert on the left pos
    //if left != NULL, it will insert on the right pos
    //if both are already filled, it will return NULL because
    //I dont know how to do exception handling in C
    if(root -> left == NULL){
        root->left = current;
        return current;
    }
    if(root -> right == NULL){
        root->right = current;
        return current;
    }
    return NULL;
}
struct node * traverseForStructNodeResult(struct node * root, struct node * target, struct node * current){
    int i=0;
    if(root == target){
        current = root;
        return current;
    }
    if(root->left != NULL){
        current = traverseForStructNodeResult(root -> left, target, current);
    }
    if(root->right != NULL){
        current = traverseForStructNodeResult(root -> right, target, current);
    }
    return current;
}
struct node * traverseForResult(struct node * root, int target, struct node * current){
    int i=0;
    if(root->info == target){
        current = root;
        return current;
    }
    if(root->left != NULL){
        current = traverseForResult(root -> left, target, current);
    }
    if(root->right != NULL){
        current = traverseForResult(root -> right, target, current);
    }
    return current;
}
void delete(struct node * root, struct node * toDelete){
    int i=0;
    struct node * before=root;
    struct node * after=traverseForStructNodeResult(root, toDelete, NULL); 
    // for(i=0;i<=toDelete->before;i++){
    //     traverseForResult
    // }
    printf("%d", after->info);
}
void traverse(struct node * root){
    int i=0;
    printf("\n");
    for(i=0;i<root->before;i++){
        printf("---");
    }
    printf("%d", root->info);
    if(root->left != NULL){
        traverse(root -> left);
    }
    if(root->right != NULL){
        traverse(root -> right);
    }
}
void insert(struct noe * root, int target){
    struct node * temp = createNode(root, target);
}
void main(){
    struct node * root = (struct node *)malloc(sizeof(struct node));
    root -> info = 1;
    root -> before = 0;
    root -> left = NULL;
    root -> right = NULL;

    struct node * root1 = createNode(root, 2);
    struct node * root2 = createNode(root, 3);
    struct node * root21 = createNode(root2, 4);
    struct node * root22 = createNode(root2, 5);
    
    // createNode(createNode(root1, 5), 6);
    // createNode(createNode(root1, 5), 7);
    // createNode(root1, 4);

    // delete(root, root1);
    // printf("%d", traverseForStructNodeResult(root, root21, NULL)->before);

    traverse(root);

    // printNode(root);
    // printNode(root2);
    // printNode(root1);
    // printNode(root21);
    // printNode(root22);
    
}