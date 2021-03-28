package ClassTask;

public class ClassLoaderTest {
    public static void main(String[] args) {

        //应用程序类加载器
        ClassLoader sysLoader =ClassLoader.getSystemClassLoader();
        System.out.println(sysLoader);
        //扩展类加载器,app上层
        ClassLoader extLoader =sysLoader.getParent();
        System.out.println(extLoader);
        //引导类加载器，ext上层：获取不到
        ClassLoader bootLoader =extLoader.getParent();
        System.out.println(bootLoader);
        //自定义类加载器:默认使用系统类加载器进行类加载
        ClassLoader classLoader =ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //类加载了，但获取不到进行加载的是哪个类
        //String类是使用引导类加载器进行加载的---包括Java核心类库
        ClassLoader c1 =String.class.getClassLoader();
        System.out.println(c1);
    }
}
