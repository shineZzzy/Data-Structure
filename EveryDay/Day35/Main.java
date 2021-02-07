package Test.Day35;

public class Main{
    public static void main(String[] args){
        int rich=10;
        int PS=1;
        Integer RS=rich*30;

        for(int i=0;i<30;i++){
            PS+=(int)Math.pow(2,i);
        }
        System.out.println(RS+" "+PS);
    }
}
