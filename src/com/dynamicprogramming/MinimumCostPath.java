package com.dynamicprogramming;

public class MinimumCostPath {
	
	private static int min(int a, int b, int c){
		if(a < b){
			return (a<c)?a:c;
		}
		else{
			return (b < c)?b:c;
		}
	}
	
	public static int getMinimumCost(int[][]c, int m, int n){
		int[][]tc = new int[c.length][c[0].length];
		//tc[0][0] = c[0][0];
		
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++){
				if(i == 0 && j == 0){
					tc[i][j]=c[i][j];
				}
				else if(i == 0){
					tc[i][j]=tc[i][j-1]+c[i][j];
				}
				else if(j == 0){
					tc[i][j]=tc[i-1][j]+c[i][j];
				}
				else{
					tc[i][j] = min(tc[i-1][j-1],tc[i][j-1],tc[i-1][j])+c[i][j];
				}
			}
		return tc[m][n];
	}

	public static void main(String[] args) {
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
 System.out.println("minimum cost to reach (2,2) = " +
                                  getMinimumCost(cost,2,2));
		

	}

}
