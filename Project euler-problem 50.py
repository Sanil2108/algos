import math


def find_most_consecutive_sum(max_number):
    arr = get_array_of_prime(int(max_number/4))
    for i in range(len(arr) - 1, 1, -1):
        sum_of_i_digits = 0
        for j in range(i+1):
            sum_of_i_digits += arr[j]
        if sum_of_i_digits > max_number:
            break
        for k in range(0, len(arr)-i, 1):
            if sum_of_i_digits>max_number:
                break
            if is_prime(sum_of_i_digits):
                print(sum_of_i_digits)
                return i+1
            if k+i+1<len(arr):
                sum_of_i_digits -= arr[k]
                sum_of_i_digits += arr[k + i + 1]


def is_prime(n):
    if n==1:
        return  False
    else:
        for i in range(2, int(math.sqrt(n))+1, 1):
            if n%i==0:
                return False
        return True

def get_array_of_prime(n):
    arr=[]
    for i in range(2, n, 1):
        if is_prime(i):
            arr.append(i)
    return arr

print(find_most_consecutive_sum(1000000))