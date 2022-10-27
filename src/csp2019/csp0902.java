package csp2019;

import java.util.Scanner;

public class csp0902 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N=scanner.nextInt();
        int count=0;  //苹果统计
        int dropCount=0; //掉落统计
        int continuationGroup=0;  //连续掉落苹果组数
        boolean[] ifDrop=new boolean[N];
        int[] currentAppleNum=new int[N];
        for(int i=0;i<N;i++){
            int operateCount=scanner.nextInt();
            for(int j=0;j<operateCount;j++){
                if(j==0){
                    currentAppleNum[i]=currentAppleNum[i]+scanner.nextInt();
                }
                if(j>0){
                    int operate=scanner.nextInt();
                    if(operate>0){
                        if(currentAppleNum[i]!=operate){
                            currentAppleNum[i]=operate;
                            ifDrop[i]=true;
                        }
                    }
                    else{
                        currentAppleNum[i]=currentAppleNum[i]+operate;
                    }
                }

            }
            count=count+currentAppleNum[i];

        }
        /**
         * 掉落棵树与连续掉落组数统计
         */
        for(int i=0;i<N;i++){
            if(ifDrop[i]==true){
                dropCount++;
            }
            if(ifDrop[(i+N)%N]==true&&ifDrop[(i+N-1)%N]==true&&ifDrop[(i+N+1)%N]==true){
                continuationGroup++;
            }
        }
        System.out.println(count+" "+dropCount+" "+continuationGroup);
    }
}
