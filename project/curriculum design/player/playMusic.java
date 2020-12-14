package player;

import readFile.PlayMp3;
import readFile.PlayWav;

import java.io.File;
import java.util.Scanner;

public class playMusic {
    public static void main(String[] args) {
        System.out.println("请输入一个文件夹及其路径(输入quit 退出：)");
        Scanner scan=new Scanner(System.in);
        String dir=scan.nextLine();
        if(dir.equals("quit")){
            scan.close();
            System.out.println("已退出,BYE!");
            System.exit(0);
        }
        //进行文件处理
        try {
            File file =new File("F:\\mp3");
            if (file.exists()) {//如果文件或目录存在
                //获取文件名，进行随机读取
                String[] s= PlayRandom.getRandomFiles(file);
                //判断文件类型是mp3或wav
                for (String str:s) {
                    PlayMp3 pm=new PlayMp3();
                    PlayWav pw=new PlayWav();
                    if (str.contains(".mp3")) {//如果是MP3
                        System.out.println(str);
                        PlayMp3.playMp3(str);
                    }else if(str.contains(".wav")){////如果是wav
                        PlayWav.playWav(str);
                    }
                }
            }else {
                System.out.println("没有找到该文件，请确认路径！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
