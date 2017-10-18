class DisjointSets{

    //parent of i is stored in parent[i]
    int[] parent;
    //rank[i] is the height of the subtree rooted at i
    int[] rank;

    DisjointSets(int size){
        parent=new int[size];
        rank=new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public void union(int a, int b){
        int iId = find(a);
        int jId = find(b);
        if(iId==jId){
            return;
        }
        if(iId>jId){
            parent[jId]=iId;
        }else{
            parent[iId]=jId;
            if(rank[iId] == rank[jId]){
                rank[jId]++;
            }
        }
    }

    public int find(int element){
        while(element!=parent[element]){
            element=parent[element];
        }
        return element;
    }

    public void print(){
        for(int i=0;i<parent.length;i++){
            System.out.print(parent[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args){
        DisjointSets set=new DisjointSets(16);
        set.union(1,2);
        set.union(2,3);
        set.union(4,5);
        set.union(5,6);
        set.union(5,2);
        set.print();
    }
}