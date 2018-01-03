class UndirectedGraph{
    int[][] adjacencyMatrix;
    int numberOfNodes;
    public Node root;

    static final int MIN_NODES=1;

    static class Node{
        private static int id=0;
        public int m_id;
        public int element;

        private Node[] children;
        public int n_children=0;
        private static final int MIN_CHILDREN_SIZE=10;

        public Node(int element){
            this.element = element;
            m_id=id++;
            children=new Node[MIN_CHILDREN_SIZE];
        }

        public void addChild(Node n){
            if(n_children>=children.length){
                Node[] newChildren=new Node[n_children+MIN_CHILDREN_SIZE];
                for(int i=0;i<children.length;i++){
                    newChildren[i]=children[i];
                }
                this.addChild(n);
            }else{
                children[n_children]=n;
                n_children++;
            }
        }

        public Node[] getChildren(){
            return children;
        }

        @Override
        public String toString(){
            return "[Node-"+m_id+"-"+element+"]";
        }
    }

    public UndirectedGraph(int rootElement){
        root=new Node(rootElement);
        adjacencyMatrix = new int[MIN_NODES][MIN_NODES];
        numberOfNodes=1;
    }

    public Node addNode(int value){
        if(numberOfNodes+1<MIN_NODES){
            Node node=new Node(value);
            numberOfNodes++;
            return node;
        }else{
            Node node=new Node(value);
            numberOfNodes++;


            //very expensive
            int[][] newAdjacencyMatrix=new int[numberOfNodes][numberOfNodes];
            for(int i=0;i<numberOfNodes-1;i++){
                for(int j=0;j<numberOfNodes-1;j++){
                    newAdjacencyMatrix[i][j]=adjacencyMatrix[i][j];
                }
            }
            adjacencyMatrix=newAdjacencyMatrix;


            return node;
        }
    }

    public void addEdge(Node to, Node from){
        adjacencyMatrix[to.m_id][from.m_id]++;
        adjacencyMatrix[from.m_id][to.m_id]++;
        to.addChild(from);
        from.addChild(to);
    }

    public void printAdjacencyMatrix(){
        for(int i=0;i<numberOfNodes;i++){
            for(int j=0;j<numberOfNodes;j++){
                System.out.print(adjacencyMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean isEdge(Node to, Node from){
        return adjacencyMatrix[to.id][from.id]==1;
    }

    public void BFS(){
        boolean[] visited=new boolean[numberOfNodes];
        Queue q=new Queue();
        q.enqueue(root);
        visited[root.m_id]=true;
        while(!q.isEmpty()){
            Node tempNode=q.dequeue();
            System.out.print(tempNode+"\t");
            Node[] temp=tempNode.children;
            if(temp!=null) {
                for (int i=0;i<tempNode.n_children;i++) {
                    if (!visited[temp[i].m_id]) {
                        q.enqueue(temp[i]);
                        visited[temp[i].m_id] = true;
                    }
                }
            }
        }


    }

    public static void main(String[] args){
        UndirectedGraph graph=new UndirectedGraph(0);
        Node[] nodes=new Node[8];
        nodes[0]=graph.root;
        for(int i=1;i<nodes.length;i++){
            nodes[i]=graph.addNode(i);
        }
        graph.addEdge(nodes[0], nodes[1]);
        graph.addEdge(nodes[0], nodes[2]);
        graph.addEdge(nodes[0], nodes[3]);
        graph.addEdge(nodes[1], nodes[4]);
        graph.addEdge(nodes[1], nodes[5]);
        graph.addEdge(nodes[2], nodes[6]);
        graph.addEdge(nodes[2], nodes[7]);
        graph.addEdge(nodes[3], nodes[7]);
        graph.printAdjacencyMatrix();

        System.out.println();
        System.out.println();

        graph.BFS();
        System.out.println();
    }
}

class Queue{
    private static final int MIN_ELEMENTS=10;
    public int n=0;
    public int F=0, R=0;
    public UndirectedGraph.Node[] elements;
    Queue(){
        elements=new UndirectedGraph.Node[MIN_ELEMENTS];
    }

    public UndirectedGraph.Node dequeue(){
        if(F==R){
            F++;
            return null;
        }
        UndirectedGraph.Node temp=elements[F];
        elements[F]=null;
        F++;
        return temp;
    }

    public void traverse(){
        for(int i=F;i<R;i++){
            System.out.print(elements[i]+"\t");
        }
    }

    public boolean isEmpty(){
        return F>=R;
    }

    public void enqueue(UndirectedGraph.Node newElement){
        if(R<elements.length){
            elements[R]=newElement;
            R++;
        }else{
            UndirectedGraph.Node[] newElements=new UndirectedGraph.Node[R+MIN_ELEMENTS];
            for(int i=0;i<elements.length;i++){
                newElements[i]=elements[i];
            }
            elements=newElements;
            enqueue(newElement);
        }
    }
}