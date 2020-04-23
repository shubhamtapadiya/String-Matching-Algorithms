import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.lang.*;


public class KMP {
    public static void main(String arg[]) {
        Scanner src = new Scanner(System.in);
        try {
            System.out.println("Enter the text");
            String T = src.nextLine();
            //char T[] = text.toCharArray();
            System.out.println("Enter the Pattern");
            String P = src.nextLine();
            //char P[] = text.toCharArray();
            KMPExe.search(T, P);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}

class KMPExe {
        public static void search(String T, String P) {
            int tlen = T.length();
            int plen = P.length();
            int[] lsp = new int [plen];
            ba(P, plen, lsp);
            int i = 0; int j = 0;
            do {
                if (P.charAt(j) == T.charAt(i)) {
                    i++;
                    j++;
                }
                if (j == plen) {
                    System.out.println("Pattern found at:" + (i - j));
                    j = lsp[j - 1];
                }
                else if (P.charAt(j) != T.charAt(i)) {
                    if (j != 0)
                        j = lsp[j - 1];
                    else
                        i++;
                }
            } while (i < tlen);
        }

        static void ba(String P, int plen,int lsp[]) {
            int i=0; int j=0;int flag=1;
            do{
                if(P.charAt(i)==P.charAt(j)){
                    lsp[i]=flag;
                    j++;flag++;
                }
                else{
                    j++;
                }
                i++;
            }while(i<plen);
        }
    }