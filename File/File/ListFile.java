package File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir=new File("F:\\电子课件\\JAVA\\书籍");
        List<File> files=listDir2(dir);
        files.stream().forEach(System.out::println);//???
    }
    public static List<File> listDir(File dir){
        List<File> list=new ArrayList<>();
        //判断dir is File or Dir ? list.add : File[]
        if (dir.isFile()){
            list.add(dir);
        }else if(dir.isDirectory()){
            File[] children=dir.listFiles();
            if (children!=null){
                for (File child:children){
                    List<File> files =listDir(child);
                    list.addAll(files);
                }
            }
        }
        return list;
    }
    public static List<File> listDir2(File dir){
        List<File> list=new ArrayList<>();
        //判断dir is File or Dir ? list.add : File[]
        if (dir.isFile()){
            return null;
        }
        if(dir.isDirectory()){
            File[] children=dir.listFiles();
            if (children!=null){
                for (File child:children){
                    //返回文件列表不包含文件夹
//                    if (child.isDirectory()){
//                        //如果子文件还是目录，递归调用获取
//                        list.addAll(listDir2(dir));
//                    }else {
//                        list.add(child);
//                    }
                    list.add(child);
                    if (child.isDirectory()){
                        list.addAll(listDir2(child));
                    }
                }
            }
        }
        return list;
    }
}
