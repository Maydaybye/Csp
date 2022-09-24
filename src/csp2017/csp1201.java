package csp2017;

import java.util.Scanner;

public class csp1201 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        int difference;

        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int temp=a[0]-a[1];
        if(temp<0){
            temp=-temp;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                difference=a[i]-a[j];
                if(difference<0){
                    difference=difference*(-1);
                }
                if(difference<temp){
                    temp=difference;
                }

            }
        }
        System.out.println(temp);
    }
}
