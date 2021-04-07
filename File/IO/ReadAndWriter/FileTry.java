package IO.ReadAndWriter;

import org.junit.Test;

import java.io.*;

public class FileTry {

    //读取文件内容输出到控制台
    @Test
    public void testFileReader() {
        FileReader fr= null;
        try {
            //
            File file=new File("hello.txt");
            //提供具体的流
            fr = new FileReader(file);
            //读取数据
            int len;
            while ((len=fr.read())!=-1){
                System.out.print((char) len +" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流，否则会造成内存溢出
                if (fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testReader(){
        FileReader fr= null;
        try {
            //提供file类的对象，指明写出位置文件
            File file=new File("hello.txt");
            //提供FileWriter的对象，用于数据的写出
            fr = new FileReader(file);

            //读取数据
            char[] chars=new char[1024];
            int len;
            while ((len=fr.read(chars))!=-1){
                for (int i=0;i<len;i++) {
                    System.out.print(chars[i]);
                }

//                String str=new String(chars,0,len);
//                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if (fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //写出数据到硬盘文件中
    //输出时，文件不存在会自动创建并写入；文件存在对原有文件覆盖
    @Test
    public void testWriter() throws IOException {
        //提供file类的对象，指明写出位置文件
        File file=new File("hello.txt");
        //提供FileWriter的对象，用于数据的写出
        FileWriter fw=new FileWriter(file,true);
        //写出操作
        fw.write("\nI have an apple\n");
        fw.write("I have an orange");
        //关闭流
        fw.close();
    }

    //复制
    @Test
    public void testCopy() {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //提供file类的对象，指明写出位置文件
            File srcFile=new File("hello.txt");
            File destFile=new File("world.txt");
            //创建输入流和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //数据的读入和写出操作
            char[] buffer=new char[1024];
            //记录每次读入buffer数组中的字符个数
            int len;
            while ((len=fr.read(buffer))!=-1){
                //每次写len个字符
                fw.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            try {
                System.out.println("complete...");
                if (fw!=null && fr!=null){
                    fw.close();
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    //读取
    @Test
    public void testFileInputStream(){
        FileInputStream fis= null;
        try {
            File file=new File("hello.txt");
            fis = new FileInputStream(file);

            byte[] buffer=new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}
