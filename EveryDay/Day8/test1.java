package Day8;

public class test1 {
    static int cnt=6;
    static {
        cnt+=9;
    }
    public static void main(String[] args) {
        System.out.println(cnt);
    }
    static {
        cnt /=3;
    };
}
