package com.kluszynski.codility.gamma2011;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class SolutionTooSlow.
 */
public class SolutionTooSlow {
    /**
     * The Class PalindromSeed.
     */
    static class PalindromSeed {

        /** The string. */
        private String string;

        /** The starting index. */
        private int startingIndex;

        /** The double seed. */
        private boolean doubleSeed;

        /**
         * Instantiates a new palindrom seed.
         * 
         * @param string the string
         * @param startingIndex the starting index
         * @param doubleSeed the double seed
         */
        PalindromSeed(final String string, final int startingIndex, final boolean doubleSeed) {
            this.string = string;
            this.startingIndex = startingIndex;
            this.doubleSeed = doubleSeed;
        }

        /**
         * Gets the starting index.
         * 
         * @return the starting index
         */
        long getStartingIndex() {
            return startingIndex;
        }

        /**
         * Checks if is double seed.
         * 
         * @return true, if is double seed
         */
        boolean isDoubleSeed() {
            return doubleSeed;
        }

        /**
         * Gets the palindrom.
         *
         * @param level the level
         * @return the palindrom
         */
        boolean isPalindrom(final int level) {
            final int firstIndexOfPalindrom;
            final int lastIndexOfPalindrom;
			if (!doubleSeed) {
			    firstIndexOfPalindrom = startingIndex - level;
			    lastIndexOfPalindrom = startingIndex + level;
			} else {
			    firstIndexOfPalindrom = startingIndex - level;
			    lastIndexOfPalindrom = startingIndex + level + 1;
			}
			
            if (firstIndexOfPalindrom < 0 || lastIndexOfPalindrom > string.length() - 1) {
                return false;
            } else if (string.charAt(firstIndexOfPalindrom) != string.charAt(lastIndexOfPalindrom)) {
                return false;
            } else {
                return true;
            }


		}
    }

    /**
     * Solution.
     *
     * @param S the s
     * @return the int
     */
    public int solution(String S) {
        final List<PalindromSeed> palindromSeeds = new ArrayList<PalindromSeed>();
        
        int numberOfPalindroms = 0;
        
        for (int i = 0; i < S.length() - 1; i++) {
            final PalindromSeed singlePalindromSeed = new PalindromSeed(S, i, false);
            palindromSeeds.add(singlePalindromSeed);
            
            if (i + 1 <= S.length() - 1 && S.charAt(i) == S.charAt(i+1)) {
                final PalindromSeed doublePalindromSeed = new PalindromSeed(S, i, true);
                palindromSeeds.add(doublePalindromSeed);
                
                numberOfPalindroms++;
            }
        }

        for (PalindromSeed palindromSeed : palindromSeeds) {
            for (int i = 1; palindromSeed.isPalindrom(i); i++) {
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
        final SolutionTooSlow solution = new SolutionTooSlow();

        final String input = "abbacada";
        System.out.println(solution.solution(input));
        
        final String input1 = "baababa";
        System.out.println(solution.solution(input1));
    }
}