package com.dsu.divideandconquer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

class PointXComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		return Integer.compare(o1.x, o2.x);
	}
}

class PointYComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		return Integer.compare(o1.y, o2.y);
	}
}

class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static float closest(Point[] p, int length) {
		Arrays.sort(p, 0, length, new PointXComparator());
		return closestUtil(p, 0, length);
	}

	private static float closestUtil(Point[] p, int start, int end) {
		
		if(end - start <= 3) {
			return brunteForceMin(p, end);
		}
		
		int mid = start + (end -start) / 2;
		Point midP = p[mid];
		
		float l = closestUtil(p, start, mid);
		float r = closestUtil(p, mid, end);
		
		float min = Math.min(l, r);
		int j = 0;
		Point[] strip = new Point[end];
		
		for(int i = 0; i < p.length; ++i) {
			if(Math.abs(p[i].x - midP.x) < min) {
				strip[j++] = p[i];
			}
		}
		
		return Math.min(min, stripClosest(p, j, min));
	}

	private static float stripClosest(Point[] strip, int j, float min) {
		Arrays.sort(strip, 0, j, new PointYComparator());
		
		for(int i = 0; i < j; ++i) {
			for(int k = i + 1; k < j && strip[j].y - strip[i].y < min; k++) {
				if(dist(strip[j], strip[i]) < min) {
					min = dist(strip[j], strip[i]);
				}
			}
		}
		return min;
	}

	private static float brunteForceMin(Point[] p, int end) {
		float min = Float.MAX_VALUE;
		float curr;
		for(int i = 0 ; i < end; i++) {
			for(int j = i + 1; j < end; j++) {
				curr = dist(p[i], p[j]);
				if(curr < min) {
					min = curr;
				}
			}
		}
		return min;
	}

	private static float dist(Point p1, Point p2) {
		return (float) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}


public class ClosestPairOfPoints {

	public static void main(String[] args) {
		Point[] P = new Point[]{
				new Point(2, 3),
				new Point(12, 30),
				new Point(40, 50),
				new Point(5, 1),
				new Point(12, 10),
				new Point(3, 4)
		};

		DecimalFormat df = new DecimalFormat("#.######");
		System.out.println("The smallest distance is " +
				df.format(Point.closest(P, P.length)));
	}
}
