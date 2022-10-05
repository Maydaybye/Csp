/**
 * 漏掉了连续减法的情况，直接扣了70分，要严谨
 * 改了一下午
 */
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
            for(int i=0;i<n;i++) {
                while (index < input[i].length()) {
                    if (input[i].charAt(index) <= '9' && input[i].charAt(index) >= '0') {
                        numStack.push(parseInt(input[i].substring(index, index + 1)));
                    }
                    else if(input[i].charAt(index)=='+'){
                        opeStack.push(input[i].charAt(index));
                    }
                    else if(input[i].charAt(index)=='-'){
                        opeStack.push(input[i].charAt(index));
                        numStack.push(-parseInt(input[i].substring(index+1,index+2)));
                        index++;
                    }
                    else if(input[i].charAt(index)=='x'){
                        numStack.push(numStack.pop()*parseInt(input[i].substring(index+1,index+2)));
                        index++;
                    }
                    else {
                        numStack.push(numStack.pop()/parseInt(input[i].substring(index+1,index+2)));
                        index++;
                    }
                    index++;
                }
                int sum=0;
                while(!numStack.isEmpty()){






                            sum+=numStack.pop();


                }
                index=0;

                if(sum==24){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }



    }
}
