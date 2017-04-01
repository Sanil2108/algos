def partition(A, start, end):
    # boundary between elements less than and greater than pivot
    i = start + 1

    # boundary between partitioned and unpartitioned array
    j = start + 1

    while (j < len(A)):
        if (A[j] < A[start]):
            A[j], A[i] = A[i], A[j]
            i += 1
        j += 1

    A[start], A[i - 1] = A[i - 1], A[start]

    return A, i - 1

def quick_sort2(A, start, end):
    if(start>=end):
        if(start<len(A) and start>=0):
            return [A[start]]
    else:
        A, partition_index = partition(A, start, end)
        quick_sort2(A, start, partition_index-1)
        quick_sort2(A, partition_index+1, end)

        return A

def quick_sort(A):
    return quick_sort2(A, 0, len(A)-1)

# A=[8, 10, 7, 1, 12, 3, 2, 23, 40, 21, 14, 52, 47]
# print(quick_sort(A))