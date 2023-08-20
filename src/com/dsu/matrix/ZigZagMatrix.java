package com.dsu.matrix;

import java.util.Arrays;

public class ZigZagMatrix {

	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		zigZagMatrix(matrix, 3, 3);
	}

	private static void zigZagMatrix(int[][] mat, int m, int n) {
        if(mat.length == 0|| mat[0].length == 0) {
            return;
        }

        int row = mat.length;
        int col = mat[0].length;

        int[] res = new int[row * col];
        int r = 0;
        int c = 0;

        for(int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            //move up
            if((r + c) % 2 == 0) {
                if(c == col - 1) {
                    r++;
                } else if(r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if(r == row - 1) {
                    c++;
                } else if(c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
		}
        
        System.out.println(Arrays.toString(res));
	}
}
