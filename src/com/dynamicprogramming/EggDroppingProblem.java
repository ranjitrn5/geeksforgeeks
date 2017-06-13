package com.dynamicprogramming;

public class EggDroppingProblem {
	
	public static int getEggDropRecursive(int n, int k){
		if(n == 1){
			return k;
		}
		
		if(k == 1 || k == 0){
			return k;
		}
		
		int min = Integer.MAX_VALUE;
		for(int x=1;x<=k;x++){
			int res = 1+Math.max(getEggDropRecursive(n-1, x-1), getEggDropRecursive(n, k-x));
			if(res < min)
				min = res;
		}
		return min;
	}
	
	public static int getEggDrop(int n, int k){
		int[][] eggDrop = new int[n+1][k+1];
		int res;
		
		for(int i=1;i<=n;i++){
			eggDrop[i][1]=1;
			eggDrop[i][0]=0;
		}
		
		for(int j = 1;j<=k;j++){
			eggDrop[1][j]=j;
		}
		
		for(int i=2;i<=n;i++)
			for(int j=2;j<=k;j++){
				eggDrop[i][j]=Integer.MAX_VALUE;
				for(int x=1;x<=j;x++){
					res = 1+Math.max(eggDrop[i-1][x-1], eggDrop[i][j-x]);
					if(res < eggDrop[i][j]){
						eggDrop[i][j]=res;
					}
				}
			}
		return eggDrop[n][k];
	}

	public static void main(String[] args) {
		System.out.println("Recurisve Version: "+getEggDropRecursive(2, 36));
		System.out.println("Dynamic Version: "+getEggDrop(2, 36));

	}

}
