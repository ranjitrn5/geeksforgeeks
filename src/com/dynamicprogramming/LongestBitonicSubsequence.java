package com.dynamicprogramming;

public class LongestBitonicSubsequence {
	
	public static int calculateLBS(int [] arr){
		int[] LIS = new int[arr.length];
		int[] LDS = new int[arr.length];
		int[] result = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			LIS[i]=1;
			LDS[i]=1;
		}
		
		//Calculating LIS from left to right
		for(int i=1;i<arr.length;i++)
			for(int j=0;j<i;j++){
				if(arr[j] < arr[i] && LIS[i] < LIS[j]+1){
					LIS[i]=LIS[j]+1;
					//System.out.print(LIS[i]+" ");
				}
			}
		//System.out.println("");
		//Calculation LDS i.e Longest Increasing Subsequence from right to left
		for(int k=arr.length-2;k>=0;k--)
			for(int m = arr.length-1;m > k;m--){
				if(arr[m] < arr[k] && LDS[k] < LDS[m]+1){
					LDS[k]=LDS[m]+1;
					//System.out.print(LDS[k]+" ");
				}
			}
		int max = Integer.MIN_VALUE;
		for(int n = 0;n<arr.length;n++){
			result[n]= LIS[n]+LDS[n]-1;
			if(max < result[n]){
				max = result[n];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] input = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println("Longest Bitonic Subsequence: "+calculateLBS(input));
	}

}
