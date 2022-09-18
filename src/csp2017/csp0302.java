package csp2017;

import java.util.Scanner;

public class csp0302 {
    public static void main(String[] args) {

        int p,q;
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] student=new int[n];
        for(int i=0;i<n;i++){
            student[i]=i+1;
        }

        for(int j=0;j<m;j++){
            int k,l;
            int index=0;
            p=scanner.nextInt();
            q=scanner.nextInt();
            for(int i=0;i<n;i++){
                if(student[i]==p){
                    index=i;
                    break;
                }


            }
            if(q<0){
                int a=q;

                for(k=index;a<0;a++){
                    student[k]=student[k-1];
                    --k;
                }
                student[index+q]=p;
            }
            if(q>0){
                int a=q;
                for(l=index;a>0;a--){
                    student[l]=student[l+1];
                    ++l;
                }
                student[index+q]=p;
            }


        }
        for(int a=0;a<n;a++){
            System.out.print(student[a]+" ");
        }


    }
}
