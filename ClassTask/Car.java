package ClassTask;

public class Car {
    public int age;

    public static void main(String[] args) {
        Car c1=new Car();
        Car c2=new Car();
        Car c3=new Car();

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        Class<? extends Car> aClass=c1.getClass();
        ClassLoader cl=aClass.getClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(cl.getParent().getParent());

    }
}
