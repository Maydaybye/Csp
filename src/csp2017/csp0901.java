package csp2017;

import java.util.Scanner;

public class csp0901 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        if(N%50==0){
            System.out.println((N/50)*7);

        } else if (N>50) {
            int a=N%50;
            int b=a%30;
            if(a>=30){

                System.out.println((N/50)*7+4+b/10);
            }
            else{
                System.out.println((N/50)*7+b/10);

            }

        }
        else{
            int a=N%50;
            int b=a%30;
            if(a>=30){

                System.out.println(4+b/10);
            }
            else{
                System.out.println(b/10);

            }

        }

    }
}
