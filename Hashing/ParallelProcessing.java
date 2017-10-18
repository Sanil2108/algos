import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

class ParallelProcessing{
    static class MyThread{
        long nextJobCompletion;
        int id;
        int timeElapsed;

        MyThread(int id, long nextJobCompletion){
            this.id=id;
            this.nextJobCompletion=nextJobCompletion;
            this.timeElapsed=0;
        }

        boolean needsToGoHigherThan(MyThread t){
            if(this.nextJobCompletion<t.nextJobCompletion){
                return true;
            }else{
                if(this.nextJobCompletion==t.nextJobCompletion && this.id<t.id){
                    return true;
                }
            }

            return false;
        }
    }

    static class ThreadMinHeap{
        MyThread[] threads;
        int size;

        int lastThread;

        ThreadMinHeap(int size){
            this.size=size;
            threads=new MyThread[size];

            lastThread=-1;
        }

        MyThread extractMin(){
            MyThread t=threads[0];
            threads[0]=threads[lastThread];
            threads[lastThread]=t;
            lastThread--;

            siftDown(0);

            return t;
        }

        void siftDown(int index){
            int left=2*(index+1)-1;
            int right=2*(index+1);

            if(left<=lastThread && right<=lastThread){
                if(threads[left].needsToGoHigherThan(threads[index]) || threads[right].needsToGoHigherThan(threads[index])){
                    if(threads[left].needsToGoHigherThan(threads[right])){
                        MyThread temp=threads[index];
                        threads[index]=threads[left];
                        threads[left]=temp;
                        siftDown(left);
                    }else{
                        MyThread temp=threads[index];
                        threads[index]=threads[right];
                        threads[right]=temp;
                        siftDown(right);
                    }
                }
            }else if(left<=lastThread){
                if(threads[left].needsToGoHigherThan(threads[index])){
                    MyThread temp=threads[index];
                    threads[index]=threads[left];
                    threads[left]=temp;
                    siftDown(left);
                }
            }else if(right<=lastThread){
                if(threads[right].needsToGoHigherThan(threads[index])){
                    MyThread temp=threads[index];
                    threads[index]=threads[right];
                    threads[right]=temp;
                    siftDown(right);
                }
            }
        }

        void siftUp(int index){
            int parent=(index+1)/2-1;
            if(index==0){
                return;
            }
            if(threads[index].needsToGoHigherThan(threads[parent])){
                MyThread temp=threads[index];
                threads[index]=threads[parent];
                threads[parent]=temp;
                siftUp(parent);
            }
        }

        MyThread top(){
            return threads[0];
        }

        void changePriorityOfTopThread(int jobTime){
            MyThread t=threads[0];
            t.nextJobCompletion=t.nextJobCompletion+jobTime;
            siftDown(0);
        }

        void insert(MyThread t){
            lastThread++;
            threads[lastThread]=t;
            siftUp(lastThread);
        }
    }

    public static int[] stressTest(int t, int j, int[] jobs){
        ThreadMinHeap threadMinHeap=new ThreadMinHeap(t);

        int[] finalArray=new int[j*2];

        for(int i=0,k=0;i<j;i++,k+=2){
            if(i<t){
                //First t jobs are assigned to first t threads
                if(jobs[i]==0){
                    System.out.println(i + " 0");
                    i--;
                    continue;
                }
                MyThread tempThread=new MyThread(i, jobs[i]);
                threadMinHeap.insert(tempThread);
                finalArray[k]=i;
                finalArray[k+1]=0;
//                System.out.println(i+" 0");
            }else {
                MyThread temp2Thread = threadMinHeap.top();
                finalArray[k]=temp2Thread.id;
//                finalArray[k+1]=temp2Thread.nextJobCompletion;
//                System.out.println(temp2Thread.id + " " + temp2Thread.nextJobCompletion);
                threadMinHeap.changePriorityOfTopThread(jobs[i]);
            }
        }

        return finalArray;
    }

    public static void main(String[] args) throws Exception{
//        StressTest.start();
        //Remember to change int to long
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int j=in.nextInt();
        ThreadMinHeap threadMinHeap=new ThreadMinHeap(t);
        for(int i=0;i<j;i++){
            if(i<t){
                //First t jobs are assigned to first t threads
                long temp2=in.nextLong();
                if(temp2==0){
                    System.out.println(i + " 0");
                    i--;
                    j--;
                    continue;
                }
                MyThread tempThread = new MyThread(i, temp2);
                threadMinHeap.insert(tempThread);
                System.out.println(i + " 0");
            }else {
                MyThread temp2Thread = threadMinHeap.top();
                System.out.println(temp2Thread.id + " " + temp2Thread.nextJobCompletion);
                threadMinHeap.changePriorityOfTopThread(in.nextInt());
            }
        }

    }

