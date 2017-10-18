class UndirectedGraph:
    MIN_VALUE = 3

    def __init__(self):
        self.__init__(self, UndirectedGraph.MIN_VALUE)

    def __init__(self, n):
        self.n = n;

        self.adjacency_matrix = [[0 for i in range(n)] for j in range(n)]
        self.V = []
        self.E = []

    def add_vertice(self, v):
        self.V.append(v)

    def add_edge(self, e):
        self.E.append(e)

    def add_adjacency(self, m, n):
        if (m >= len(self.adjacency_matrix[0]) or n >= len(self.adjacency_matrix[0])):
            for i in range(len(self.adjacency_matrix)):
                for j in range(max(m, n) - len(self.adjacency_matrix) + 1):
                    self.adjacency_matrix[i].append(0)
            for j in range(max(m, n)-len(self.adjacency_matrix)+1):
                self.adjacency_matrix.append([0 for i in range(len(self.adjacency_matrix[0]))])

            self.adjacency_matrix[m][n] = 1
            self.adjacency_matrix[n][m] = 1

        else:
            self.adjacency_matrix[m][n] = 1
            self.adjacency_matrix[n][m] = 1

    def print_adjacency_matrix(self):
        for i in range(len(self.adjacency_matrix)):
            for j in range(len(self.adjacency_matrix)):
                print(self.adjacency_matrix[i][j], end='\t')
            print()

    class Vertice:

        _id = 0

        def __init__(self, n, G):
            self._id = UndirectedGraph.Vertice._id
            UndirectedGraph.Vertice._id += 1
            self.n = n
            self.edges = []
            self.G = G
            G.add_vertice(self)

        def add_edge(self, edge):
            self.edges.append(edge)

    class Edge:

        def __init__(self, v1, v2, G):
            v1.add_edge(self)
            v2.add_edge(self)
            G.add_edge(self)

            G.add_adjacency(v1._id, v2._id)
