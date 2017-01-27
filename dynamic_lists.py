#testing how dynamic python's list class is
import sys
arr=[0]*10
for i in range(30):
    if(i>len(arr)):
        arr.append(0)
    print(len(arr), '\t', sys.getsizeof(arr))