    static class StressTest{
        public static void start() throws Exception{
            Random random=new Random();
//            Scanner in=new Scanner(System.in);
//            int t=in.nextInt();
//            int j=in.nextInt();
//            int[] jobs=new int[j];
//            for(int i=0;i<j;i++){
//                jobs[i]=in.nextInt();
//            }
//            int[] ans=JobQueue.main(t, j, jobs);
//            int[] ans=stressTest(t, j, jobs);
//            for(int i=0;i<ans.length;i+=2){
//                System.out.println(ans[i]+" "+ans[i+1]);
//            }

            while(true){
                int t=random.nextInt(10);
                int j=random.nextInt(10)+1;
                int[] jobs=new int[j];
                for(int i=0;i<j;i++){
                    jobs[i]=random.nextInt(10);
                }
                int[] ans1=JobQueue.main(t, j, jobs);
                int[] ans2=stressTest(t, j, jobs);
                boolean same=true;
                for(int i=0;i<ans1.length;i++){
                    if(ans1[i]!=ans2[i]){
                        same=false;
                    }
                }
                if(!same){
                    System.out.println("t = "+t+"\nj = "+j);
                    for(int i=0;i<jobs.length;i++){
                        System.out.print(jobs[i]+"\t");
                    }
                    System.out.println();
                    break;
                }else{
                    System.out.println("COMPLETED");
                }
            }
        }
    }

    static class JobQueue {
        private int numWorkers;
        private int[] jobs;

        private int[] assignedWorker;
        private int[] startTime;

        private FastScanner in;
        private PrintWriter out;

        public static int[] main(int t, int j, int[] jobs) throws IOException {
            return new JobQueue().solve(t, j, jobs);
        }

        private void readData(int t, int j, int[] jobs2) throws IOException {
            numWorkers = t;
            int m = j;
            jobs = new int[m];
            for (int i = 0; i < m; ++i) {
                jobs[i] = jobs2[i];
            }
        }

        private int[] writeResponse() {
            int[] ans=new int[jobs.length*2];
            for (int i = 0, j=0; i < jobs.length; i=i+1, j=j+2) {
//                out.println(assignedWorker[i] + " " + startTime[i]);
                ans[j]=assignedWorker[i];
                ans[j+1]=startTime[i];
            }
            return ans;
        }

        private void assignJobs() {
            // TODO: replace this code with a faster algorithm.
            assignedWorker = new int[jobs.length];
            startTime = new int[jobs.length];
            int[] nextFreeTime = new int[numWorkers];
            for (int i = 0; i < jobs.length; i++) {
                int duration = jobs[i];
                int bestWorker = 0;
                for (int j = 0; j < numWorkers; ++j) {
                    if (nextFreeTime[j] < nextFreeTime[bestWorker])
                        bestWorker = j;
                }
                assignedWorker[i] = bestWorker;
                startTime[i] = nextFreeTime[bestWorker];
                nextFreeTime[bestWorker] += duration;
            }
        }

        public int[] solve(int t, int j, int []jobs) throws IOException {
            in = new FastScanner();
            out = new PrintWriter(new BufferedOutputStream(System.out));
            readData(t, j, jobs);
            assignJobs();
            return writeResponse();
//            out.close();
        }

        static class FastScanner {
            private BufferedReader reader;
            private StringTokenizer tokenizer;

            public FastScanner() {
                reader = new BufferedReader(new InputStreamReader(System.in));
                tokenizer = null;
            }

            public String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                return tokenizer.nextToken();
            }

            public int nextInt() throws IOException {
                return Integer.parseInt(next());
            }
        }
    }

//    static class JobQueue {
//        private int numWorkers;
//        private int[] jobs;
//
//        private int[] assignedWorker;
//        private int[] startTime;
//
//        private FastScanner in;
//        private PrintWriter out;
//
//        public static int[] main(int t, int j, int[] jobs) throws IOException {
//            return new JobQueue().solve(t, j, jobs);
//        }
//
//        private void readData(int t, int j, int[] jobs2) throws IOException {
//            numWorkers = t;
//            int m = j;
//            jobs = new int[m];
//            for (int i = 0; i < m; ++i) {
//                jobs[i] = jobs2[i];
//            }
//        }
//
//        private int[] writeResponse() {
//            int[] finalArray=new int[jobs.length*2];
//            for (int i = 0; i < jobs.length; i+=1) {
//                out.println(assignedWorker[i] + " " + startTime[i]);
//                finalArray[i]=assignedWorker[i];
//                finalArray[i+1]=startTime[i];
//            }
//            return finalArray;
//        }
//
//        private void assignJobs() {
//            // TODO: replace this code with a faster algorithm.
//            assignedWorker = new int[jobs.length];
//            startTime = new int[jobs.length];
//            int[] nextFreeTime = new int[numWorkers];
//            for (int i = 0; i < jobs.length; i++) {
//                int duration = jobs[i];
//                int bestWorker = 0;
//                for (int j = 0; j < numWorkers; ++j) {
//                    if (nextFreeTime[j] < nextFreeTime[bestWorker])
//                        bestWorker = j;
//                }
//                assignedWorker[i] = bestWorker;
//                startTime[i] = nextFreeTime[bestWorker];
//                nextFreeTime[bestWorker] += duration;
//            }
//        }
//
//        public int[] solve(int t, int j, int[] jobs) throws IOException {
//            in = new FastScanner();
//            out = new PrintWriter(new BufferedOutputStream(System.out));
//            readData(t, j, jobs);
//            assignJobs();
//            return writeResponse();
//        }
//
//        static class FastScanner {
//            private BufferedReader reader;
//            private StringTokenizer tokenizer;
//
//            public FastScanner() {
//                reader = new BufferedReader(new InputStreamReader(System.in));
//                tokenizer = null;
//            }
//
//            public String next() throws IOException {
//                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                }
//                return tokenizer.nextToken();
//            }
//
//            public int nextInt() throws IOException {
//                return Integer.parseInt(next());
//            }
//        }
//    }
}