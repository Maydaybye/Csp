package csp2022;


import java.util.Scanner;

public class csp0902_V2_forLoop_9e6_score100 {
    static int N =50;
    static int n,x;
    static int M=(int)(3e5+10);
    static int[] price=new int[N];
    static int[] f=new int[M];
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        n=scanner.nextInt();
        x=scanner.nextInt();
        for(int i=0;i<n;i++){
            price[i]=scanner.nextInt();
        }
        f[0]=1;
        for(int i=0;i<n;i++){
            for(int j=M;j>=price[i];j--){
                if(f[j-price[i]]>0){
                    f[j]=1;
                }
            }
        }
        int out=x;
        while(true){
            if(f[out]>0) break;
            else{
                out++;
            }

        }
        System.out.println(out);
    }


}

