package TestDemo;

import PlayDemo.Random;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试随机数组
 */

public class TestRandom {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String dir=scan.nextLine();
        File file =new File(dir);
        String[] s= Random.getRandomFiles(file);
        System.out.println(Arrays.toString(s));

    }
}
