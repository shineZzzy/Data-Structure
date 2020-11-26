package File;

import java.io.File;
import java.io.IOException;

public class CreateAndDelDemo {
    public static void main(String[] args) {


        File file=new File("a.dat");
        File dir=new File("F:\\mydir");

        System.out.println("该文件是否存在"+file.exists());
        System.out.println("该文件夹是否存在"+dir.exists());

        //如果不存在创建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!dir.exists()){
            try {
                dir.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("该文件是否存在"+file.exists());
        System.out.println("该文件夹是否存在"+dir.exists());
        System.out.println("文件的绝对路径是"+file.getAbsolutePath());
        System.out.println("文件夹的绝对路径是"+dir.getAbsolutePath());
    }
}
