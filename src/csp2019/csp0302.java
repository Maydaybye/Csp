package csp2019;

import java.util.*;

import static java.lang.Integer.parseInt;


public class csp0302 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> opeStack=new Stack<>();
        int n=scanner.nextInt();
        int index=0;
        String[] input=new String[n];
        for(int i=0;i<n;i++){
            input[i]=scanner.next();
        }
        scanner.close();

        //计算

            for(int i=0;i<n;i++) {
                while (index < input[index].length()) {
                    //如果是数字
                    if (input[i].charAt(index) <= '9' && input[i].charAt(index) >= '0') {
                        numStack.push(parseInt(input[i].substring(index, index + 1)));
                    } else {
                        opeStack.push(input[i].charAt(index));
                    }

                    index++;
                }
                //输出第i次的判断结果。

                //下一行输入，index要从0开始入栈。
                index=0;
            }









    }
}
