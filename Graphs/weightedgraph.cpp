#include<iostream>
using namespace std;

class Node;
class Edge;

class Edge{
public:
    int weight;
    Node **nodes;

    Edge();
    Edge(int weight, Node *n1, Node *n2);
    void print();

};

class Node{
public:
    Node(){}
    static const int MAX;
    int value;

    Edge **connectingEdges;
    int edgeIndex;

    Node(int value);

    void addEdge(Edge* e);

    void print();
};
const int Node::MAX=100;

Edge::Edge(){}

Edge::Edge(int weight, Node *n1, Node *n2){
    this->weight=weight;
    nodes=new Node*[2];
    nodes[0]=n1;
    nodes[1]=n2;
}

void Edge::print(){
    cout<<"[E"<<weight<<"[N"<<nodes[0]->value<<","<<nodes[1]->value<<"]]";
}

Node::Node(int value){
    edgeIndex=0;
    connectingEdges=new Edge*[MAX];
    this->value=value;
}

void Node::addEdge(Edge* e){
    connectingEdges[edgeIndex]=e;
    edgeIndex=edgeIndex+1;
    return;
}

void Node::print(){
    cout<<"[N"<<value<<"[ES ";
    for(int i=0;i<edgeIndex;i++){
        connectingEdges[i]->print();
        cout<<", ";
    }
    cout<<"]]";
}

class WeightedGraph{
public:
    const int MAX_EDGES=100;
    const int MAX_NODES=100;

    Edge **edges;
    Node **nodes;

    int nodesIndex;
    int edgeIndex;

    WeightedGraph(){
        edges=new Edge*[MAX_EDGES];
        nodes=new Node*[MAX_NODES];
        nodesIndex=0;
        edgeIndex=0;
    }

    Node *addNode(int value){
        Node *n=new Node(value);
        nodes[nodesIndex++]=n;
        return n;
    }

    Edge* addEdge(int weight, Node *n1, Node *n2){
        Edge *e=new Edge(weight, n1, n2);
        n1->addEdge(e);
        n2->addEdge(e);
        edges[edgeIndex++]=e;
        return e;
    }

    void print(){
        cout<<"[PRINTING]\n";
        for(int i=0;i<nodesIndex;i++){
            nodes[i]->print();
            cout<<"\n";
        }
        cout<<"\n";
    }

};
int main(){
    WeightedGraph graph;
    Node *n1=graph.addNode(1);
    Node *n2=graph.addNode(2);
    Node *n3=graph.addNode(3);
    graph.addEdge(1, n1, n2);
    graph.addEdge(2, n1, n3);
    graph.print();
    return 0;
}