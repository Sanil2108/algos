def arrange_list(a, bit_number):
    all_arrays = []
    for i in range(10):
        all_arrays.append([])
    for i in range(len(a)):
        current = (int)((a[i] % (10**(bit_number+1)) - a[i] % (10**(bit_number)))/10**bit_number)
        for j in range(9):
            if(current == j):
                all_arrays[j].append(a[i])
                
                
    final_arr=[]
    
    for i in range(len(all_arrays)):
        for j in range(len(all_arrays[i])):
            if(all_arrays[i][j] != 0):
                final_arr.append(all_arrays[i][j])
            
    return final_arr

def find_max_length(a):
    max_ = 0
    for i in range(len(a)):
        if(len(str(a[i])) > max_):
            max_ = len(str(a[i]))
            
    return max_

def radix_sort(a):
    max_length = find_max_length(a)
    for i in range(max_length):
        a = arrange_list(a, i)
    return a

a=[10, 12, 213, 23, 8, 82]
print(radix_sort(a))