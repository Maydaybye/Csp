package csp2021;

import java.util.Scanner;

public class csp1201 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int N=scanner.nextInt();
        int[] A=new int[n+1];
        int sum=0;
        for(int i=1;i<n+1;i++){
            A[i]=scanner.nextInt();
            sum=sum+(i-1)*(A[i]-A[i-1]);
        }
        System.out.println(sum+(N-A[n])*n);
    }
}
