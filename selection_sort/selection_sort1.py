def selection_sort(A):
    for i in range(len(A)):
        #assumption that a[i] is smallest
        min_ = i
        for j in range(i+1, len(A), 1):
            if(A[j]<A[min_]):
                min_=j
        A[i], A[min_] = A[min_], A[i]

    return A

selection_sort([11, 4, 2, 10, 9])