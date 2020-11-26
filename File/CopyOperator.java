package File;

//利用文件输入/输出字节流实现文件的复制操作。

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyOperator {
    public static void main(String[] args) {
        try {
            String byFileName="byteFile.dat";
            String copyFileName="copyFile.dat";

            //创建输入/输出流对象
            FileInputStream fin=new FileInputStream(byFileName);
            FileOutputStream fout=new FileOutputStream(copyFileName);
            byte[] buffer=new byte[512];
            int count=0;
            do{
                count=fin.read(buffer);
                if(count!=-1){
                    fout.write(buffer);
                }
            }while (count!=-1);
            fin.close();
            fout.close();
            System.out.println("Copyfile from "+byFileName + " to "+copyFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
