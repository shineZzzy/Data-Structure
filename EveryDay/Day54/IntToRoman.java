package EveryDay.offer.String;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public String intToRoman(int num) {
        Map<Integer,String>map=new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        while (num>0){
            if (num>1000){
                int c=num%1000;


            }else if (num>100 && num<1000){

            }else {

            }
        }
    }
}
