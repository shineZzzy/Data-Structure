package Test.Files;
//递归调用--效率较低


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir=new File("F:\\电子课件\\JAVA\\Java课件-2019版本");
        List<File> files=listDir(dir);
        files.stream().forEach(System.out::println);
    }

    public static List<File> listDir1(File dir){
        List<File> list=new ArrayList<>();
        if (dir.isFile()){
            //如果是文件，返回了一个list只存放一个元素
            list.add(dir);
        }else {
            File[] children=dir.listFiles();
            if (children!=null){
                for (File child:children) {
                    List<File> files=listDir1(child);
                    list.addAll(files);
                }
            }
        }
        return list;
    }

    public static List<File> listDir2(File dir){

        if (dir.isDirectory()){
            List<File> list=new ArrayList<>();

        }
        return null;
    }
}
