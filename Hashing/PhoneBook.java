import java.util.*;
class PhoneBook{
    static class Contact{
        long number;
        String name;

        Contact(String name, long number){
            this.name=name;
            this.number=number;
        }

        @Override
        public String toString(){
            return name+" "+number;
        }

        @Override
        public boolean equals(Object obj){
            try{
                Contact c=(Contact)obj;
                if(c.name.equals(this.name) &&
                        c.number==this.number){
                    return true;
                }else{
                    return false;
                }
            }catch(ClassCastException e){
                e.printStackTrace();
            }
            return false;
        }
    }

    static class MapFromLongToString{
        private static final long P=10_000_019;
        private int m;
        private int n=0;
        private int alpha;

        ArrayList<ArrayList<Contact>> objs;

        private int a;
        private int b;

        MapFromLongToString(int a, int b, int m){
            this.m=m;
            this.a=a;
            this.b=b;
            objs=new ArrayList<>(m);
            for(int i=0;i<m;i++){
                objs.add(new ArrayList<Contact>());
            }
        }

        public int hash(long v){
            int key = (int)(((a*v+b) % P) % m);
            return key;
            // return (int)v;
        }

        public void add(long a, String name){
            n+=1;
            ArrayList<Contact> temp=objs.get(hash(a));
            Contact c=new Contact(name, a);
            for(int i=0;i<temp.size();i++){
                Contact s=temp.get(i);
                if(s.number==a){
                    s.name=name;
                    return;
                }
            }
            temp.add(c);
        }

        public void print(){
            for(int i=0;i<m;i++){
                ArrayList<Contact> temp=objs.get(i);
                if(!temp.isEmpty()){
                    for(Contact s:temp){
                        System.out.print(s+"\t\t\t");
                    }
                    System.out.println();
                }
            }
        }

        public String getName(long number){
            ArrayList<Contact> c=objs.get(hash(number));
            for(int i=0;i<c.size();i++){
                if(c.get(i).number==number){
                    return c.get(i).name;
                }
            }
            return null;
        }

        public double getAlpha(){
            return (double)n/m;
        }

        public void delete(int number){
            n-=1;
            ArrayList<Contact> temp=objs.get(hash(number));
            for(int i=0;i<temp.size();i++){
                if(temp.get(i).number==number){
                    temp.remove(i);
                }
            }
        }
    }

    public static void main(String[] args){
        Random random=new Random();

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        MapFromLongToString m=new MapFromLongToString(random.nextInt(100)+1, random.nextInt(100), n);

        for(int i=0;i<n;i++){
            String cmd=in.next();
            switch(cmd){
                case "add":
                    int num=in.nextInt();
                    String name=in.next();
                    m.add(num, name);
                    break;
                case "find":
                    int num2=in.nextInt();
                    String name2=m.getName(num2);
                    if(name2!=null){
                        System.out.println(name2);
                    }else{
                        System.out.println("not found");
                    }
                    break;
                case "del":
                    int num3=in.nextInt();
                    m.delete(num3);
                    break;
            }
        }

        // MapFromLongToString m=new MapFromLongToString(random.nextInt(100)+1 ,random.nextInt(100));
        // m.add(8860009, "Sanil");

        // for(int i=0;i<30;i++){
        //     long number=random.nextInt((int)Math.pow(10, 8)-(int)Math.pow(10, 7))+(int)Math.pow(10, 7);
        //     String name="Sanil"+i;
        //     m.add(number, name);
        // }
        // System.out.println(m.getAlpha());
        // m.print();
    }
}