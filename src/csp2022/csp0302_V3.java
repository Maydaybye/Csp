package csp2022;

import java.util.Scanner;

public class csp0302_V3 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        int ti,ci;
        int[] timeLine=new int[(int)3e5+10];
        int[] require=new int[m+1];
        for(int i=1;i<n+1;i++){
            ti=scanner.nextInt();
            ci=scanner.nextInt();
            int left=ti-ci+1>0?ti-ci+1:1;
            int right=ti;
            timeLine[left]++;
            timeLine[right+1]--;
        }

        for(int i=1;i<(int)3e5+10;i++){              //for循环在这里像一个记录员，记录着包含当前位置的区间（靠+1记录），每当有区间结束就会在下一个位置-1
                                                     //这样当循环走完，就记录了每个位置，在多少个区间之中。
            timeLine[i]=timeLine[i]+timeLine[i-1];
        }

        for(int i=1;i<m+1;i++){
            require[i]=scanner.nextInt();
        }

        for(int i=1;i<m+1;i++){
            System.out.println(timeLine[require[i]+k]);
        }
    }
}
