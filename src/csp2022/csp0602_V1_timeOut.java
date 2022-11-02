package csp2022;

import java.util.Scanner;

public class csp0602_V1_timeOut {
    static int countTreasureMapTree=0;//宝藏图中有几棵树
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int L=scanner.nextInt();
        int S=scanner.nextInt();
        int[][] greenFig=new int[2][n];//树坐标记录
        int[][] treasureMap=new int[S+1][S+1];//宝藏图记录
        int[][] positionRecorder=new int[2][S*S+2*S+1];//宝藏图树木相对位置记录
        int pointPairCounter=0;//当前位置下置完全匹配的树木个数
        int finalCount=0;//绿化图的子图中和宝藏图一致的数目
        int areaCount_1=0;
        for(int i=0;i<n;i++){
            greenFig[0][i]=scanner.nextInt();
            greenFig[1][i]=scanner.nextInt();
        }
        for(int i=S;i>=0;i--){
            for(int j=0;j<S+1;j++){
                treasureMap[i][j]=scanner.nextInt();
                if(treasureMap[i][j]==1){
                    positionRecorder[0][countTreasureMapTree]=i;
                    positionRecorder[1][countTreasureMapTree]=j;
                    countTreasureMapTree++;
                }
            }
        }
//        System.out.println("countTreasureMapTree:"+countTreasureMapTree);
        for(int i=0;i<=L-S;i++){
            for (int j=0;j<=L-S;j++){
                for(int k=0;k<n;k++){
                    if(greenFig[0][k]<=i+S&&greenFig[0][k]>=i&&greenFig[1][k]<=j+S&&greenFig[1][k]>=j){
                        areaCount_1++;
                    }
                }
//                System.out.println(areaCount_1);

                for(int l=0;l<n;l++){
                    for(int m=0;m<countTreasureMapTree;m++){
                        if(i+positionRecorder[0][m]==greenFig[0][l]&&j+positionRecorder[1][m]==greenFig[1][l]){
                            pointPairCounter++;
                            break;
                        }
                    }
                }
                if(pointPairCounter==countTreasureMapTree&&pointPairCounter==areaCount_1){
                    finalCount++;
                    pointPairCounter=0;
                }
                else{
                    pointPairCounter=0;
                }
                areaCount_1=0;
            }

        }
        System.out.println(finalCount);

    }

}
