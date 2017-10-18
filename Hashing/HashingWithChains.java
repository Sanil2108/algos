import java.util.*;
import java.io.*;

class HashingWithChains{
    ArrayList<ArrayList<String>> objs;

    int m;
    final int p=1000000007;
    final int x=263;

    HashingWithChains(int m){
        this.m=m;
        objs=new ArrayList<>(m);
        for(int i=0;i<m;i++){
            ArrayList<String> temp=new ArrayList<>();
            objs.add(temp);
        }
    }

    public int polyHash(String s){
        long hash=0;
        char[] chr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            long temp = ((((int)chr[i]*(long)Math.pow(x, i))%p)+p)%p;
            hash+=temp;
            hash=((hash%p)+p)%p;
        }
        System.out.println((int)(((hash%m)+m)%m));
        return (int)(((hash%m)+m)%m);
    }

    private int hashFunc(String s) {
        int multiplier=x;
        int bucketCount=m;
        int prime=1000000007;
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        // System.out.println((int)hash % bucketCount);
        return (int)hash % bucketCount;
    }

    public String showList(int index){
        String tempString="";
        ArrayList<String> temp=objs.get(index);
        for(int i=temp.size()-1;i>=0;i--){
            tempString+=temp.get(i)+" ";
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();
        return tempString+"\n";
    }

    public void add(String s){
        // int hash=polyHash(s);
        int hash=hashFunc(s);
        ArrayList<String> temp=objs.get(hash);
        for(int i=temp.size()-1;i>=0;i--){
            String s2=temp.get(i);
            if(s2.equals(s)){
                return;
            }
        }
        temp.add(s);
    }

    public boolean check(String s){
        // int hash=polyHash(s);
        int hash=hashFunc(s);
        ArrayList<String> temp=objs.get(hash);
        for(int i=temp.size()-1;i>=0;i--){
            String s2=temp.get(i);
            if(s2.equals(s)){
                return true;
            }
        }
        return false;
    }

    public void delete(String s){
        //  int hash=polyHash(s);
        int hash=hashFunc(s);
        ArrayList<String> temp=objs.get(hash);
        for(int i=temp.size()-1;i>=0;i--){
            String s2=temp.get(i);
            if(s2.equals(s)){
                temp.remove(i);
            }
        }
    }

    public static void main(String[] args){
        // stressTest();
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        HashingWithChains h=new HashingWithChains(m);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            String temp=in.next();
            switch (temp) {
                case "add":
                    String temp2=in.next();
                    h.add(temp2);
                    break;
                case "check":
                    int temp3=in.nextInt();
                    h.showList(temp3);
                    break;
                case "find":
                    String temp4=in.next();
                    boolean temp5=h.check(temp4);
                    if(temp5){
                        System.out.println("yes");
                    }else{
                        System.out.println("no");
                    }
                    break;
                case "del":
                    String temp6=in.next();
                    h.delete(temp6);
                    break;
            }
        }
    }


    public static void stressTest(){
        int m,n;
        ArrayList<HashChains.Query> queries=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        HashingWithChains hashingWithChains=new HashingWithChains(m);
        for(int i=0;i<n;i++){
            String type = in.next();
            if (!type.equals("check")) {
                String s = in.next();
                queries.add(new HashChains.Query(type, s));
            } else {
                int ind = in.nextInt();
                queries.add(new HashChains.Query(type, ind));
            }
        }
        ArrayList<String> ans2=new ArrayList<>();
        for(HashChains.Query q:queries){
            switch(q.type){
                case "add":
                    // String temp2=in.next();
                    String temp2=q.s;
                    hashingWithChains.add(temp2);
                    break;
                case "check":
                    // int temp3=in.nextInt();
                    int temp3=q.ind;
                    ans2.add(hashingWithChains.showList(temp3));
                    break;
                case "find":
                    // String temp4=in.next();
                    String temp4=q.s;
                    boolean temp5=hashingWithChains.check(temp4);
                    if(temp5){
                        // System.out.println("yes");
                        ans2.add("yes\n");
                    }else{
                        ans2.add("no\n");
                        // System.out.println("no");
                    }
                    break;
                case "del":
                    // String temp6=in.next();
                    String temp6=q.s;
                    hashingWithChains.delete(temp6);
                    break;
            }
        }
        for(String s:ans2){
            System.out.print(s);
        }


        HashChains hashChains=new HashChains();
        ArrayList<String> ans1=new ArrayList<>();
        try{
            int m2,n2;
            // ArrayList<HashChains.Query> queries2=new ArrayList<>();
            // // Scanner in=new Scanner(System.in);
            // m2=m;
            // n2=n;
            // for(int i=0;i<n2;i++){
            //     String type = in.next();
            //     if (!type.equals("check")) {
            //         String s = in.next();
            //         queries2.add(new HashChains.Query(type, s));
            //     } else {
            //         int ind = in.nextInt();
            //         queries2.add(new HashChains.Query(type, ind));
            //     }
            // }
            ans1 = hashChains.processQueries(m, n, queries);
            for(String s:ans1){
                System.out.print(s);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        if(ans1.equals(ans2)){
            System.out.println("They both are the same");
        }else{
            System.out.println("NOT SAME\n");
            in.next();
        }
    }

    static class HashChains {
        // private FastScanner in;
        // private PrintWriter out;
        // store all strings in one list
        private List<String> elems;
        // for hash function
        private int bucketCount;
        private int prime = 1000000007;
        private int multiplier = 263;

        // public static void main(String[] args) throws IOException {
        //     new HashChains().processQueries();
        // }

        private int hashFunc(String s) {
            long hash = 0;
            for (int i = s.length() - 1; i >= 0; --i)
                hash = (hash * multiplier + s.charAt(i)) % prime;
            return (int)hash % bucketCount;
        }

        // private Query readQuery() throws IOException {
        //     String type = in.next();
        //     if (!type.equals("check")) {
        //         String s = in.next();
        //         return new Query(type, s);
        //     } else {
        //         int ind = in.nextInt();
        //         return new Query(type, ind);
        //     }
        // }

        private String writeSearchResult(boolean wasFound) {
            return wasFound ? "yes\n" : "no\n";
            // Uncomment the following if you want to play with the program interactively.
            // out.flush();
        }

        private String processQuery(Query query) {
            switch (query.type) {
                case "add":
                    if (!elems.contains(query.s))
                        elems.add(0, query.s);
                    return "";
                case "del":
                    if (elems.contains(query.s))
                        elems.remove(query.s);
                    return "";
                case "find":
                    return writeSearchResult(elems.contains(query.s));
                case "check":
                    String temp="";
                    for (String cur : elems)
                        if (hashFunc(cur) == query.ind)
                            temp+=cur + " ";
                    // out.println();
                    temp+="\n";
                    // Uncomment the following if you want to play with the program interactively.
                    // out.flush();
                    return temp;
                default:
                    throw new RuntimeException("Unknown query: " + query.type);
            }
        }

        public ArrayList<String> processQueries(int bucketCount, int queryCount2, ArrayList<Query> q) throws IOException {
            elems = new ArrayList<>();
            // in = new FastScanner();
            // out = new PrintWriter(new BufferedOutputStream(System.out));
            this.bucketCount = bucketCount;
            // bucketCount = in.nextInt();
            // int queryCount = in.nextInt();
            int queryCount=queryCount2;
            ArrayList<String> ans=new ArrayList<>();
            for (int i = 0; i < queryCount; ++i) {
                ans.add(processQuery(q.get(i)));
            }
            return ans;
            // out.close();
        }

        static class Query {
            String type;
            String s;
            int ind;

            public Query(String type, String s) {
                this.type = type;
                this.s = s;
            }

            public Query(String type, int ind) {
                this.type = type;
                this.ind = ind;
            }
        }

        // static class FastScanner {
        //     private BufferedReader reader;
        //     private StringTokenizer tokenizer;

        //     public FastScanner() {
        //         reader = new BufferedReader(new InputStreamReader(System.in));
        //         tokenizer = null;
        //     }

        //     public String next() throws IOException {
        //         while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        //             tokenizer = new StringTokenizer(reader.readLine());
        //         }
        //         return tokenizer.nextToken();
        //     }

        //     public int nextInt() throws IOException {
        //         return Integer.parseInt(next());
        //     }
        // }
    }
}