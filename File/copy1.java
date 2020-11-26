package File;

import java.io.*;
public class copy1 {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new FileReader("copy1.java"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("newcopy1.dat"));

            String line=null;
            do{
                //按行读入
                line=br.readLine();
                if(line!=null){
                    //按行写入
                    bw.write(line);
                }
            } while (line!=null);
            //关闭输入/输出流
            br.close(); bw.close();
            System.out.println("The file was copyed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
