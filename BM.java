package com.company;

// Bad Character Heuristic Program for Boyer Moore String Matching
import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.lang.*;


public class BM
{
    public static void main(String arg[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T,P;
        try
        {
            System.out.println("Enter the Pattern: ");
            P = br.readLine();
            System.out.println("Enter the Text: ");
            T = br.readLine();
            BME.find(T,P);
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    }
}

class BME
{
    private static void badChar(String str, int size, int[] badchar)
    {
        int i;
        for (i = 0; i < 256; i++)
        {
            badchar[i] = -1;
        }
        for (i = 0; i < size; i++)
        {
            badchar[str.charAt(i)] = i;
        }
    }
    static void find( String T,  String P)
    {
        int tlen = T.length();
        int plen = P.length();
        int found=0;
        int[] badchar = new int[256];
        badChar(P, plen,badchar);

        int j = plen-1;
        int k;
        //System.out.println("value of j:" +j+" Value of pattern length plen:"+plen);

        do
        {
            k = plen-1;
            do
            {
                k--;
                j--;
                if (k < 0)
                {
                    System.out.println ("Pattern is at location: "+(j + 1));
                    found=1;
                    break;
                }
                //Get the position of the right most occurence of T.charAt(j)
                //in the pattern if not found
                int right = badchar[T.charAt(j)];

                // Shift pattern to the right whole pattern
                int shift = k - right;
                j += shift;
            }while (T.charAt(j) == P.charAt(k));
            if(found==1)
            {
                break;
            }
            j++;
        }while(j<tlen);
    }
}