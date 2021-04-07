package IO.ReadAndWriter;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

    //针对非文本文件使用字节流：FileInputStream、FileOutputStream
    @Test
    public void testFileOutputStream(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //提供file类的对象，指明写出位置文件
            File srcFile=new File("1.jpg");
            File destFile=new File("2.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer=new byte[1024];
            int len=0;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("complete...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis!=null){
                //关闭流
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void copyFile(String srcPath,String descPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //提供file类的对象，指明写出位置文件
            File srcFile=new File(srcPath);
            File destFile=new File(descPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer=new byte[1024];
            int len=0;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("complete...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis!=null){
                //关闭流
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start=System.currentTimeMillis();
        String src="F:\\1\\壹环的复兴 - 一地废物.mp3";
        String desc="F:\\1\\2.mp3";

        copyFile(src,desc);
        long end=System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
    }


}
