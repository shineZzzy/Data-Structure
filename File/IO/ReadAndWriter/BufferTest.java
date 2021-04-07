package IO.ReadAndWriter;

import org.junit.Test;

import java.io.*;

public class BufferTest {

    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            File srcFile=new File("F:\\1\\壹环的复兴 - 一地废物.mp3");
            File destFile=new File("F:\\1\\2.mp3");

            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer=new byte[1024];
            int len;
            while ((len=bis.read())!=-1){
                bos.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


//        fos.close();
//        fis.close();
    }

    public void copyBuffer(String src,String desc){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            File srcFile=new File("F:\\1\\壹环的复兴 - 一地废物.mp3");
            File destFile=new File("F:\\1\\2.mp3");

            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer=new byte[1024];
            int len;
            while ((len=bis.read())!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopy(){
        long start=System.currentTimeMillis();
        String src="F:\\1\\壹环的复兴 - 一地废物.mp3";
        String desc="F:\\1\\2.mp3";

        copyBuffer(src,desc);
        long end=System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
    }

    @Test
    public void BufferReaderTest(){
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            br = new BufferedReader(new FileReader(new File("abc.txt")));
            bw = new BufferedWriter(new FileWriter(new File("def.txt")));

            //读写1
//            char[] chars=new char[1024];
//            int len;
//            while ((len=br.read(chars))!=-1){
//                bw.write(chars,0,len);
//            }
            //读写2
            String data;
            while ((data=br.readLine())!=null){
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw!=null ){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br!=null ){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
