class TicTacToe():
    def __init__(self):
        self.main_arr = [[' ']*3for i in range(3)]
        self.filled = 0

    def fill(self, i, j):
        if(self.main_arr[i][j] == ' '):
            if(self.filled%2==0):
                self.main_arr[i][j] = 'O'
            else:
                self.main_arr[i][j] = 'X'

            self.filled += 1

    @staticmethod
    def same(arr):
        first = arr[0]
        for i in range(len(arr)):
            if(arr[i] != first):
                return -1
        return first

    def won(self):
        for i in range(3):
            if(TicTacToe.same(self.main_arr[i])!=-1 and TicTacToe.same(self.main_arr[i])!=' '):
                return TicTacToe.same(self.main_arr[i])
            if(TicTacToe.same(self.main_arr[:][i])!=-1 and TicTacToe.same(self.main_arr[i])!=' '):
                return TicTacToe.same(self.main_arr[:][i])
            if((TicTacToe.same([self.main_arr[i][i] for i in range(3)])!=-1 or
              TicTacToe.same([self.main_arr[i][2-i] for i in range(3)])!=-1) and
              self.main_arr[1][1] != ' '):
                if(self.main_arr[1][1] != ' '):
                    return self.main_arr[1][1]
        return None

    def __str__(self):
        return str(self.main_arr)
