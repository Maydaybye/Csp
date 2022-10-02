package csp2019;
/**
 * 第一次输出的时候使用了大量选择分支。扣了20分
 * 第二次很简洁。给了满分。
 * 说明csp是会对冗余的步骤扣分的。
 */

import java.util.Scanner;

public class csp0301 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int mid1;
        float max,min;
        float mid;
        float[] array=new float[n];
        for(int i=0;i<n;i++){
            array[i]=scanner.nextInt();
        }
        if (n%2==0&&n>2){
            mid=Math.round((array[n/2-1]+array[n/2])/2*10)*0.1f;

        }

        else if(n%2==0){
            mid=Math.round((array[0]+array[1])/2*10)*0.1f;

        }
        else{
            mid=array[n/2];
        }
        if(array[0]<array[n-1]){
            min=array[0];
            max=array[n-1];

        } else if (array[0]>array[n-1]) {
            min=array[n-1];
            max=array[0];
        }else{

            min=max=array[0];

            }
        //输出格式


        if(mid%1==0){
            System.out.printf("%.0f %.0f %.0f",max,mid,min);
        }
        else{
            System.out.printf("%.0f %.1f %.0f",max,mid,min);
        }






    }
}
