package Day2;

class Base {
        Base(){
                System.out.println("Base");
        }
}

public class Alpha extends Base{
        public static void main(String[] args) {
                new Day2.Alpha();
                new Base();
        }
}
