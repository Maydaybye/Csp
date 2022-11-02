package csp2022;

import java.util.Arrays;
import java.util.Scanner;

public class csp0902_test {
    static int n;
    static int x;
    static Integer[] initBookPrice=new Integer[31];
    static Integer []accumulatePrice=new Integer[33];

    static int findMinimumPrice1(int begin,int temp,int[] a){
        if(begin>n){
            return (int)3e5;
        }
        temp=temp+a[begin];
        if(temp<x&&temp+accumulatePrice[n]-accumulatePrice[begin]>=x){
            int compare=(int)3e5;
            for(int i=begin;i<n+1;i++){
                if(compare>=findMinimumPrice1(i+1,temp,a)){
                    compare=findMinimumPrice1(i+1,temp,a);
                }
            }
            return compare;
        }
        else if(temp<x){
            return (int)3e5;

        }
        else{
            return temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        x=scanner.nextInt();
        int[] initBook1=new int[n+1];
//        Comparator<Integer> myComparator=new MyComparator();
        accumulatePrice[0]=0;
        for(int i=1;i<n+1;i++){
            initBook1[i]=initBookPrice[i]=scanner.nextInt();


        }
        Arrays.sort(initBook1);
        for(int i=1;i<n+1;i++){
            accumulatePrice[i]=accumulatePrice[i-1]+initBookPrice[i];
        }

        initBook1[0]=(int)0;
//        initBookPrice[0]=(int)3e5;
        Arrays.sort(initBook1);
        int compare=(int)3e5;
        for(int i=1;i<n+1;i++){
            if(compare>=findMinimumPrice1(i,0,initBook1)){
                compare=findMinimumPrice1(i,0,initBook1);
            }
        }
        System.out.println(compare);

    }
}
