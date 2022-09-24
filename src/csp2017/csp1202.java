package csp2017;
/**
 * 小结：
 * 第一次提交可以得到正确的结果。
 * 但超时了，因为需要检测大量的已经被淘汰了的存储0的下标。
 * 在淘汰倒数第二个小孩时马上退出最多只能减少n次循环
 * 但就是这n次循环使时间减少了90%
 * 只能解释为循环一次就淘汰至剩一人几乎是必然事件，要不然就是csp检查系统为了考察考生优化代码的意识，故意在退出循环的时机上加了测试点
 * 总之能优化的就优化，不然会丢分。
 *
 *
 */

import java.util.Scanner;

public class csp1202 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int num,onePlace;

        int[] friends=new int[n];

        num=1;
        //left用来标识还剩多少小朋友
        int left=n;
        for(int i=0;i<n;i++){
            friends[i]=1;
        }

        while(left!=1){

            for(int i=0;i<n;i++){

                if(friends[i]==0){
                    continue;
                }





                    onePlace=num;
                    if(onePlace>10){
                        onePlace=onePlace%10;
                    }
                    if(num%k==0||onePlace==k){
                        left--;
                        friends[i]=0;
                    }
                    if(left==1)
                        break;
                    num++;




            }




        }
        for(int i=0;i<n;i++){
            if(friends[i]!=0){
                System.out.println(i+1);
            }
        }

    }
}
