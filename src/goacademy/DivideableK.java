/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goacademy;

import java.util.Scanner;

/**
 *
 * @author Fikry-PC
 */
public class DivideableK {
     public static void divideAbleK() {
        int[] kCases;
        int[] a;
        int[] b;
        int[] solutions;
        
        Scanner input = new Scanner(System.in);
        int caseSize = input.nextInt();
        kCases = new int[caseSize];
        solutions = new int[caseSize];
        a = new int[caseSize];
        b = new int[caseSize];
        
        for(int i = 0 ; i<caseSize ; i++){
            a[i] = input.nextInt();
            b[i] = input.nextInt();
            kCases[i] = input.nextInt();
        }
        
        //solution
        for(int i = 0 ; i<caseSize ; i++){
            int testNum = b[i];
            int count = 0;
            while(testNum >= a[i]){
                if(testNum % kCases[i] == 0){
                    count++;
                }
                testNum--;
            }
            solutions[i] = count;
        }
        
         for(int i = 0 ; i<caseSize ; i++){
           System.out.println("Case "+(i+1)+": "+solutions[i]);
        }
    }
}
