package com.kluszynski.codility.gamma2011;

/**
 * The Class Solution.
 */
public class Solution {
    /**
     * Solution.
     *
     * @param S the s
     * @return the int
     */
    public int solution(String S) {
        int numberOfPalindroms = 0;
        
        final int[] singlePalindromSeeds = new int[S.length()];       
        final int[] doublePalindromSeeds = new int[S.length()];
        
        for (int i = 0; i < S.length(); i++) {
            singlePalindromSeeds[i] = i;
            doublePalindromSeeds[i] = i;
        }
        
        for(int i = 0; i < singlePalindromSeeds.length; i++) {
            int j = 1;
            while(singlePalindromSeeds[i] - j >= 0
                && singlePalindromSeeds[i] + j <= S.length() - 1
                && S.charAt(singlePalindromSeeds[i] - j) == S.charAt(singlePalindromSeeds[i] + j)) {
                j++;
                numberOfPalindroms++;
                
                if (numberOfPalindroms > 100000000) {
                    return -1;
                }
            }
        }
        
        for(int i = 0; i < doublePalindromSeeds.length; i++) {
            int j = 0;
            while(doublePalindromSeeds[i] - j >= 0
                && doublePalindromSeeds[i] + j + 1 <= S.length() - 1
                && S.charAt(doublePalindromSeeds[i] - j) == S.charAt(doublePalindromSeeds[i] + j + 1)) {
                j++;
                numberOfPalindroms++;
                
                if (numberOfPalindroms > 100000000) {
                    return -1;
                }
            }
        }
        
        return numberOfPalindroms;
    }

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        final Solution solution = new Solution();

        final String input = "abbacada";
        System.out.println(solution.solution(input));
        
        final String input1 = "baababa";
        System.out.println(solution.solution(input1));
    }
}