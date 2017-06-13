package com.dynamicprogramming;

public class MaximumIncreasingSubsequence {
	
	public static int getMIS(int[] arr){
		int[] T = new int[arr.length];
		int[] seq = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
			T[i]=arr[i];
			seq[i]=i;
		}
		
		for(int i=1;i<arr.length;i++)
			for(int j=0;j<i;j++){
				if(arr[j] < arr[i]){
					T[i] = (T[i] > T[j]+arr[i])? T[i]:T[j]+arr[i];
				}
			}
		
		int max = T[0];
		int index = 0;
		for(int k=1;k<T.length;k++){
			if(max < T[k]){
				max = T[k];
				index = k;
			}
		}
		String path = arr[index]+" ";
		int temp = max-arr[index];
		for(int i=index;i>=0;i--){
			if(T[i] == temp){
				path=arr[i]+" "+path;
				temp=temp-arr[i];
			}
		}
		System.out.println("Actual Elements: "+path);
		
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {1,101,10,2,3,100,4};
		System.out.println("Maximum Sum of Increasing Subsequence is:"+getMIS(arr));

	}

}
