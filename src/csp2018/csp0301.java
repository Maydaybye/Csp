package csp2018;
/**
 * 自己多测试几个用例，太容易错。
 * 自己多测试几个用例，太容易错。
 * 自己多测试几个用例，太容易错。
 * 自己多测试几个用例，太容易错。
 */

import java.util.Scanner;

public class csp0301 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int num=1;
        int lastNum=0;
        int score=0;
        int accumulate=0;
        boolean flag=false;
        while(num!=0){
            lastNum=num;
            num=scanner.nextInt();
            if(flag==false&&num==2){
                score=score+2;
                accumulate=2;
                flag=true;
                continue;
            }
            if(flag==false&&num==1){
                score=score+1;
                flag=true;
                continue;
            }
            if(lastNum==1&&num==2){
                score=score+2;
                accumulate=2;
            }
            if(lastNum==2&&num==2){
                accumulate=accumulate+2;
                score=score+accumulate;
            }
            if(num==1){
                score=score+1;
                accumulate=0;
            }




        }
        System.out.println(score);
    }
}
