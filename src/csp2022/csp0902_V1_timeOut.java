package csp2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class csp0902_V1_timeOut  {
    static int n,x;
    static int[] accumulatePrice=new int[33];
    static public int findMinimumPrice(int begin,int bookNum,int temp,int transferLimit,Integer[] initBooks){
        if(begin>bookNum){
            return temp;
        }
        temp=temp+initBooks[begin];
        if(temp<transferLimit&&temp+accumulatePrice[bookNum]-accumulatePrice[begin]>=transferLimit){
            int compare=2147483647;
            for(int i=begin+1;i<=bookNum;i++){
                if(i==begin+1&&findMinimumPrice(i,bookNum,temp,transferLimit,initBooks)>=transferLimit){
                    compare=findMinimumPrice(i,bookNum,temp,transferLimit,initBooks);
                    continue;
                }
                if(compare>findMinimumPrice(i,bookNum,temp,transferLimit,initBooks)&&findMinimumPrice(i,bookNum,temp,transferLimit,initBooks)>=transferLimit){
                    compare=findMinimumPrice(i,bookNum,temp,transferLimit,initBooks);
                }
            }
            return compare;
        }
        else if(temp<x){
            return 2147483647;
        }
        else return temp;
    }
    public static void main (String[] args) {



        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        x=scanner.nextInt();
        Integer[] initBooks=new Integer[n+1];


        int compare=0;
        for(int i=1;i<n+1;i++){
            initBooks[i]=scanner.nextInt();
            accumulatePrice[i]=accumulatePrice[i-1]+initBooks[i];
        }



        for(int i=1;i<=n;i++){
            if(i==1&&findMinimumPrice(i,n,0,x,initBooks)>=x){
                compare=findMinimumPrice(i,n,0,x,initBooks);
                continue;
            }
            if(compare>findMinimumPrice(i,n,0,x,initBooks)&&i!=n&&compare>=x){
                compare=findMinimumPrice(i,n,0,x,initBooks);

            }
            if(i==n&&compare>initBooks[i]&&initBooks[i]>=x){
                compare=initBooks[i];

            }

        }
        System.out.println(compare);

    }



}
