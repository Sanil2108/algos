//Following is a simple implementation of HashMaps
//and an example of IP Log file
import java.util.*;
import java.net.*;

class IpAddressLogFileUsingHashes{

    static class MyObject{
        String ip;
        int count;

        MyObject(String ip, int count){
            this.ip=ip;
            this.count=count;
        }

        MyObject(String ip){
            this(ip, 0);
        }
    }

    static class DynamicList{
        static final int INIT_CAPACITY=10;

        MyObject[] objs;

        int back=-1;

        DynamicList(){
            objs=new MyObject[INIT_CAPACITY];
        }

        public void add(MyObject o){
            if(objs.length == back+1){
                MyObject[] newObjs=new MyObject[objs.length*2];
                for(int i=0;i<objs.length;i++){
                    newObjs[i]=objs[i];
                }
                objs=newObjs;
            }
            back++;
            objs[back]=o;
        }

        public MyObject get(int index){
            return objs[index];
        }

        public boolean isEmpty(){
            return objs[0]==null;
        }
    }

    static class HashMap{
        static final int FIRST=3;
        static final int M=(int)Math.pow(10,FIRST);

        DynamicList list[];

        HashMap(){
            list=new DynamicList[M-1];
            for(int i=0;i<M-1;i++){
                list[i]=new DynamicList();
            }
        }

        public static int hash(MyObject o){
            char[] ip=o.ip.replace('.', '\0').toCharArray();
            int ipWithoutDots = 0;

            for(int i=0;i<FIRST;i++){
                if(ip[i]=='\0'){
                    continue;
                }
                ipWithoutDots+=Integer.parseInt(ip[i]+"")*(int)Math.pow(10, FIRST-1-i);
            }
            // System.out.println(ipWithoutDots);
            return ipWithoutDots;
        }

        public void add(MyObject object){
            DynamicList temp = list[hash(object)];
            // System.out.println(temp);
            for(MyObject obj : temp.objs){
                if(obj == object){
                    return;
                }
            }
            temp.add(object);
        }

        public void print(){
            for(DynamicList i : list){
                if(!i.isEmpty()){
                    for (MyObject o : i.objs) {
                        if(o!=null) {
                            System.out.print(o.ip + "\t");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args){
        HashMap h=new HashMap();
        h.add(new MyObject("198.278.1.1"));
        h.add(new MyObject("198.168.1.2"));
        h.add(new MyObject("194.168.1.5"));
        h.add(new MyObject("192.168.1.4"));
        h.add(new MyObject("192.168.1.3"));
        h.print();
    }
}