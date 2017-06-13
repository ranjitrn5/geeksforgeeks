package com.dynamicprogramming;

public class CoinChangeWays {

	public static int getTotalNoOFWays(int[] coins, int total){
        int[][] T = new int[coins.length+1][total+1];
        for(int i=0;i<T.length;i++){
            T[i][0]=1;
        }
        
        for(int i=1;i<T.length;i++){
            for(int j=1;j<T[i].length;j++){
            	if(j >= coins[i-1]){
                    T[i][j]=T[i-1][j]+T[i][j-coins[i-1]];
                }
                else{
                    T[i][j]=T[i-1][j];
                }
            }
        }
        return T[coins.length][total];
    }
	
	public static int getTotalWaysOptimized(int[] coins, int total){
		int[] temp = new int[total+1];
		temp[0]=1;
		for(int i=0;i<coins.length;i++)
			for(int j=1;j<=total;j++){
				if(j >= coins[i]){
					temp[j]+=temp[j-coins[i]];
				}
			}
		return temp[total];
	}
	
	public static void main (String[] args) {
		int[] coins = {3,4,6,7,9};
		int total =15;
		System.out.println(getTotalNoOFWays(coins,total));
		System.out.println(getTotalWaysOptimized(coins, total));
	}

}
