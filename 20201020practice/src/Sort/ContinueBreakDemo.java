package Sort;

public class ContinueBreakDemo {

    public static void main(String[] args) {
        for (int i = 0 ; i < 10; i++) {
            if (2 == i) {
                System.out.println("程序运行跳出标志！跳出循环！");
                break;
            }
            System.out.println("第" + i + "次循环。");
        }
        int count = 0 ;
        while (5 > count) { // 在5以内循环
            count++; // 自增1
            if (count % 3 == 0) { // 如果count是3的倍数，进行下一次循环
                continue;
            }
            System.out.println("第" + count + "次循环！");
        }

    }
}
