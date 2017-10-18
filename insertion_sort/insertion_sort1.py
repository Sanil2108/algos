def insertion_sort(A):
    for i in range(1, len(A)):
        pos = i
        for j in range(i, -1, -1):
            if(A[j]>A[i]):
                pos=j
        temp=A[i]
        for k in range(i, pos, -1):
            A[k]=A[k-1]
        A[pos]=temp
    return A


print(insertion_sort([1, 2, 10, 8, 9, 12, 11, 10, 28, 7]))