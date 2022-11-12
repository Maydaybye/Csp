/**
 * 利用时间的有序，反转匹配顺序，找到出核酸时间晚于进入场所时间的点，因为反转顺序后，后面的进入场所时间只会越来越早（小）所以直接break
 * 可惜收效甚微  还得是下面的V3
 */
package csp2022;

import java.util.Scanner;

public class csp0302_V2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        int [][] tripPlan=new int[2][n];
        int[] query=new int[m];
        int satisfyNum=0;
        int[] record=new int[m];
        for(int i=0;i<n;i++){
            tripPlan[0][i]=scanner.nextInt();
            tripPlan[1][i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            query[i]=scanner.nextInt();
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(query[i]+k>tripPlan[0][j]){
                    break;
                }
                if(query[i]+k<=tripPlan[0][j]&&tripPlan[0][j]<=query[i]+k+tripPlan[1][j]-1){
                    satisfyNum++;
                }
//                System.out.println((query[i]+k)+" "+tripPlan[0][j]+" "+(query[i]+k+tripPlan[1][j]-1));
            }
            record[i]=satisfyNum;
            satisfyNum=0;
        }
        for(int i=0;i<m;i++){
            System.out.println(record[i]);
        }
    }
}
