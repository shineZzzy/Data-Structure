package 实验报告;

//请计算表达式“(-8+22)×a-10+c÷2”，其中，a = 40，c = 212

public class Test4 {
    public static void main(String[] args) {
        int a=40;
        int c=212;
        int b=8;
        int d=22;
        int sum =d-b;
        float m=a*sum -10+c/2;
        int res=(int)(m);
        System.out.println(res);
    }
}
