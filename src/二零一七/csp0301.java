package 二零一七;

import java.util.Scanner;

public class csp0301 {




        public static void main(String[] args) {
            int n,k;
            int count=0;
            int people=0;
            Scanner scanner=new Scanner(System.in);
            n=scanner.nextInt();



            k=scanner.nextInt();

            int ai[]=new int[n];


            for(int i=0;i<n;i++){

                ai[i]=scanner.nextInt();

            }
            for(int j=0;j<n;j++){
                count=count+ai[j];
                if(count>=k){
                    people++;
                    count=0;
                }
            }
            if(count!=0){
                people++;
            }
            System.out.println(people);
            scanner.close();


        }
    }

