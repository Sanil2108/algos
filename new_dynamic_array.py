class DynamicArray():

    def __init__(self):
        self.base_arr=[]
        self._n=0

    def add(self, newVal):
        self.base_arr.append(newVal)
        self._n += 1

    def get_arr(self):
        return self.base_arr

da = DynamicArray()
da.add(3)
da.add(4)
print(da.get_arr())
