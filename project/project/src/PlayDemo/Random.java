package PlayDemo;

import java.io.File;

public class Random {
    public  static String[] getRandomFiles(File f){
        File[] files=f.listFiles();
        if (files.length==0) {
            System.out.println("error");
            System.exit(0);
        }
        String[] filename=new String[files.length];
        int [] oldArr = new int[files.length];
        int [] newArr = new int[files.length];
        for(int i = 0;i<files.length;i++) {
            oldArr[i] = i;
        }
        int end = files.length;
        for (int i=0;i<files.length;i++){
            int num = new java.util.Random().nextInt(end);
            newArr[i] = oldArr[num];
            oldArr[num] = oldArr[end-1];
            end--;
            filename[newArr[i]]=files[i].getName();
        }
        return filename;
    }
}
