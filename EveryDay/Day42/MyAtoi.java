package Test.Day42;

public class MyAtoi {
    public static int myAtoi(String str) {
        int len=str.length();
        char[] c=str.toCharArray();

        //1.空格处理
        int index=0;
        while (index<len && c[index]==' '){
            index++;
        }
        //考虑极端情况，如果全为空格？
        if (index==len){
            return 0;
        }
        //字符处理=正负+非数字
        int sign=1;//标志位
        char f=c[index];//前面处理了空格，此处index位置已是非空格元素
        if (f=='+'){
            index++;
        }else if (f=='-'){
            //如果为‘-’号，继续走，并将标志位修改
            index++;
            sign=-1;
        }

        //数字处理=转换+防溢出
        int res=0;
        while (index<len){
            char curr=c[index];
            //判断字符合法否？
            if (curr<'0' || curr>'9'){
                break;
            }

            //判断溢出否？
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE /10  && (curr-'0')>Integer.MAX_VALUE %10)){
                return Integer.MAX_VALUE;
            }
            if (res<Integer.MIN_VALUE /10 || (res == Integer.MIN_VALUE /10 && (curr-'0')>-(Integer.MIN_VALUE %10)) ){
                return Integer.MIN_VALUE;
            }
            //字符转换数字
            //每一位数字转换后下标左移，并且将符号位乘进去?
            res = res * 10+sign*(curr-'0');
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "   -42";
//        int res = myAtoi(str);
//        System.out.println(res);
        double d=Math.cos(42);
        double c=Math.cos(Math.toDegrees(42));
        double f=Math.cos(Math.toRadians(42));
        System.out.println(d);
        System.out.println(c);
        System.out.println(f);


    }

}
