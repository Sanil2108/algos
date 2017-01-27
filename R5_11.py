arr1 = [[i+j for i in range(10)] for j in range(20)]

sum=0
for i in range(10):
    for j in range(20):
        sum+=arr1[j][i]

print(sum)
