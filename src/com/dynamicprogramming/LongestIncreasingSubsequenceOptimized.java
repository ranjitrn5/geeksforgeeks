package com.dynamicprogramming;

public class LongestIncreasingSubsequenceOptimized {
	public static int performBinarySearch(int[] arr, int[] T, int key, int high){
		int low =0;
		int len =high;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(arr[T[mid]]<key && mid<len && key < arr[T[mid+1]]){
				return mid+1;
			}
			else if(arr[T[mid]]<key){
				low= mid+1;
			}
			else{
				high = mid-1;
			}
		}
		return -1;
	}
	
	public static int getLongestIncreasingSubsequence(int[] arr){
		int[] T = new int[arr.length];
		int[] R = new int[arr.length];
		int len = 0;
		for(int i=0;i<arr.length;i++){
			R[i]=-1;
		}
		T[0]=0;
		for(int i=1;i<arr.length;i++){
			if(arr[T[0]] > arr[i]){
				T[0]=i;
			}
			else if(arr[T[len]] < arr[i]){
				len++;
				T[len]=i;
				R[T[len]]=T[len-1];
			}
			else{
				int index = performBinarySearch(arr,T, arr[i],len);
				T[index]=i;
				R[T[index]]=T[index-1];
			}
		}
		return len+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,22,9,33,21,50,41,60};
		System.out.println(getLongestIncreasingSubsequence(arr));

	}

}
