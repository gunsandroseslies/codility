package com.kluszynski.codility.beta2010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Solution.
 */
public class Solution {
	/**
	 * The Class DiscPoint.
	 */
	private static class DiscPoint implements Comparable<DiscPoint> {
		
		/** The x. */
		private long x;
		
		/** The left. */
		private boolean left;
		
		/**
		 * Instantiates a new disc point.
		 *
		 * @param x the x
		 * @param left the left
		 */
		DiscPoint(final long x, final boolean left) {
			this.x = x;
			this.left = left;
		}
		
		/**
		 * Gets the x.
		 *
		 * @return the x
		 */
		long getX() {
			return x;
		}
		
		/**
		 * Checks if is left.
		 *
		 * @return true, if is left
		 */
		boolean isLeft() {
			return left;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(DiscPoint discPoint) {
			if (getX() < discPoint.getX()) {
				return -1;
			} else if (getX() > discPoint.getX()) {
				return 1;
			} else {
				if (isLeft() && !discPoint.isLeft()) {
					return -1;
				} else if (!isLeft() && discPoint.isLeft()) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
	/**
	 * Solution.
	 *
	 * @param A the a
	 * @return the int
	 */
	public int solution(int[] A) {
		final List<DiscPoint> discPoints = new ArrayList<DiscPoint>();
		for(int i = 0; i < A.length; i++) {
			final DiscPoint leftPoint = new DiscPoint((long) i - (long) A[i], true);
			final DiscPoint rightPoint = new DiscPoint((long) i + (long) A[i], false);
			discPoints.add(leftPoint);
			discPoints.add(rightPoint);
		}
		
		Collections.sort(discPoints);
		
		int intersection = 0;
		int openDiscs = 0;
		for(DiscPoint discPoint : discPoints) {
			if (discPoint.isLeft()) {
				openDiscs++;
			} else {
				openDiscs--;
				
				intersection += openDiscs;
				
				if (intersection > 10000000) {
					return -1;
				}
			}
		}
		
		return intersection;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final Solution solution = new Solution();
		
		final int[] input = {1, 5, 2, 1, 4, 0};
		System.out.println(solution.solution(input));
	}
}