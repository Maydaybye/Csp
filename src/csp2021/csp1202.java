package csp2021;

import java.util.Scanner;

public class csp1202 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int N=scanner.nextInt();
        int r=N/(n+1);
        int[] A=new int[n+1];
        int gx=0;
        int fi=0;
        int cursor=0;
        int acc=0;
        for(int i=1;i<n+1;i++){
            A[i]=scanner.nextInt();
        }
//        System.out.println("r:"+r);
//        System.out.print("fi:");
//        for(int i=0;i<N;i++){
//            if(cursor+1<=n&&i==A[cursor+1]){
//                cursor++;
//            }
//            fi[i]=cursor;
////          System.out.print(" "+fi[i]);
//        }
//        System.out.println();
//        System.out.print("gx:");
        for(int i=0;i<N;i++){
            gx=i/r;
            if(cursor+1<=n&&i==A[cursor+1]){
                cursor++;
            }
            fi=cursor;
//            System.out.print(" "+gx);
            if(gx-fi<0){
                acc=acc-gx+fi;
            }
            else{
                acc=acc+gx-fi;
            }

        }
//        System.out.println();
        System.out.println(acc);
    }
}
