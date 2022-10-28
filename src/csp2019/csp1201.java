package csp2019;

import java.util.Scanner;

public class csp1201 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int count=0;
        int[] record=new int[4];
        for(int i=1;i<n+1;i++){
            if(i%7==0||i%10==7||i/10%10==7||i/100%10==7||i/100%10==7){
                if(i%4==0){
                    record[3]++;
                }
                else{
                    record[i%4-1]++;
                }

                n++;

            }
            else{
                count++;
            }
            if(count==n){
                break;
            }
        }
        for(int b:record){
            System.out.println(b);
        }

    }
}
