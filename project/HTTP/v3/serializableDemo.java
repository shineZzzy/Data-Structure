package Mine.v3;


import java.io.*;

public class serializableDemo {
//    public static void main(String[] args) {
//        User u1 = new User(1, "陈沛鑫", "男");
//        User u2 = new User(2, "林黛玉", "女");
//
//        //将u1 u2对象序列化，写入文件中
//        String filename = "E:\\java-code\\Maven\\project3\\session\\users.obj";
//        try (OutputStream outputStream = new FileOutputStream(filename)) {
//            //对象流？
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//
//            //将序列化的对象写进去文件中
//            objectOutputStream.writeObject(u1);
//            objectOutputStream.writeObject(u2);
//
//            objectOutputStream.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //反序列化：从文件中将二进制数据读出来，重新组织成对象
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "E:\\java-code\\Maven\\project3\\session\\users.obj";
        try (InputStream inputStream = new FileInputStream(filename)) {

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            //直接用这个读取，默认得到是Object类型，需要向下转型
//            Object object=objectInputStream.readObject();
            //so,连用
            User u1 = (User)objectInputStream.readObject();
            User u2 = (User)objectInputStream.readObject();

            System.out.println(u1);
            System.out.println(u2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
