package Day13;
public class Cat{
    static boolean out(char c){
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
//        int i=0;
//        for(out('A');out('B')&&(i<2);out('C')){
//            i++;
//            out('D');
//        }
//
        int x=20,y=30;
        boolean b;
        b=x>50 && y>60 ||x>50 &&y<-60 || x<-50 && y>60 ||x<-50 && y<-60;
        System.out.println(b);

    }

}