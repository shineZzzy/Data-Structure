package Day4;

import java.util.Scanner;

/**
 * 删除字符串A中含有B串的元素
 * 先遍历A串，将a所有字符标记
 * 再遍历B串，若b串中有A串标记，跳过
 * 取ab标价不同的元素
 */
//They are students.
//aeiou

public class delete1 {
    public static void findC(String a,String b){

        StringBuilder str1= new StringBuilder();
        int index=0;
        for (int i=0;i<a.length();i++) {
            index++;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    index = 0;
                }
            }
            if (index!=0) {
                str1.append(a.charAt(i));
            }
        }
        System.out.println(str1);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            findC(a, b);
        }

    }
}
