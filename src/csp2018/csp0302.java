package csp2018;

import java.util.Scanner;

public class csp0302 {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        //小球个数
        int n=scanner.nextInt();
        //轨道长度
        int L=scanner.nextInt();
        //运行时长
        int t=scanner.nextInt();
        //位置记录数组
        int[] position=new int[n];
        //行进方向标记
        boolean[] faceTo=new boolean[n];
        //初始位置赋值
        for(int i=0;i<n;i++){
            position[i]=scanner.nextInt();
        }
        //初始化行进方向
        for(int i=0;i<n;i++){
            faceTo[i]=true;
        }
        //时间轴
        for(int i=0;i<t;i++){
            //移动
            for(int j=0;j<n;j++){
                //改变遇到碰撞时行进方向的标记
                for(int k=j+1;k<n;k++){
                    if(position[j]==position[k]){
                        faceTo[j]=!faceTo[j];
                        faceTo[k]=!faceTo[k];
                        break;
                    }
                }
                //改变遇到边界时行进方向的标记，并反向移动
                if(position[j]==L){
                    faceTo[j]=!faceTo[j];
                    position[j]=position[j]-1;
                    continue;
                }
                //改变遇到边界时行进方向的标记，并反向移动
                if(position[j]==0){
                    faceTo[j]=!faceTo[j];
                    position[j]=position[j]+1;
                    continue;
                }


                //按照标记方向行进
                if(position[j]<L&&faceTo[j]==true){
                    position[j]=position[j]+1;
                }
                //按照标记方向行进
                if(position[j]>0&&faceTo[j]==false){
                    position[j]=position[j]-1;
                }



            }
//            System.out.println("每一秒球的变化");
//            for(int l=0;l<n;l++){
//                System.out.print(position[l]+" ");
//            }
//            System.out.println("\n");
        }
        for(int i=0;i<n;i++){
            System.out.print(position[i]+" ");
        }

    }
}
