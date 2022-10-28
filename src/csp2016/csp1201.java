/**
 * 最保险的就是把所有情况想完
 */
package csp2016;

import java.util.Arrays;
import java.util.Scanner;

public class csp1201 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int count=0;
        int[] record=new int[n];
        int check=0;
        for(int i=0;i<n;i++){
            record[i]=scanner.nextInt();

        }
        Arrays.sort(record);
//        for(int a:record){
//            System.out.print(a);
//        }
        if(n%2!=0){
            check=record[n/2];
            for(int i=0;i<n;i++){
                if(record[i]==check){
                    count++;
                }
            }
            if(count%2==0){
                System.out.println(-1);
            }
            else{
                System.out.println(check);
            }
        }
        else{
            if(record[n/2-1]==record[n/2]) {
                check=record[n/2-1];
                for(int i=0;i<n;i++){
                    if(record[i]==check){
                        count++;
                    }
                }
                if(count%2==0){
                    System.out.println(check);
                }
                else{
                    System.out.println(-1);
                }
            }
            else{
                System.out.println(-1);
            }



        }

    }
}
