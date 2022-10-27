package csp2019;

import java.util.HashSet;
import java.util.Scanner;

public class csp0901 {
    public static int min(int [] a){
        int min=0;
        for(int i=1;i<a.length;i++){
            if(a[min]>a[i]){
                min=i;
            }
        }
        return min;

    }
    public static void main(String[] args) {
        int N,M;
        int count=0;
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        M=scanner.nextInt();
        int[] vegetableNum= new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<M+1;j++){
                if(j==0){
                    count=count+scanner.nextInt();
                }
                if(j>0){
                    vegetableNum[i]=vegetableNum[i]+scanner.nextInt();
                }

            }
            count=count+vegetableNum[i];
        }
        System.out.print(count+" "+(min(vegetableNum)+1)+" "+(-vegetableNum[min(vegetableNum)]));


    }
}
