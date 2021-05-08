package K;

public class T402_1 {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)       return "0";

        StringBuilder stack = new StringBuilder();
        int remains = num.length() - k;

        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > ch){
                stack.setLength(stack.length() - 1);
                k--;
            }
            if(ch == '0' && stack.length() == 0)    continue;

            stack.append(ch);
        }
        String res = stack.substring(0, stack.length() - k).toString();
        return res.length() == 0 ? "0" : res;
    }

}
