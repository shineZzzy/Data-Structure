package File;

import java.io.*;


public class FileRead {
    public static void main1(String[] args) throws IOException {
        File file=new File("F:\\电子课件\\JAVA\\板书合辑\\20210117.png");
        //1.文件输入字节流
        FileInputStream fis=new FileInputStream(file);

        byte[]  bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            /**
             * 输入流：固定用法
             * 读取到一个字节/字符数组，定义read的返回值
             * 读取长度，数组可能读满，也可能没满，单次读取内容，长度一般为[0,len]
             */
            String str=new String(bytes,0,len);
            System.out.println(str);
        }
        /**
         * 一般来说，使用完后要关闭流，反向关闭
         * 创建：从内而外    关闭：从外而内
         */
        fis.close();
    }

    public static void main2(String[] args) throws IOException {
        File file=new File("F:\\电子课件\\JAVA\\板书合辑\\20210117.png");
        //2.文件输入字符流
        FileReader fr=new FileReader(file);
        char[] chars=new char[1024];
        int len=0;
        while ((len=fr.read(chars))!=-1){
            String str=new String(chars,0,len);
            System.out.println(str);
        }
    }

    //缓冲流：缓冲字节输入，缓冲字符输入
    public static void main3(String[] args) throws IOException {
        File file=new File("F:\\电子课件\\JAVA\\思路.txt");
        //缓冲的字节输入流
        FileInputStream fis=new FileInputStream(file);//文件字节输入流

        //字节流转字符流，一定要经过字节字符转换流进行转换，并且可以制定编码
        //文件编码格式要一致，否则会乱码
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        String str;
        while ((str = br.readLine())!=null){
            System.out.println(str);
        }
        //释放流
        br.close();
        isr.close();
        fis.close();

    }

    public static void main4(String[] args) throws IOException {
        File file=new File("F:\\电子课件\\JAVA\\思路.txt");
        //缓冲的字节输入流
        FileInputStream fis=new FileInputStream(file);//文件字节输入流
        BufferedInputStream bis=new BufferedInputStream(fis);
        byte[]  bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1){
            /**
             * 输入流：固定用法
             * 读取到一个字节/字符数组，定义read的返回值
             * 读取长度，数组可能读满，也可能没满，单次读取内容，长度一般为[0,len]
             */
            String str=new String(bytes,0,len);
            System.out.println(str);
        }

    }

    public static void main(String[] args) throws IOException {
        //路径上没有该文件，new File不会报错，但操作输入输出流会抛异常FileNotFountException
        File file=new File("F:\\电子课件\\JAVA\\思路.txt");
        //将a-z换行输出到某个文件，需要考虑文件是否存在问题
        if (!file.exists()){
            file.createNewFile();
        }
//        new FileWriter()/new FileOutputStream()/BufferedWriter
//        不带缓冲区的字符输出/缓冲输出
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));


    }
}
