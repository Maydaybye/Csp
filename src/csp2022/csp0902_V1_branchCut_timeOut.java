package csp2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class csp0902_V1_branchCut_timeOut {
    static int n;
    static int x;
    static Integer[] initBookPrice=new Integer[31];
    static Integer []accumulatePrice=new Integer[33];
    static int findMinimumPrice(int begin,int temp){
        if(begin>n){
            return (int)3e5;
        }
        temp=temp+initBookPrice[begin];
        if(temp<x&&temp+accumulatePrice[n]-accumulatePrice[begin]>=x){
            int compare=(int)3e5;
            for(int i=1;i<n+1;i++){
                if(compare>=findMinimumPrice(i+1,temp)){
                    compare=findMinimumPrice(i+1,temp);
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
    static int findMinimumPrice1(int begin,int temp,int[] a){
        if(begin>n){
            return (int)3e5;
        }
        temp=temp+a[begin];
        if(temp<x&&temp+accumulatePrice[n]-accumulatePrice[begin]>=x){
            int compare=(int)3e5;
            for(int i=1;i<n+1;i++){
                if(compare>=findMinimumPrice(i+1,temp)){
                    compare=findMinimumPrice(i+1,temp);
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
        int[] initBook1=new int[31];
//        Comparator<Integer> myComparator=new MyComparator();
        accumulatePrice[0]=0;
        for(int i=1;i<n+1;i++){
            initBook1[i]=initBookPrice[i]=scanner.nextInt();
            accumulatePrice[i]=accumulatePrice[i-1]+initBookPrice[i];
        }
//        initBookPrice[0]=(int)3e5;
//        Arrays.sort(initBookPrice,myComparator);
        int compare=(int)3e5;
        for(int i=1;i<n+1;i++){
            if(compare>=findMinimumPrice1(i,0,initBook1)){
                compare=findMinimumPrice1(i,0,initBook1);
            }
        }
        System.out.println(compare);

    }
}
//class MyComparator implements Comparator<Integer> {
//
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        if(o1 > o2) // 默认是o1 < o2时返回-1， 一下同理
//            return -1;
//        if(o1 < o2)
//            return 1;
//        return 0;
//    }
//}
