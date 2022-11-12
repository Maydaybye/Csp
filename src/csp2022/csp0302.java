package csp2022;

import java.util.Scanner;

public class csp0302 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        int [][] tripPlan=new int[2][n];
        int[] query=new int[m];
        int satisfyNum=0;
        for(int i=0;i<n;i++){
            tripPlan[0][i]=scanner.nextInt();
            tripPlan[1][i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            query[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
//                if(query[i]+k>tripPlan[0][j]){
//                    break;
//                }
                if(query[i]+k<=tripPlan[0][j]&&tripPlan[0][j]<=query[i]+k+tripPlan[1][j]-1){
                    satisfyNum++;
                }
                System.out.println((query[i]+k)+" "+tripPlan[0][j]+" "+(query[i]+k+tripPlan[1][j]-1));
            }
            System.out.println(satisfyNum);
            satisfyNum=0;
        }
    }
}
