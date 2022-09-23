package csp2017;

import java.util.Scanner;

public class csp0902 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N,K;
        int temp=0;
        N=scanner.nextInt();
        K=scanner.nextInt();
        int[] keyBox= new int[N];
        //初始化钥匙盒
        for(int i=0;i<N;i++){
            keyBox[i]=i+1;
        }

        //初始化时间表
        int[] timeTable=new int[3*K];
        for(int i=0;i<K;i++){
            timeTable[3*i]=scanner.nextInt();
            timeTable[3*i+1]=scanner.nextInt();
            timeTable[3*i+2]=scanner.nextInt();
        }
        //把时间表按钥匙号从小到大排，以便实现同时还钥匙时的小号钥匙先还要求。
        //Bubble Sort
        for(int i=0;i<K;i++){
            int w,s,c;
            int count=0;
            for(int j=0;j<K-i-1;j++){
                if(timeTable[3*j]>timeTable[3*(j+1)]){
                    w=timeTable[3*(j+1)];
                    s=timeTable[3*(j+1)+1];
                    c=timeTable[3*(j+1)+2];
                    timeTable[3*(j+1)]=timeTable[3*j];
                    timeTable[3*(j+1)+1]=timeTable[3*j+1];
                    timeTable[3*(j+1)+2]=timeTable[3*j+2];
                    timeTable[3*j]=w;
                    timeTable[3*j+1]=s;
                    timeTable[3*j+2]=c;
                    count++;
                }
            }

            if(count==0)
            break;
        }
        //输出排序后的时间表。
//        for(int i=0;i<3*K;i++){
//            System.out.print(timeTable[i]+" ");
//        }

        //找出时间轴的时间上限
        for(int i=0;i<K;i++){
            if((timeTable[3*i+1]+timeTable[3*i+2])>temp)
                temp=timeTable[3*i+1]+timeTable[3*i+2];
        }
        //时间轴
        for(int i=0;i<=temp;i++){
            //还钥匙
            for(int j=0;j<K;j++){

                if(timeTable[(3*j+1)]+timeTable[(3*j+2)]==i){
                    //找钥匙盒中最靠左的空位置
                    for(int k=0;k<N;k++){
                        if(keyBox[k]==0){
                            keyBox[k]=timeTable[3*j];
                            break;

                        }

                    }
//                    System.out.println("当前钥匙盒的情况");
//                    for(int a=0;a<N;a++){
//
//                        System.out.print(+keyBox[a]);
//                    }
                }




            }
            //取钥匙
            for(int j=0;j<K;j++){

                if(timeTable[3*j+1]==i){
                    for(int k=0;k<N;k++){
                        if(keyBox[k]==timeTable[3*j])
                        keyBox[k]=0;
                    }
//                    System.out.println("当前钥匙盒的情况");
//                    for(int a=0;a<N;a++){
//
//                        System.out.print(+keyBox[a]);
//                    }

                }
            }


            }
        //从左往右输出钥匙盒中钥匙的号码
        for(int i=0;i<N;i++){
            System.out.print(keyBox[i]+" ");
        }


        }

}

