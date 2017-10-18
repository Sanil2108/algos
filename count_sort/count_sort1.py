def count_sort1(A):
    max_=A[0]
    for i in range(len(A)):
        if(max_<A[i]):
            max_=A[i]
            
    C = [0]*(max_+1)
    for i in range(len(A)):
        C[A[i]]+=1
    
    Ai = 0
    for i in range(len(C)):
        if(C[i]!=0):
            A[Ai]=i
            Ai+=1
            
    return A

print(count_sort1([1, 2, 10, 8, 7]))