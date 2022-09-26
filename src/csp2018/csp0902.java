package csp2018;

import java.util.Scanner;

public class csp0902 {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int[] loadH=new int[2*n];
        int[] loadW=new int[2*n];
        int chatTime=0;
        for(int i=0;i<2*n;i++){
            loadH[i]=scanner.nextInt();
        }
        for(int i=0;i<2*n;i++){
            loadW[i]=scanner.nextInt();
        }
        for(int i=0;i<n*2;i=i+2){
            for(int j=0;j<n*2;j=j+2){
                if(loadH[i+1]<=loadW[j])
                    break;
                if(loadH[i]>=loadW[j+1])
                    continue;
                if(loadH[i]<loadW[j]&&loadH[i+1]>loadW[j]){
//                    System.out.print(loadH[i]+" ");
//                    System.out.print(loadH[i+1]+" ");
//                    System.out.print(loadW[j]+" ");
//                    System.out.print(loadW[i+1]+" ");
                    if(loadH[i+1]>loadW[j+1]){
                        chatTime=chatTime+loadW[j+1]-loadW[j];
                    }
                    else{
                        chatTime=chatTime+loadH[i+1]-loadW[j];
                    }
//                    System.out.println("当前聊了多长时间:"+chatTime);
                    continue;
                }
                if(loadH[i]>=loadW[j]){
//                    System.out.print(loadH[i]+" ");
//                    System.out.print(loadH[i+1]+" ");
//                    System.out.print(loadW[j]+" ");
//                    System.out.print(loadW[i+1]+" ");
                    if(loadH[i+1]<=loadW[j+1]){
                        chatTime=chatTime+loadH[i+1]-loadH[i];
                    }
                    else{
                        chatTime=chatTime+loadW[j+1]-loadH[i];
                    }
//                    System.out.println("当前聊了多长时间:"+chatTime);
                }
//                System.out.println("当前聊了多长时间:"+chatTime);
            }
        }
        System.out.println(chatTime);

    }
}
