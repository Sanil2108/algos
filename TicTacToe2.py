class TicTacToe():

    def __init__(self):
        self._board=[[' '] * 3 for i in range(3)]
        self._player='X'

    def mark(self, i, j):
        if not(0<=i<=2 and 0<=j<=2):
            raise ValueError('Invalid board position')
        if self._board[i][j] != ' ':
            raise ValueError('Position Occupied')
        if self.winner() is not None:
            raise ValueError('Game already ended')
        self._board[i][j]=self._player
        if self._player == 'X':
            self._player = 'O'
        else:
            self._player = 'X'


    def _is_win(self, mark):
        board=self._board
        return (mark == board[0][0] == board[0][1] == board[0][2] or
            mark == board[1][0] == board[1][1] == board[1][2] or
            mark == board[2][0] == board[2][1] == board[2][2] or
            mark == board[0][0] == board[1][0] == board[2][0] or
            mark == board[0][1] == board[1][1] == board[2][1] or
            mark == board[0][2] == board[1][2] == board[2][2] or
            mark == board[0][0] == board[1][1] == board[2][2] or
            mark == board[0][2] == board[1][1] == board[2][0])

    def winner(self):
        for mark in 'XO':
            if self._is_win(mark):
                return mark
        return None

    def __str__(self):
        rows = ['|'.join(self._board[r]) for r in range(3)]
        return '\n-----\n'.join(rows)


ttt = TicTacToe()
ttt.mark(0, 0)
ttt.mark(1, 0)
ttt.mark(1, 2)
ttt.mark(1, 1)
ttt.mark(2, 2)
ttt.mark(0, 1)
ttt.mark(0, 2)
print(str(ttt))
