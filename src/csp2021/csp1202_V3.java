package csp2021;

import java.util.Scanner;

public class csp1202_V3 {

    static int cnt(int x,int r){
        if(x<r)
            return 0;
        return (0+x/r-1)*(x/r)/2*r+(x-x/r*r+1)*(x/r);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int N=scanner.nextInt();
        int r=N/(n+1);
        int[] A=new int[(int)(10e5+10)];
        long count=0;
        A[n+1]=N;
        for(int i=1;i<n+1;i++){
            A[i]=scanner.nextInt();
        }
        for(int i=0;i<=n;i++){
            if(A[i]<i*r){
                count+=i*(Math.min(i*r,A[i+1])-A[i])-cnt((Math.min(i*r,A[i+1])-1),r)+cnt(A[i]-1,r);
            }
            if(A[i+1]>i*r){
                count+=cnt(A[i+1]-1,r)-cnt(Math.max(i*r,A[i])-1,r)-i*(A[i+1]-Math.max(A[i],i*r));
            }
        }
        System.out.println(count);
    }
}
