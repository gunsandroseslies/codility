package com.kluszynski.codility.alpha2010;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class Solution.
 */
public class Solution {
	/**
	 * Solution.
	 *
	 * @param A the a
	 * @return the int
	 */
	public int solution(int[] A) {
		final Set<Integer> coveringIndexSet = new HashSet<Integer>();
		int coveringIndex = 0;
		
		for(int i = 0; i < A.length; i++) {
			final Integer number = Integer.valueOf(A[i]);
			if (!coveringIndexSet.contains(number)) {
				coveringIndexSet.add(number);
				coveringIndex = i;
			}
		}
		return coveringIndex;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final Solution solution = new Solution();
		
		final int[] input = {2, 2, 1, 0, 1};
		System.out.println(solution.solution(input));
	}
}