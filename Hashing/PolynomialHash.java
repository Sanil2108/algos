import java.util.*;

class PolynomialHash{
    //without cardinality fix    
    ArrayList<ArrayList<MyObject>> objs;

    int p;
    int x;

    PolynomialHash(int p, int x){
        this.p=p;
        this.x=x;
        objs=new ArrayList<>(p);
        for(int i=0;i<p;i++){
            ArrayList<MyObject> temp=new ArrayList<>();
            objs.add(temp);
        }
    }

    public long polyHash(String s){
        char[] chars=s.toCharArray();
        long hash=0;
        for(int i=0;i<chars.length;i++){
            long temp = ((int)chars[i]*(long)Math.pow(10, i))%p;
            hash+=temp;
        }
        return hash%p;
    }

    public void add(String key, int value){
        long hash=polyHash(key);
        ArrayList<MyObject> temp=objs.get((int)hash);

        MyObject newObject=new MyObject(value, key);

        for(MyObject o:temp){
            if(o.equals(newObject)){
                return;
            }
        }

        temp.add(newObject);
    }

    public int get(String key){
        long hash=polyHash(key);
        int value=-1;
        ArrayList<MyObject> temp=objs.get((int)hash);
        for(MyObject i:temp){
            if(i.obj.equals(key)){
                return i.value;
            }
        }
        return value;
    }

    static class MyObject{
        int value;
        String obj;

        MyObject(int value, String obj){
            this.value=value;
            this.obj=obj;
        }

        @Override
        public boolean equals(Object o){
            try{
                MyObject t=(MyObject)o;
                if(t.obj.equals(obj)){
                    return true;
                }
            }catch(ClassCastException e){
                e.printStackTrace();
            }
            return false;
        }
    }

    public static void main(String[] args){
        int p = 1_000_033;
        PolynomialHash hash=new PolynomialHash(p, 23);
        hash.add("Sanil Khurana", 21_08_1998);
        System.out.println(hash.get("Sanil Khurana"));
    }
}