package PlayDemo;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.sound.sampled.*;
import java.io.*;

/**
 * 分别实现 Wav、MP3音频文件的读取
 */

public class Play {
    //定义path
    private static String path;
    //携带path参数的构造方法
    public Play(String path) {
        this.path = path;
    }

    //读取Mp3格式
    public static void playMp3(String s){
        try {
            File f=new File(path+"\\"+s);
            FileInputStream fi = new FileInputStream(f);
            BufferedInputStream stream = new BufferedInputStream(fi);
            Player player = new Player(stream);
            //播放
            player.play();
            //异常捕获
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //读取Wav格式
    public static void playWav(String str) throws IOException {
        AudioInputStream as;
        try {
            as = AudioSystem.getAudioInputStream(new File(path+"\\"+str));
            AudioFormat format = as.getFormat();
            SourceDataLine sdl = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(format);
            sdl.start();
            int nBytesRead = 0;
            byte[] abData = new byte[1024];
            while (nBytesRead != -1) {
                nBytesRead = as.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    sdl.write(abData, 0, nBytesRead);
            }
            //关闭SourceDataLine
            sdl.drain();
            sdl.close();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            throw new IOException("文件播放错误！请查看音频类型、输入类型是否符合要求");
        }
        System.out.println(str);
    }
}
