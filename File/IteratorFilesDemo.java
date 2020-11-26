package File;
import java.io.File;
public class IteratorFilesDemo {
    public static void main(String[] args) {
        //获取目录对象
        File file=new File("C:\\Users");
        //如果目录存在，获取目录下的文件及文件名
        if(file.exists()){
            String[] files=file.list();
            //遍历获取文件名
            for(String fileName:files){
                System.out.println(fileName);
            }
            System.out.println("-------------");
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

