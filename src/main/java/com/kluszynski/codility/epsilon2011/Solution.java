package com.kluszynski.codility.epsilon2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Solution.
 */
public class Solution {
    private class Point {
        private double x;
        
        private double y;
        
        public Point(final double x, final double y) {
            this.x = x;
            this.y = y;
        }
        
        public double getX() {
            return x;
        }
        
        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(getX());
            stringBuilder.append(",");
            stringBuilder.append(getY());
            stringBuilder.append("]");
           
            return stringBuilder.toString();
            
        }
    }
    
    private class Line implements Comparable<Line> {
        private int a;
        
        private int b;
        
        public Line(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        public int getA() {
            return a;
        }
        
        public int getB() {
            return b;
        }
        
        public int compareTo(final Line line) {
            if (getA() < line.getA()) {
                return -1;
            } else if (getA() > line.getA()) {
                return 1;
            } else {
                if (getB() < line.getB()) {
                    return -1;
                } else if (getB() > line.getB()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        
        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Line)) {
                return false;
            } else {
                final Line line = (Line) object;
                return getA() == line.getA() && getB() == line.getB();
            }
        }
        
        public boolean isParallel(final Line line) {
            return getA() == line.getA();
        }
        
        public Point intersection(final Line line) {
            final double x = (line.getB() - getB()) / (getA() - line.getA());
            final double y = getA() * x + getB();
            return new Point(x, y);
        }
        
        @Override
        public String toString() {
            final StringBuilder stringBuilder = new StringBuilder();
            
            stringBuilder.append("y = ");
            
            if (getA() == 0 && getB() == 0) {
                stringBuilder.append("0");
            } else {
                if (getA() != 0) {
                    if (getA() == -1) {
                        stringBuilder.append("-");
                    } else if (getA() != 1) {
                        stringBuilder.append(getA());
                        stringBuilder.append("*");
                    }
    
                    stringBuilder.append("x");
                }
                
                if (getB() > 0) {
                    if (getA() != 0) {
                        stringBuilder.append(" + ");
                    }
                    stringBuilder.append(getB());
                } else if(getB() < 0) {
                    if (getA() != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append("- ");
                    stringBuilder.append(Math.abs(getB()));
                }
            }
            
            return stringBuilder.toString();
        }
    }
    
    private void determineFunction(final List<Line> lines, final List<Line> u,
        final List<Point> uPoints) {
        for(Line line : lines) {
            if (u.isEmpty()) {
                u.add(line);
                continue;
            } else {
                final Line previousLine = u.get(u.size() - 1);
                
                if (previousLine.equals(line)) {
                    continue;
                } else if (previousLine.isParallel(line)) {
                    continue;
                } else {
                    final Point point = previousLine.intersection(line);
                    
                    if (point.getX() < uPoints.get(uPoints.size() - 1).getX()) {
                        uPoints.add(point);
                        u.add(line);
                    } else {
                        uPoints.remove(uPoints.size() -1);
                        u.remove(u.size() - 1);
                        
                        //final secondPoint = previousLine.intersection(line);
                    }
                }
            }
        }
    }
    
    /**
     * @param A
     * @param B
     * @return
     */
    public double solution(int[] A, int[] B) {
        if (A.length == 1) {
            return 0;
        }
        
        final List<Line> u = new ArrayList<Line>();
        final List<Point> uPoints = new ArrayList<Point>();
        
        final List<Line> d = new ArrayList<Line>();
        final List<Point> dPoints = new ArrayList<Point>();
        
        final List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < A.length; i++) {
            lines.add(new Line(A[i], B[i]));
        }
        
        System.out.println(lines);
        Collections.sort(lines);
        Collections.reverse(lines);
        System.out.println(lines);
        
        determineFunction(lines, u, uPoints);
        
        Collections.reverse(lines);
        determineFunction(lines, d, dPoints);
        
        System.out.println(u);
        System.out.println(uPoints);
        
        System.out.println(d);
        System.out.println(dPoints);

        return 0;
    }
    
    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        final Solution solution = new Solution();

        final int[] a = {-1, 1, 0};
        final int[] b = {3, 0, 0};
        //final int[] a = {-1, -1};
        //final int[] b = {3, 4};

        System.out.println(solution.solution(a, b));
    }
}