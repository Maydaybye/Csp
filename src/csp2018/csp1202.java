
/**
 * 这种解法把灯的变化都记录了下来，消耗大量时间。实验过多次，结果正确但是csp上分数只有2分
 * 推测csp的评分标准会充分考虑算法的优化，以后在做题的时候不能随便想到个方法就上，先优化好再写
 * 这次的写法写了有3h以上  不仅写的慢  算法效率还低
 * 小结：
 * 1.记得多测试几个例子
 * 2.先想好，再动手，不要想到哪里写到哪里。
 *
 */
package csp2018;

import java.util.Scanner;

public class csp1202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int y = scanner.nextInt();
        int g = scanner.nextInt();
        int n = scanner.nextInt();
        int[] record = new int[2 * n];
        int countTime = 0;
        for (int i = 0; i < 2 * n; i++) {
            record[i] = scanner.nextInt();
        }
        for (int i = 0; i < 2 * n; i = i + 2) {
            if(record[i]==3){
                continue;
            }
            for(int j=i+2;j<2*n;j=j+2){
                if(record[j]==0){
                    continue;
                }
                if(record[j]==1){
                    if(record[i+1]<record[j+1]){
                        record[j+1]=record[j+1]-record[i+1];
                        continue;
                    }

                    if((record[i+1]-record[j+1])%(r+g+y)<g){
                        record[j]=3;
                        record[j+1]=g-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>=g&&(record[i+1]-record[j+1])%(r+g+y)<g+y){
                        record[j]=2;
                        record[j+1]=y+g-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>=g+y){
                        record[j]=1;
                        record[j+1]=(r+g+y)-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                }
                if(record[j]==2){
                    if(record[i+1]<record[j+1]){
                        record[j+1]=record[j+1]-record[i+1];
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)<=r){
                        record[j]=1;
                        record[j+1]=r-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>r&&(record[i+1]-record[j+1])%(r+g+y)<r+g){
                        record[j]=3;
                        record[j+1]=r+g-(record[i+1]-record[j+1])%63;
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>=r+g){
                        record[j]=2;
                        record[j+1]=(r+g+y)-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                }
                if(record[j]==3){
                    if(record[i+1]<record[j+1]){
                        record[j+1]=record[j+1]-record[i+1];
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)<=y){
                        record[j]=2;
                        record[j+1]=y-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>y&&(record[i+1]-record[j+1])%(r+g+y)<y+r){
                        record[j]=1;
                        record[j+1]=y+r-(record[i+1]-record[j+1])%(r+g+y);
                        continue;
                    }
                    if((record[i+1]-record[j+1])%(r+g+y)>=y+r){
                        record[j]=3;
                        record[j+1]=(r+g+y)-(record[i+1]-record[j+1])%(r+g+y);

                    }
                }



            }

            if(record[i]==0){
                countTime=countTime+record[i+1];
            }
            if(record[i]==1){
                countTime=countTime+record[i+1];
            }
            if(record[i]==2){
                countTime=countTime+record[i+1]+r;
            }



        }
        System.out.println(countTime);
    }
}
