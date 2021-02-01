package Test.Day31;

import java.util.*;
public class Main{
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        Stack<String> stack=new Stack<>();
        HashMap<String,Integer> map=new HashMap<>();
        while(s.hasNext()){
            String[] arr=s.nextLine().split("\\\\");
            String line=arr[arr.length-1];
            String l=line.split(" ")[0];
            String ll=line.split(" ")[1];
            l=l.length()>16 ? l.substring(l.length()-16):l;
            line=l+" "+ll;
            if(stack.contains(line)){
                map.put(line,map.get(line)+1);
            }else{
                stack.push(line);
                map.put(line,1);
            }
        }
        Stack<String> stack1=new Stack<>();
        int i=0;
        while(!stack.isEmpty()){
            if(i==8){
                break;
            }
            stack1.push(stack.peek()+" "+map.get(stack.pop()));
            i++;
        }
        while(!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
    }
}
