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
public class FindWord {
    public static void findWord(){
//        int count = wordCountForwardAndReverse("zzzcatzzzcatzzzcatzzzcat", "cat");
//        System.out.println(""+count);
          Scanner input = new Scanner(System.in);
          int caseSize = input.nextInt();
          
          int[] solutions = new int[caseSize];
          
          for(int i = 0;i<caseSize;i++){
              int nSize = input.nextInt();
              int mSize = input.nextInt();
              String[][] nm = new String[nSize][mSize];
              
              for(int j = 0;j<nSize;j++){
                  for(int k = 0;k<mSize;k++){
                      nm[j][k] = input.next();
                  }
                  System.out.println();
              }
              String word = input.nextLine();
              int countCase = solveCase(nm, word);
              System.out.println("Solve diagonal :"+countCase);
          }
          
    }
    
    public static int wordCountFromString(String s, String word){
        int count = 0;
        for(int i =0;i<s.length();i++){
            if(i<=(s.length() - word.length())){
                int tempPost = i;
                for(int j =0;j<word.length();j++){
                    if(s.charAt(tempPost) != word.charAt(j)){
                        break;
                    }
                    if(j == word.length()-1){
                        count++;
                    }
                    tempPost++;
                }
            }
        }
        return count;
    }
    
    public static int wordCountForwardAndReverse(String s, String word){
        int count = 0;
        count = count + wordCountFromString(s, word);
        
        StringBuilder builder = new StringBuilder(s); 
        String reversedS = builder.reverse().toString();
        
        count = count + wordCountFromString(reversedS, word);
        return count;
    }

    private static int solveCase(String[][] nm, String word) {
        return solveDiagonal(nm, word);
    }

    private static int solveDiagonal(String[][] nm, String word){
        int count = 0;
        
        StringBuilder diagonal1 = new StringBuilder("");
        for(int n = 0 ; n<nm.length;n++){
            int iter = 0;
            for(int m = 0 ; m<nm[0].length;m++){
                diagonal1.append(nm[m][iter]);
                iter++;
            }
        }
        count+=wordCountForwardAndReverse(diagonal1.toString(), word);
        
        StringBuilder diagonal2 = new StringBuilder("");
        for(int n = (nm.length-1) ; n>0;n--){
            int iter = 0;
            for (int m = (nm[0].length-1) ; m>0 ; m--) {
                diagonal1.append(nm[m][iter]);
                iter++;
            }
        }
        count+=wordCountForwardAndReverse(diagonal2.toString(), word);
        return count;
    }
}
