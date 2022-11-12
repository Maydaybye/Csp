package csp2021;

import java.util.Scanner;

public class csp1202_V2 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int N=scanner.nextInt();
        int r=N/(n+1);
        int[] A=new int[n+1];
        int gx=0;
        int fx=0;
        int gMax=0;
        int diff=0;
        int acc=0;
        int left=0;
        for(int i=1;i<n+1;i++) {
            A[i] = scanner.nextInt();
            gx = gMax;
            fx = i - 1;
            if (left == 0) {
                if ((A[i] - A[i - 1]) % r == 0) {
                    gMax = gMax + (A[i] - A[i - 1]) / r - 1;
                } else {
                    gMax = gMax + (A[i] - A[i - 1]) / r;
                }

            } else {

                gMax = gMax + (A[i] - A[i - 1] - r + left) / r;


            }

            if (left != 0) {
                diff = Math.abs(fx - gx);//
                acc = acc + (diff) * (r - left);//
                gx++;
                left = (Math.abs(A[i] - A[i - 1] - r + left)) % r;
                if(A[i]-A[i-1]<r){


                    continue;

                }

            }
            if (left == 0) {
                left = (Math.abs(A[i] - A[i - 1])) % r;
                if(A[i]-A[i-1]<r){

                    continue;

                }

            } else {
                left = (Math.abs(A[i] - A[i - 1] - r + left)) % r;//
                if(A[i]-A[i-1]<r){

                    continue;

                }
            }




            if (gx < fx) {

                if (fx > gMax) {
                    acc = acc + fx * (gMax - gx + 1) * r - (gx + gMax) * (gMax - gx + 1) / 2 * r;
                    if (left != 0) {
                        gMax++;
                        acc = acc + left * Math.abs(fx - gMax);
                    }
                } else if (gMax == fx) {
                    acc = acc + 0;
                    if (left != 0) {
                        gMax++;
                        acc = acc + left * Math.abs(gMax - fx);
                    }
                } else {
                    acc = acc + (fx - gx + 1) * fx * r - (gx + fx) * (fx - gx + 1) / 2 * r;
                    acc = acc - (gMax - fx) * fx * r + (fx + 1 + gMax) * (gMax - fx) / 2 * r;
                    if (left != 0) {
                        gMax++;
                        acc = acc + left * Math.abs(gMax - fx);
                    }
                }
            }

            else {
                if (gx == gMax) {


                    acc = acc + (gx - fx) * r;
                    if (left != 0) {
                        gMax++;
                        acc = acc + left * Math.abs(gMax - fx);
                    }


                } else {
                    acc = acc + (gx + gMax) * (gMax - gx + 1) / 2 * r - fx * (gMax - gx + 1) * r;
                    if (left != 0) {
                        gMax++;
                        acc = acc + left * Math.abs(gMax - fx);
                    }
                }


            }
            System.out.print(acc + " ");

            if (i == n) {
                System.out.println("begin");
                fx = n;
                gx = gMax;
                if (left == 0) {
                    if ((N - A[i - 1]) % r == 0) {
                        gMax = gMax + (N - A[i]) / r - 1;
                    } else {
                        gMax = gMax + (N - A[i]) / r;
                    }

                } else {

                    gMax = gMax + (N - A[i] - r + left) / r;


                }
                if (left != 0) {
                    diff = Math.abs(fx - gx);//
                    acc = acc + (diff) * (r - left);//
                    gx++;
                    left = (Math.abs(A[i] - A[i - 1] - r + left)) % r;
                    if(A[i]-A[i-1]<r){

                        continue;

                    }

                }
                if (left == 0) {
                    left = (Math.abs(A[i] - A[i - 1])) % r;
                    if(A[i]-A[i-1]<r){

                        continue;

                    }

                } else {
                    left = (Math.abs(A[i] - A[i - 1] - r + left)) % r;//
                    if(A[i]-A[i-1]<r){

                        continue;

                    }
                }



                if (gx < fx) {

                    if (fx > gMax) {
                        acc = acc + fx * (gMax - gx + 1) * r - (gx + gMax) * (gMax - gx + 1) / 2 * r;
                        if (left != 0) {
                            gMax++;
                            acc = acc + left * Math.abs(fx - gMax);
                        }
                    } else if (gMax == fx) {
                        acc = acc + 0;
                        if (left != 0) {
                            gMax++;
                            acc = acc + left * Math.abs(gMax - fx);
                        }
                    } else {
                        acc = acc + (fx - gx + 1) * fx * r - (gx + fx) * (fx - gx + 1) / 2 * r;
                        acc = acc - (gMax - fx) * fx * r + (fx + 1 + gMax) * (gMax - fx) / 2 * r;
                        if (left != 0) {
                            gMax++;
                            acc = acc + left * Math.abs(gMax - fx);
                        }
                    }
                } else {

                        if (gx == gMax) {
                            acc = acc + (gx - fx) * r;
                            if (left != 0) {
                                gMax++;
                                acc = acc + left * Math.abs(gMax - fx);
                            }
                        } else {
                            acc = acc + (gx + gMax) * (gMax - gx + 1) / 2 * r - fx * (gMax - gx + 1) * r;
                        }

                        if (left != 0) {
                            gMax++;
                            acc = acc + left * Math.abs(gMax - fx);
                        }

                }
            }
        }


        System.out.println(acc);
    }
}
