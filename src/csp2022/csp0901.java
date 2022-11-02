package csp2022;

import java.util.Scanner;

public class csp0901 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int ci=1;
        int[] ai=new int[n];
        int temp=0;
        int lastTemp=0;
        int lastCi=1;
        for(int i=0;i<n;i++){
            ai[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){

            ci=ci*ai[i];
            temp=m%ci;
            System.out.print((temp-lastTemp)/lastCi+" ");
            lastTemp=temp;
            lastCi=ci;


        }

    }
}
