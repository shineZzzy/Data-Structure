package TestDemo;

import PlayDemo.Play;
import PlayDemo.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 测试 Wav文件的读取
 */

public class TestWav {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入一个文件夹及其路径(输入quit 退出：)");
        Scanner scan=new Scanner(System.in);
        String dir=scan.nextLine();
        if(dir.equals("quit")){
            scan.close();
            System.out.println("已退出,See You Later!");
            System.exit(0);
        }
        File file =new File(dir);
        if (file.exists()) {//如果文件或目录存在
            //获取文件名，进行随机读取
            String[] s = Random.getRandomFiles(file);
            //判断文件类型是否mp3
            for (String str : s) {
                Play pw=new Play(dir);
                String s1=str.substring(str.length()-3);
                if(s1.contains(".wav")){//如果是wav
                    Play.playWav(str);
                }
                if(!s1.contains("wav")&&!s1.contains("mp3")) {
                    System.out.println("路径有误或查找文件不存在！");
                    System.exit(0);
                }
            }
        }
    }
}
