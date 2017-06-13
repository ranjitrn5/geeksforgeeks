package com.dynamicprogramming;

public class LongestIncreasingSubsequence {
	
	public static int getLongestSubsequence(int[] arr){
		int[] lis = new int[arr.length];
		for(int i=0;i<lis.length;i++){
			lis[i]=1;
		}
		
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
				}
			}
		}
		//Printing increasing subsequence
		int index = lis.length-1;
		int result = lis[arr.length-1];
		String sequence = arr[index]+" ";
		for(int i=index;i>=0;i--){
			if(lis[i]==result-1){
				sequence=arr[i]+" "+sequence;
				result--;
			}
		}
		System.out.println("Increasing Subsequence: "+sequence);
		return lis[arr.length-1];
	}
	


	public static void main(String[] args) {
		int[] arr = {10,22,9,33,21,50,41,60};
		System.out.println(getLongestSubsequence(arr));
	}

}
