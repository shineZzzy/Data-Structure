package Day18;

public class countMoney {
    public static void main(String[] args) {
        int rich=10;
        //富翁每天给陌生人10w
        Integer rC=rich*30;
        int sC=1;
        //陌生人每天给富翁2^(i-1)分
        for (int i=1;i<30;i++) {
            sC += (int)Math.pow(2,i);
        }
        System.out.print(rC+" ");
        System.out.print(sC);
    }
}
