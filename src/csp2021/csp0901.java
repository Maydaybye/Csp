package csp2021;

import java.util.Scanner;

public class csp0901 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int sum1=0;
        int sum2=0;
        int[] B=new int[n];
        for(int i=0;i<n;i++){
            B[i]=scanner.nextInt();
        }
        sum1=B[0];
        sum2=B[0];
        for(int i=1;i<n;i++){
            sum1+=B[i];
            sum2+=B[i];
            if(B[i]<=B[i-1]){
                sum2-=B[i];
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);

    }
}
