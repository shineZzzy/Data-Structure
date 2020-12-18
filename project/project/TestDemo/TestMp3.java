package TestDemo;

import PlayDemo.Play;
import PlayDemo.Random;
import java.io.File;
import java.util.Scanner;

/**
 * 测试 MP3文件的读取
 */

public class TestMp3 {

    public static void main(String[] args) {
        System.out.println("请输入一个文件夹及其路径(输入quit 退出：)");
        Scanner scan=new Scanner(System.in);
        String dir=scan.nextLine();
        File file =new File(dir);
        if (file.exists()) {//如果文件或目录存在
            //获取文件名，进行随机读取
            String[] s = Random.getRandomFiles(file);
            //判断文件类型是否mp3
            for (String str : s) {
                Play play=new Play(dir);
                //截取文件后缀名，判断是否为MP3
                String s1=str.substring(str.length()-3);
                if (s1.contains("mp3")) {//如果是MP3
                    System.out.println(str);
                    Play.playMp3(str);
                }
                if(!s1.contains("wav")&&!s1.contains("mp3")) {
                    System.out.println("路径有误或查找文件不存在！");
                    System.exit(0);
                }
            }
        }
    }

}
