package csp2018;

import java.util.Scanner;

public class csp0901 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] today=new int[n];
        int[] tomorrow=new int[n];
        for(int i=0;i<n;i++){
            today[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            if(i-1<0){
                tomorrow[i]=(today[0]+today[1])/2;
                continue;
            }
            if(i+1==n){
                tomorrow[i]=(today[i]+today[i-1])/2;
                continue;

            }
            tomorrow[i]=(today[i-1]+today[i]+today[i+1])/3;

        }
        for(int i=0;i<n;i++){
            System.out.print(tomorrow[i]+" ");
        }
    }
}
