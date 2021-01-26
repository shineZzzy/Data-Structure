package Test.Day26;

import java.util.Scanner;

/**
 * 北京大学对本科生的成绩施行平均学分绩点制(GPA)。
 * 公式如下:实际成绩绩点:
 * 90——100 4.0 85——89 3.7
 * 82——84 3.3  78——81 3.0
 * 75——77 2.7  72——74 2.3
 * 68——71 2.0  64——67 1.5
 * 60——63 1.0  60以下 0
 * 一门课程的学分绩点=该课绩点*该课学分
 * 总评绩点=所有学科绩点之和/所有课程学分之和
 * 现要求你编写程序求出某人A的总评绩点(GPA)。
 */
public class AvgScore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double res=0;
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] credit=new int[n];
            int[] score=new int[n];
            for (int i = 0; i <n; i++) {
                credit[i]=sc.nextInt();
            }
            for (int i = 0; i <n; i++) {
                score[i]=sc.nextInt();
            }
            res=getGPA(n,credit,score);
            System.out.printf("%.2f",res);
        }
    }

    private static double getGPA(int n, int[] c, int[] s) {
        double sco=0; //学分绩点
        double sum=0;//学分绩点和
        double cre=0;
        double GPA=0;
        for (int i = 0; i <c.length; i++) {
            if(s[i]<=100 && s[i]>=90){
                sco=c[i]*4.0;
                sum +=sco;
            }else if(s[i]<=89 && s[i]>=85){
                sco=c[i]*3.7;
                sum +=sco;
            }else if(s[i]<=84 && s[i]>=82){
                sco=c[i]*3.3;
                sum +=sco;
            }else if(s[i]<=81 && s[i]>=78){
                sco =c[i]*3.0;
                sum +=sco;
            }else if(s[i]<=77 && s[i]>=75){
                sco =c[i]*2.7;
                sum +=sco;
            }else if(s[i]<=74 && s[i]>=72){
                sco =c[i]*2.3;
                sum +=sco;
            }else if(s[i]<=71 && s[i]>=68){
                sco =c[i]*2.0;
                sum +=sco;
            }else if(s[i]<=67 && s[i]>=64){
                sco =c[i]*1.5;
                sum +=sco;
            }else if(s[i]<=63 && s[i]>=60){
                sco =c[i]*1.0;
                sum +=sco;
            }else {
                sco =0;
                sum +=sco;
            }
        }
        for (int i = 0; i <c.length; i++) {
            cre+=c[i];
        }
        GPA=sum/cre;
        return GPA;
    }
}


// 364 325.6 165.6 138 0