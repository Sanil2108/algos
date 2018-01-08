import java.util.*;
import javax.swing.text.EditorKit;
class Solution{
    class Node{
        private final static int MAX=100;
        int value;
        Edge[] connectingEdges;
        int edgeIndex;

        public Node(){}

        public Node(int value){
            edgeIndex=0;
            connectingEdges=new Edge[MAX];
            this.value=value;
        }

        public void addEdge(Edge e){
            connectingEdges[edgeIndex]=e;
            edgeIndex++;
            return;
        }

        public void print(){
            System.out.print("[N"+value+"[ES ");
            for(int i=0;i<edgeIndex;i++){
                connectingEdges[i].print();
                System.out.print(", "_;
            }
            System.out.print("]]");
        }

    }

    static class Edge{
        public int weight;
        public Node[] nodes;

        public Edge(){

        }

        public Edge(int weight, Node n1, Node n2){
            this.weight=weight;
            nodes=new Node[2];
            nodes[0]=n1;
            nodes[1]=n2;
        }

        public void print(){
            System.out.println("[E"+weight+"[N"+nodes[0].value+","+nodes[1].value+"]]");
        }

    }

    class WeightedGraph{
        private static final int MAX_EDGES=100;
        private static final int MAX_NODES=100;

        Edge[] edges;
        Node[] nodes;

        int nodesIndex;
        int edgeIndex;

        public WeightedGraph(){
            edges=new Edge[MAX_EDGES];
            nodes=new Node[MAX_NODES];
            nodesIndex=0;
            edgeIndex=0;
        }


        public Node addNode(int value){
            Node n=new Node(value);
            nodes[nodesIndex++]=n;
        }

        public Edge addEdge(int weight, Node n1, Node n2){
            Edge e=new Edge(weight, n1, n2);
            n1.addEdge(e);
            n2.addEdge(e);
            edges[edgeIndex++]=e;
            return e;
        }

        public void print(){
            System.out.println("[PRINTING]");
            for(int i=0;i<nodesIndex;i++){
                nodes[i].print();
                System.out.println();
            }
            System.out.println();
        }

    }

    static class DisjointSet{
        public int rank[];
        public int parents[];
        public int elements[];
        public int size;

        public DisjointSet(int size){
            this.size=size;
            rank=new int[size];
            elements=new int[size];
            parents=new int[size];
            for(int i=0;i<size;i++){
                makeSet(i);
            }
        }

        public void makeSet(int i){
            parents[i]=i;
            rank[i]=0;
        }

        public int find(int element){
            while(element!=parents[element]){
                element=parents[element];
            }
            return element;
        }
        
        public void union(int element1, int element2){
            int parent1=find(element1);
            int parent2=find(element2);
            if(parent1==parent2){
                return;
            }
            if(rank[parent1]>rank[parent2]){
                parents[parent2]=parent1;
            }else{
                parents[parent1]=parent2;
                if(rank[parent1]==rank[parent2]){
                    rank[parent2]++;
                }
            }
        }
        
        public void print(){
            for(int i=0;i<size;i++){
                System.out.print(i+"\t");
            }
            System.out.println();
            for(int i=0;i<size;i++){
                System.out.print(parents[i]+"\t");
            }
            System.out.println();
            for(int i=0;i<size;i++){
                System.out.print(rank[i]+"\t");
            }
        }
    }

    public static Edge[] sort(Edge[] unsorted, int n, int k){
        Edge[][] matrix=new Edge[n][n+k];
        int index[]=new int[n];
        for(int i=0;i<n;i++){
            matrix[unsorted[i].weight][index[i]++]=unsorted[i];
        }
        Edge[] newArr=new Edge[n];
        int newArrk=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n+k;j++){
                if(matrix[i][j]!=null){
                    newArr[newArrk]=matrix[i][j];
                    newArrk++;
                    matrix[i][j]=null;
                    continue;
                }
                break;
            }
        }
    }

    public static void kruskals(){
        WeightedGraph graph;
        Node n1=graph.addNode(1);
        Node n2=graph.addNode(2);
        Node n3=graph.addNode(3);
        Node n4=graph.addNode(4);
        int nedges=4;
        Edge edges[]=new Edge[nedges];
        edges[0]=graph.addEdge(5, n1, n2);
        edges[1]=graph.addEdge(2, n2, n3);
        edges[2]=graph.addEdge(7, n3, n4);
        edges[3]=graph.addEdge(5, n4, n1);
        Edge sortedEdges[]=sort(edges, nedges, 7);
        DisjointSet set=new DisjointSet(edges.length);
        for(int i=0;i<nedges;i++){
            
        }
    }

    public static void main(String[] args){

    }
}