package Test.Day34;

import java.util.Scanner;

public class getRV {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            double x0=sc.nextDouble();
            double y0=sc.nextDouble();
            double z0=sc.nextDouble();
            double x1=sc.nextDouble();
            double y1=sc.nextDouble();
            double z1=sc.nextDouble();
            double r=getR(x0,y0,z0,x1,y1,z1);
            double v=getV(x0,y0,z0,x1,y1,z1);

            System.out.printf("%.3f %.3f",r,v);
            System.out.println();
        }

    }

    private static double getR(double x0, double y0, double z0, double x1, double y1, double z1) {
        double r1=0;
        double r2=0;
        r2=(x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        r1=Math.sqrt(r2);
        return r1;
    }

    private static double getV(double x0, double y0, double z0, double x1, double y1, double z1) {
        double v=0;
        double r=getR(x0,y0,z0,x1,y1,z1);
        v = (4*Math.acos(-1)*Math.pow(r, 3))/3;
        return v;
    }
}
