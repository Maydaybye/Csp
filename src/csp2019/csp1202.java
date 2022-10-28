package csp2019;

import java.util.Scanner;

public class csp1202 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] record =new int[2][n];
        int checkX=0;
        int checkY=0;
        int judgeRecycleBin;//判断回收站
        int judgeScore;//判断得分
        boolean[] recycleBin=new boolean[n];
        int[] scoreRecord=new int[5];
        /**
         * 输入垃圾位置
         */
        for(int i=0;i<n;i++){
            record[0][i]=scanner.nextInt();
            record[1][i]=scanner.nextInt();
        }
        /**
         * 判断回收站点
         */
        for(int i=0;i<n;i++){
            judgeRecycleBin=0;
            checkX=record[0][i];
            checkY=record[1][i];
            for(int j=0;j<n;j++){
                if(j==i){
                    continue;
                }
                if(checkY==record[1][j]){
                    if(checkX+1==record[0][j]){
                        judgeRecycleBin++;
                    }
                    if(checkX-1==record[0][j]){
                        judgeRecycleBin++;
                    }
                }
                if(checkX==record[0][j]){
                    if(checkY+1==record[1][j]){
                        judgeRecycleBin++;
                    }

                    if(checkY-1==record[1][j]){
                        judgeRecycleBin++;
                    }
                }

            }
            if(judgeRecycleBin==4){
                recycleBin[i]=true;
            }
        }
//        for(boolean i:recycleBin){
//            System.out.print(i+" ");
//        }//输出回收站
        /**
         * 判断得分
         */
        for(int i=0;i<n;i++){
            judgeScore=0;
            if(recycleBin[i]==false){
                continue;
            }
            for(int j=0;j<n;j++){
                if(record[0][i]-1==record[0][j]){
                    if(record[1][i]+1==record[1][j]||record[1][i]-1==record[1][j]){
                        judgeScore++;
                    }
                }
                if(record[0][i]+1==record[0][j]){
                    if(record[1][i]+1==record[1][j]||record[1][i]-1==record[1][j]){
                        judgeScore++;
                    }
                }


            }
            scoreRecord[judgeScore]++;
        }
        /**
         * 输出结果
         */
        for(int i:scoreRecord){
            System.out.println(i);
        }


    }
}
