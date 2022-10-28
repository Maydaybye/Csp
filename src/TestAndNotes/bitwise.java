package TestAndNotes;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class bitwise {
    public static void main(String[] args) {
        //1101=13   0110=6   1010=10
        int a=13;//1101=13
        int b=-5;//1011=-5
        //注释全用补码表示
        System.out.println(a<<1);//0   11010=26
        System.out.println(b<<1);//1  10110=-10
        System.out.println(a>>1);//0  0110=6
        System.out.println(b>>1);//1  1101=-3
        System.out.println(a>>>1);//0   0110=6
        System.out.println(b>>>1);// 7FFFFFFD=2147483645


    }


}
