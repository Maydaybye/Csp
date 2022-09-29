package csp2018;

import java.util.Scanner;

public class csp1201 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int r=scanner.nextInt();
        int y=scanner.nextInt();
        int g=scanner.nextInt();
        int n=scanner.nextInt();
        int[] record=new int[2*n];
        int countTime=0;
        for(int i=0;i<2*n;i++){
            record[i]=scanner.nextInt();

        }
        for(int i=0;i<2*n;i=i+2){
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
