package 实验报告;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;

//给定一个球体的半径，计算其体积。
//其中球体体积公式为 V = 4/3*πr3，其中 π= 3.1415926
public class Test13 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double r=scan.nextDouble();
        double pi=3.1415926;
        double V=4/3*((pi*r)*(pi*r)*(pi*r));
        System.out.printf("%.2f",V);
    }
}

