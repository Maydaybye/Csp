package TestAndNotes;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;

public class k_means {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 3;

        double[][] dataSet = {{0.697, 0.774, 0.634, 0.608, 0.556, 0.403, 0.481, 0.437, 0.666,
                0.243, 0.245, 0.343, 0.639, 0.657, 0.360, 0.593, 0.719,0.359,0.339,0.282,0.748, 0.714,
                0.483, 0.478, 0.525, 0.751, 0.532, 0.473,0.725,0.446},
                {0.460, 0.376, 0.264, 0.318, 0.215, 0.237, 0.149, 0.211, 0.091, 0.267, 0.057, 0.099, 0.161, 0.198, 0.370,
                        0.042, 0.103, 0.188, 0.241, 0.257, 0.232, 0.346, 0.312, 0.437, 0.369, 0.489, 0.472, 0.376, 0.445, 0.459}};


        int n1, n2, n3;
        double temp1, temp2, temp3;

        n1 = random.nextInt(29);
        n2 = random.nextInt(29);
        n3 = random.nextInt(29);

        ArrayList<Integer> C1 = new ArrayList<>();
        ArrayList<Integer> C2 = new ArrayList<>();
        ArrayList<Integer> C3 = new ArrayList<>();
        double[][] aveVector1 = new double[2][1];


        double[][] aveVector2 = new double[2][1];

        double[][] aveVector3 = new double[2][1];

        double[][] aveVector11 = new double[2][1];
        double[][] aveVector22 = new double[2][1];
        double[][] aveVector33 = new double[2][1];
        aveVector1[0][0]=dataSet[0][n1];
        aveVector1[1][0]=dataSet[1][n1];
        aveVector2[0][0]=dataSet[0][n2];
        aveVector2[1][0]=dataSet[1][n2];
        aveVector3[0][0]=dataSet[0][n3];
        aveVector3[1][0]=dataSet[1][n3];
        while (aveVector11[0][0]!=aveVector1[0][0]&&aveVector11[1][0]!=aveVector1[1][0]&&
                aveVector22[0][0]!=aveVector2[0][0]&&aveVector22[1][0]!=aveVector2[1][0]&&
                aveVector33[0][0]!=aveVector3[0][0]&&aveVector33[1][0]!=aveVector3[1][0]) {
            aveVector11[0][0] = aveVector1[0][0];
            aveVector11[1][0] = aveVector1[1][0];
            aveVector22[0][0] = aveVector2[0][0];
            aveVector22[1][0] = aveVector2[1][0];
            aveVector33[0][0] = aveVector3[0][0];
            aveVector33[1][0] = aveVector3[1][0];


            C1.clear();
            C2.clear();
            C3.clear();
            for (int i = 0; i < 30; i++) {


                temp1 = sqrt((aveVector1[0][0] - dataSet[0][i]) * (aveVector1[0][0] - dataSet[0][i]) +
                        (aveVector1[1][0] - dataSet[1][i]) * (aveVector1[1][0] - dataSet[1][i]));
                temp2 = sqrt((aveVector2[0][0] - dataSet[0][i]) * (aveVector2[0][0] - dataSet[0][i]) +
                        (aveVector2[1][0] - dataSet[1][i]) * (aveVector2[1][0] - dataSet[1][i]));
                temp3 = sqrt((aveVector3[0][0] - dataSet[0][i]) * (aveVector3[0][0] - dataSet[0][i]) +
                        (aveVector3[1][0] - dataSet[1][i]) * (aveVector3[1][0] - dataSet[1][i]));



                if (temp1 < temp2) {
                    if (temp1 < temp3) {
                        C1.add(i);
                    } else {
                        C3.add(i);
                    }
                } else {
                    if (temp2 < temp3) {
                        C2.add(i);
                    } else {
                        C3.add(i);
                    }
                }


            }

            double sum = 0;

            //1
            for (int j = C1.size(); j > 0; j--) {
                sum = sum + dataSet[0][C1.get(j-1)];
            }
            aveVector1[0][0] = sum / C1.size();
            sum = 0;
            for (int j = C1.size(); j > 0; j--) {
                sum = sum + dataSet[1][C1.get(j-1)];
            }
            aveVector1[1][0] = sum / C1.size();
            //2
            sum = 0;
            for (int j = C2.size(); j > 0; j--) {
                sum = sum + dataSet[0][C2.get(j-1)];
            }
            aveVector2[0][0] = sum / C2.size();
            sum = 0;
            for (int j = C2.size(); j > 0; j--) {
                sum = sum + dataSet[1][C2.get(j-1)];
            }
            aveVector2[1][0] = sum / C2.size();
            //3
            sum = 0;
            for (int j = C3.size(); j > 0; j--) {
                sum = sum + dataSet[0][C3.get(j-1)];
            }
            aveVector3[0][0] = sum / C3.size();
            sum = 0;
            for (int j = C3.size(); j > 0; j--) {
                sum = sum + dataSet[1][C3.get(j-1)];
            }

            aveVector3[1][0] = sum / C3.size();



        }
        System.out.println("簇C1:");
        for (int j = C1.size(); j > 0; j--) {
            System.out.println("编号："+(C1.get(j-1)+1)+" 密度："+dataSet[0][C1.get(j-1)]+" 含糖度："+dataSet[1][C1.get(j-1)]+" ");

        }
        System.out.println();
        System.out.println("簇C2:");
        for (int j = C2.size(); j > 0; j--) {
            System.out.println("编号："+(C2.get(j-1)+1)+" 密度："+dataSet[0][C2.get(j-1)]+" 含糖度："+dataSet[1][C2.get(j-1)]+" ");

        }
        System.out.println();
        System.out.println("簇C3:");

        for (int j = C3.size(); j > 0; j--) {
            System.out.println("编号："+(C3.get(j-1)+1)+" 密度："+dataSet[0][C3.get(j-1)]+" 含糖度："+dataSet[1][C3.get(j-1)]+" ");

        }

    }
}
