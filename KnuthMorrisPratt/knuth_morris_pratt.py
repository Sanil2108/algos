#python2
from random import randrange
from sys import stdout

def brute_force(p, s):
    solution=[]
    for i in range(len(s)-len(p)+1):
        for j in range(len(p)):
            if(p[j]!=s[j+i]):
                break
            else:
                if(j==len(p)-1):
                    solution.append(i)
    return solution
    

def stress_test(min_length_str, max_length_str, min_length_p, max_length_p, min_ascii_in_str, max_ascii_in_str):
    while(True):
        string_len=randrange(min_length_str, max_length_str)
        pattern_len=randrange(min_length_p, max_length_p)
        string=''
        pattern=''
        for i in range(string_len):
            string=string+chr(randrange(min_ascii_in_str, max_ascii_in_str))
            pattern=pattern+chr(randrange(min_ascii_in_str, max_ascii_in_str))

        print(string, pattern)
        if(brute_force(pattern, string)!=KMS(string, pattern)):
            print('FAILED AT '+string+' '+pattern)
            return


def find_prefix_suffix_arr(pattern):
    arr=[0]*len(pattern)
    j=0
    i=1
    while(i<len(pattern)):
        if(pattern[i]==pattern[j]):
            arr[i]=j+1
            j=j+1
        elif j!=0:
            j=arr[j-1]
            continue
        i=i+1
    return arr

def KMS(string, pattern):
    pattern_arr=find_prefix_suffix_arr(pattern)
    i=0
    j=0
    # solutions=[]
    while(i<len(string)):
#         print(j)
        if(string[i]==pattern[j]):
            if(j==len(pattern)-1):
                # solutions.append(i-len(pattern)+1)
                stdout.write(str(i-len(pattern)+1)+' ')
#                 if(j==0):
#                     i+=1
#                 else:
                j=pattern_arr[j-1]
            i+=1
            if(j<len(pattern)-1):
                j+=1
            continue
        else:
            if j!=0:
                j=pattern_arr[j-1]
                continue
            else:
                i+=1
    # return solutions

def solution():
    pattern=raw_input()
    string=raw_input()
    KMS(string, pattern)

solution()