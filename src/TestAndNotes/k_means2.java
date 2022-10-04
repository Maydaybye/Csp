package TestAndNotes;
//有时候出结果很慢，可能是在更新均值向量的过程中一直找不到固定的簇分类，因为最初随机的均值向量可能会使迭代过程一直进行。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.sqrt;

public class k_means2 {
    public static final int N =7;//簇数
    public static void main(String[] args) {
        Random random = new Random();

        double[][] dataSet = {{0.697, 0.774, 0.634, 0.608, 0.556, 0.403, 0.481, 0.437, 0.666,
                0.243, 0.245, 0.343, 0.639, 0.657, 0.360, 0.593, 0.719,0.359,0.339,0.282,0.748, 0.714,
                0.483, 0.478, 0.525, 0.751, 0.532, 0.473,0.725,0.446},
                {0.460, 0.376, 0.264, 0.318, 0.215, 0.237, 0.149, 0.211, 0.091, 0.267, 0.057, 0.099, 0.161, 0.198, 0.370,
                        0.042, 0.103, 0.188, 0.241, 0.257, 0.232, 0.346, 0.312, 0.437, 0.369, 0.489, 0.472, 0.376, 0.445, 0.459}};

        int n;
        double temp=1;
        boolean flag=true;

        ArrayList<Integer> initSample = new ArrayList<>();

        HashMap<Integer,Integer> clusterRecorder=new HashMap<>();
        double[][] tempArray= new double[2][N];

        for (int i = 0; i < N; i++) {
            initSample.add(random.nextInt(29));
        }
        System.out.println("选取的"+N+"个初始均值向量是：");
        for(int i=0;i<N;i++){
            System.out.println("密度："+dataSet[0][initSample.get(i)]+" 含糖度："+dataSet[1][initSample.get(i)]);
        }

        for(int i=0;i<N;i++){
            tempArray[0][i]=dataSet[0][initSample.get(i)];
            tempArray[1][i]=dataSet[1][initSample.get(i)];
        }



        while (flag) {
            flag=false;

            for (int i = 0; i < 30; i++) {
                int min = 0;
                temp = 10;
                for (int j = 0; j < N; j++) {


                    if (temp > sqrt((tempArray[0][j] - dataSet[0][i]) * (tempArray[0][j] - dataSet[0][i]) +
                            (tempArray[1][j] - dataSet[1][i]) * (tempArray[1][j] - dataSet[1][i]))) {
                        temp = sqrt((tempArray[0][j] - dataSet[0][i]) * (tempArray[0][j] - dataSet[0][i]) +
                                (tempArray[1][j] - dataSet[1][i]) * (tempArray[1][j] - dataSet[1][i]));
                        min = j;


                    }


                }
                clusterRecorder.put(i, min);//存到对应的簇中


            }


            //计算新的均值向量。
            int count=0;
            double sum1=0;
            double sum2=0;
            for(int i=0;i<N;i++){

                for(int j=0;j<30;j++){


                    if(clusterRecorder.get(j)==i){
                        count++;
                        sum1=sum1+dataSet[0][j];
                        sum2=sum2+dataSet[1][j];
                    }

                }


                if((sum1/count)!=tempArray[0][i]||(sum2/count)!=tempArray[1][i]){
                    flag=true;
                    tempArray[0][i]=sum1/count;
                    tempArray[1][i]=sum2/count;
                }

                count=0;
                sum1=0;
                sum2=0;
            }




        }
        System.out.println("-------------------");


            for (int i = 0; i < N; i++) {
                System.out.println("簇" + (i+1) + " :");
                for (int j = 0; j < 30; j++) {
                    if (clusterRecorder.get(j) == i) {
                        System.out.println("编号：" + (j + 1 )+ " 密度：" + dataSet[0][j] + " 含糖度：" + dataSet[1][j] + " ");
                    }
                }


            }
        System.out.println("-------------------");



    }
}
