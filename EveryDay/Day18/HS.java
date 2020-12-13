package Day18;

public class HS {
    private static int x=100;
    public static void main(String[] args) {
        HS hs1=new HS();
        hs1.x++;
        HS hs2=new HS();
        hs2.x++;
        hs1=new HS();
        hs1.x++;
        HS.x--;
        System.out.println(x);

    }
}
