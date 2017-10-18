import java.util.*;

class TreeHeight{
    static class Node{
        int level;
        int value;
        ArrayList<Node> nodes;

        public Node(int value){
            nodes=new ArrayList<Node>();
            this.value=value;
        }

        public void addChild(Node n){
            nodes.add(n);
        }
    }
    static class BinaryTree{
        Node[] A;
        int rootIndex;
        int maxLevel=0;

        BinaryTree(int number){
            rootIndex=-1;
            A=new Node[number];
            for(int i=0;i<number;i++){
                A[i]=new Node(i);
            }
        }

        //ith node will be the child of jth node
        void insert(int i, int j){
            if(j==-1){
                rootIndex=i;
                A[i].level=1;
                return;
            }
            A[j].addChild(A[i]);
        }

        Node getRoot(){
            return A[rootIndex];
        }

        void traverse_dfs_nlr(Node root){
            System.out.print(root.value+"\t");
            for(Node i:root.nodes){
                traverse_dfs_nlr(i);
            }
        }

        int maxLevel2=0;
        void setLevel(){
            for(int i=0;i<A.length;i++){
                if(i==rootIndex){
                    continue;
                }

            }
        }

        int max(int a, int b){return (a>b)?a:b;}

        int getMaxHeight(Node root){
            int maxHeight=0;
            for(Node n:root.nodes){
                int height=getMaxHeight(n);
                if(height>maxHeight){
                    maxHeight=height;
                }
            }
            return 1+maxHeight;
        }

        int getMaxHeightNonRecursively(){
            int maxHeight=0;

            ArrayList<Node> s=new ArrayList<>();
            ArrayList<Integer> n=new ArrayList<>();

            s.add(A[rootIndex]);
            n.add(-1);
//            int currentHeight=1;
            while(!s.isEmpty()){
//                if(s.size()==1 && s.get(0).nodes.size()==n.get(0)+1){
//                    break;
//                }
                if(s.get(s.size()-1).nodes.isEmpty()){
//                    currentHeight--;
                    if(s.size()>maxHeight){maxHeight=s.size();}
                    s.remove(s.size()-1);
                    n.remove(n.size()-1);

                    //now since the node is empty, moving on to its sibling
                    Node temp=s.get(s.size()-1);

                    int temp2=n.get(n.size()-1);

                    int temp3=n.get(n.size()-1);
                    n.remove(n.size()-1);
                    n.add(temp3+1);
                    //checking if it has a sibling
                    if(temp2+1<temp.nodes.size()) {
                        s.add(temp.nodes.get(temp2 + 1));
                        if(s.size()>maxHeight){maxHeight=s.size();}
                        n.add(-1);
                    }else{
                        //moving up in the tree
//                        currentHeight--;
                        if(s.size()>maxHeight){maxHeight=s.size();}
                        s.remove(s.size()-1);
                        n.remove(n.size()-1);
                    }
                }else{
                    //Moving lower in the tree
//                    currentHeight++;
                    Node temp1=s.get(s.size()-1);
                    int temp2=n.get(n.size()-1);
                    //Checking if you can move lower in the tree
                    if(temp2+1<temp1.nodes.size()) {
                        s.add(temp1.nodes.get(temp2 + 1));
                        if(s.size()>maxHeight){maxHeight=s.size();}
                        n.remove(n.size()-1);
                        n.add(temp2+1);
                        n.add(-1);
                    }else{
                        //moving up in the tree
//                        if(currentHeight>maxHeight){
//                            maxHeight=currentHeight;
//                        }
//                        currentHeight--;
                        if(s.size()>maxHeight){maxHeight=s.size();}
                        s.remove(s.size()-1);
                        n.remove(n.size()-1);
                    }
                }

            }

            return maxHeight;
        }
    }
    public static void main(String[] args){
//        Thread t=new Thread(null, null, "thread1", )
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        BinaryTree b=new BinaryTree(n);
        for(int i=0;i<n;i++){
            int a2=scanner.nextInt();
            b.insert(i, a2);
        }
//        for(int i=-1;i<100000-1;i++){
//            int a2=i;
//            b.insert();
//        }
        // BinaryTree b=new BinaryTree(5);
        // b.insert(2, -1);
        // b.insert(4, 1);
        // b.insert(1, 2);
        // b.insert(3, 2);
        // b.insert(0, 4);
        // b.traverse_dfs_nlr(b.getRoot());
        // System.out.println();
//        System.out.println(b.getMaxHeight(b.getRoot()));
        System.out.println(b.getMaxHeightNonRecursively());
    }
}