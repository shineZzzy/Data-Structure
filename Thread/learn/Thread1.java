package learn;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Thread1 extends Thread{
    private String url;
    private String name;

    public Thread1(String url,String name){
        this.name=name;
        this.url=url;
    }

    @Override
    public void run() {
        WebDownLoader wd=new WebDownLoader();
        wd.downloader(url,name);
        System.out.println("ok"+name);
    }

    public static void main(String[] args) {
        Thread1 t1=new Thread1("https://img-blog.csdnimg.cn/20201121203400755.png","1.jag");
        Thread1 t2=new Thread1("https://img-blog.csdnimg.cn/20201121203400755.png","2.jag");

        t1.start();
        t2.start();
    }
}
class WebDownLoader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
