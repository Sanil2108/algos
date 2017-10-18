#include <iostream>
#include <string>

using namespace std;

struct element{
    char c;
    int pos;
};

class Stack{
public:
    int top;
    int m_size;
    element *A;

    Stack(int size){
        m_size=size;
        A=new element[size];
        top=-1;
    }

    int topIndex(){
        return top;
    }

    bool empty(){
        return top==-1;
    }

    void print(){
        for(int i=0;i<=top;i++){
            cout<<A[i].c<<"\t";
        }
        cout<<"\n";
    }

    void push(struct element e){
        if(top==m_size-1){
            return;
        }
        A[++top]=e;
    }

    struct element pop(){
        struct element e;
        e.c=NULL;
        e.pos=-1;
        if(top==-1){
            return e;
        }
        A[top]=e;
        struct element item=A[top];
        top--;
        return item;
    }

    struct element getTop(){
        return A[top];
    }
};

int bracketsMatch(string s){
    Stack stack(s.length());
    for(int i=0;i<s.length();i++){
        struct element newElement;
        newElement.pos=i;
        newElement.c=s[i];
        switch(s[i]){
            case '(':
            case '[':
            case '{':
                stack.push(newElement);
                break;
            case ')':
                if(stack.getTop().c!='('){
                    return i;
                }else{
                    stack.pop();
                }
                break;
            case '}':
                if(stack.getTop().c!='{'){
//                    return stack.getTop().pos;
                    return i;
                }else{
                    stack.pop();
                }
                break;
            case ']':
                if(stack.getTop().c!='['){
                    return i;
                }else{
                    stack.pop();
                }
        }
    }
    if(stack.empty()){
        return -2;
    }else{
        return stack.getTop().pos;
    }
}

int main(){
    string s;
    cin>>s;
    int temp=bracketsMatch(s);
    if(temp==-2){
        cout<<"Success";
    }else{
        cout<<temp+1;
    }
    cout<<"\n";
    return 0;
}