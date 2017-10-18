import quick_sort1
from random import randrange
from importlib.machinery import SourceFileLoader
from quick_sort1 import quick_sort
merge_sort = SourceFileLoader("mergeSort", "C:/Users/Admin/Desktop/code/research/asymptotic and memory analysis of various sorting algorithms/merge_sort/merge_sort1.py").load_module()


SIZE_RANGE = (10, 1000)
NUMBER_RANGE = (1, 10000)

#stress test against mergesort
def stress_test1(t, f):
	size = randrange(SIZE_RANGE[1]-SIZE_RANGE[0])+SIZE_RANGE[0]
	A = [0] * size
	for i in range(len(A)):
		A[i] = randrange(NUMBER_RANGE[1]-NUMBER_RANGE[0])+NUMBER_RANGE[0]
	# print(A)
	# print(merge_sort.merge_sort(A))

	if(merge_sort.merge_sort(A) != quick_sort(A)):
		print('SOMETHING WENT WRONG')
		logs=open('logs.txt', 'a+')
		logs.write(''.join(['\n\nSIZE : ', str(size), '\nARRAY : ', str(A)]))
		logs.close()
		f+=1
	else:
		print('SIZE : \t', size, 'SUCCESFUL !!', end='')
	t+=1

	return t, f


t=0
f=0
while(True):
	t, f=stress_test1(t, f)
	print('\tTOTAL\t', t, '\tFAILURES\t', f)
