def sort(A, B):
    i=0
    j=0
    k=0
    C=[0]*(len(A)+len(B))
    while(i<len(A) and j<len(B)):
        if(A[i]>B[j]):
            C[k]=B[j]
            j+=1
        else:
            C[k]=A[i]
            i+=1
        k+=1
    
    while(i<len(A)):
        C[k]=A[i]
        i+=1
        k+=1
        
    while(j<len(B)):
        C[k]=B[j]
        j+=1
        k+=1
    
    return C

def merge_sort2(A, start, end):
    mid = (start+end)//2
    if(end-start == 1):
        return [A[start]]
    else:
        return sort(merge_sort2(A, start, mid), merge_sort2(A, mid, end))

def merge_sort(A):
    return merge_sort2(A, 0, len(A))

# A=[1, 3, 2, 7, 5]
# print(merge_sort(A))