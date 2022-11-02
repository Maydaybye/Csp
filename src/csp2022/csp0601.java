package csp2022;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class csp0601 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        double[] record=new double[n];
        double ave,Da;
        double sumRecord=0;
        double sumDiff=0;
        for(int i=0;i<n;i++){
            record[i]=scanner.nextInt();
            sumRecord=sumRecord+record[i];
        }
        ave=sumRecord/n;
        for(int i=0;i<n;i++){
            sumDiff=sumDiff+(record[i]-ave)*(record[i]-ave);
        }
        Da=sumDiff/n;
        for(int i=0;i<n;i++){
            System.out.println((record[i]-ave)/sqrt(Da));
        }
    }
}
