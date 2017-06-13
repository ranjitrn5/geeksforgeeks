package com.dynamicprogramming;

import java.util.Scanner;

public class BinomialCoEfficient {
	
	public static int getRecursiveBinoCoefficient(int n, int k){
		if(k == 0 || k==n){
			return 1;
		}
		else{
			return getRecursiveBinoCoefficient(n-1, k-1)+getRecursiveBinoCoefficient(n-1, k);
		}
	}
	
	public static int getBinoCoefficient(int n, int k){
		int[][] dp = new int[n+1][k+1];
		
		for(int i=0;i<=n;i++)
			for(int j=0;j<=Math.min(i, k);j++){
				if(j==0 || j==i){
					dp[i][j]= 1;
				}
				else{
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
		return dp[n][k];
	}
	
	public static int spaceOptimizedBinoCoefficient(int n, int k){
		int[] temp = new int[k+1];
		
		for(int i=0;i<=n;i++)
			for(int j=Math.min(i, k);j>=0;j--){
				if(j == 0 || j==i){
					temp[j]=1;
				}
				else{
					temp[j]=temp[j]+temp[j-1];
				}
			}
		return temp[k];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n and k values:");
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("Recursive approach: "+getRecursiveBinoCoefficient(n,k));
		System.out.println("Dynamic approach: "+getBinoCoefficient(n,k));
		System.out.println("Space Optimized Dynamic approach: "+spaceOptimizedBinoCoefficient(n,k));

	}

}
