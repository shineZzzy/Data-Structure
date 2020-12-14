package readFile;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayMp3 {
    public static void playMp3(String s){
        try {
            File f=new File("F:\\mp3\\"+s);
            FileInputStream fi = new FileInputStream(f);
            BufferedInputStream stream = new BufferedInputStream(fi);
            Player player = new Player(stream);
            player.play();
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
