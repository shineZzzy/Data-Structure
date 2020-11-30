package Day6;

import java.util.Scanner;

/**
 * A-B  B+C  A+B  B-C
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = 0;
        int B = 0;
        int C = 0;
        while (scan.hasNext()) {
            String[] s = scan.nextLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int d = Integer.parseInt(s[3]);

            A = (a + c) / 2;
            B = (b + d) / 2;
            C = (d - b) / 2;

            if(A-((a + c) / 2)!=0){
                System.out.println("No");
                break;
            }else if(B-((b + d) / 2)!=0||B-((c-a)/2)!=0){
                System.out.println("No");
                break;
            }else if(C-((d-b)/2)!=0){
                System.out.println("No");
                break;
            }
            System.out.println(A + " " + B + " " + C);
        }
    }
}
