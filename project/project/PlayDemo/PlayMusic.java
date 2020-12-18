package PlayDemo;

import java.io.File;
import java.util.Scanner;

/**
 * 实现对MP3、Wav音频文件的随机读取
 * 可通过自主输出文件路径，达到人机交互的效果
 *
 */

public class PlayMusic {
    public static void main(String[] args) {
        //人机交互：输入文件路径
        System.out.println("请输入一个文件夹及其路径(输入quit 退出：)");
        Scanner scan=new Scanner(System.in);
        String dir=scan.nextLine();
        //如果输入“quit”退出系统
        if(dir.equals("quit")){
            scan.close();
            System.out.println("已退出,See You Later!");
            System.exit(0);
        }
        //进行文件读取处理
        try {
            File file =new File(dir);
            if (file.exists()) {//如果文件或目录存在
                //获取文件名，进行随机读取
                String[] s= Random.getRandomFiles(file);
                //遍历文件列表，判断文件类型
                for (String str:s) {
                    Play play=new Play(dir);
                    //截取文件后缀名，判断音频文件类型
                    String s1=str.substring(str.length()-3);
                    if (s1.contains("mp3")) {//如果是MP3
                        System.out.println(str);
                        Play.playMp3(str);
                    }else if(s1.contains("wav")){//如果是wav
                        Play.playWav(str);
//                        new PlayWav().playWav(str);
                    }else {
                        System.out.println("未找到目标文件，请重新输入");
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
