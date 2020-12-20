package Thread5;

public class stack {

    public static void main(String[] args) {
        int i=0;
        change(i);
        System.out.println(i);
        User u=new User();
        u.userName="asd";
        change(u);
        System.out.println(u);

    }

    private static void change(int i) {
        //基本类型按值传递
        //局部变量
        i=6;
    }
    private static void change(User u) {
        u.userName="zxc";
    }

    public static class User{
        private String userName;

    }
}
