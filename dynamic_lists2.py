#python's memory class occasionally shrinks
#the list size as well
import sys
arr = [0] * 40
for i in range(30):
    arr.pop()
    print('Length : {0:4d} Size : {1:4d}'.format(len(arr), sys.getsizeof(arr)))
