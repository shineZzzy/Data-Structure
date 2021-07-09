package File;

import java.io.File;

public class ok {
    public static void main(String[] args) {
        //获取目录对象
        File file=new File("F:\\电子课件\\JAVA\\Java课件-2019版本");
        //如果目录存在，获取目录下的文件及文件名
        if(file.exists()){
            String[] files=file.list();
            //获取文件列表
            File[] subFiles=file.listFiles();
            for(File f:subFiles){
                //区分是文件或目录
                if(f.isDirectory()){
                    System.out.println("|- "+f.getName());

                }else {
                    System.out.println("- "+f.getName());
                }
            }
        }else {
            System.out.println("There is no your files ro dir!");
        }
    }
}
