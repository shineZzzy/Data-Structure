package File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//打印一个目录中的所有子目录里的所有文件名
public class readFile {
    public static void main(String[] args) {
        File file=new File("F:\\电子课件\\JAVA\\Java课件-2019版本");
        if(file.exists()) {
            ListDir(file);
        }
    }
    public static void ListDir(File dir){
        List<File> list=new ArrayList<>();
        File[] child=dir.listFiles();
        for(File f:child) {
            if (f.isDirectory()) {
                System.out.println("|- " + f.getName());
                if (child != null) {
                    ListDir(f);
                }
            } else {
                System.out.println("  -- " + f.getName());
            }
        }
    }
}
