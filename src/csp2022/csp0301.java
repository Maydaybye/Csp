package csp2022;

import java.util.HashSet;
import java.util.Scanner;

public class csp0301 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[][] record=new int[2][k];
        int countNotInitialized=0;
        HashSet<Integer> leftValue=new HashSet<>();
        leftValue.add(0);
        for(int i=0;i<k;i++){
            record[0][i]=scanner.nextInt();
            record[1][i]=scanner.nextInt();
            if(!leftValue.contains(record[1][i])){
                countNotInitialized++;
            }
            leftValue.add(record[0][i]);
        }
        System.out.println(countNotInitialized);
    }
}
