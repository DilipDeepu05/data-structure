package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnSameLine {

	public static void main(String[] args)
	{
		int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 },
				{ 2, 2 },  { 3, 3 }, { 3, 4 } };
		System.out.println(maxPointOnSameLine(points));
	}

	private static int maxPointOnSameLine(int[][] points) {
		Map<String, Integer> m = new HashMap<>();
		int currMax = 0, max = 0, v =0, o= 0;

		for(int i = 0 ; i < 6; ++i) {
			currMax = v = o = 0;

			for(int j = i + 1 ; j < points.length; ++j) {


				if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
					o++;
				}

				else if(points[i][0] == points[j][0]) {
					v++;
				}
				else {
					int x = points[j][0] - points[i][0];
					int y = points[j][1] - points[i][1];

					int g = gcd(x, y);
					x/=g;
					y/=g;

					String pair = x+" "+y;
					if(!m.containsKey(pair)) {
						m.put(pair, 1);
					} else {
						m.put(pair, m.get(pair) + 1);
						currMax = Math.max(currMax, m.get(pair));
					}
				}
				currMax = Math.max(v, currMax);
			}
			m.clear();
			max = Math.max(max, currMax+o+1);
		}

		return max;
	}

	private static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}
		int r = x % y;
		return gcd(y, r);
	}
}
