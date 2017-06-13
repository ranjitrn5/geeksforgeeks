package com.dynamicprogramming;

public class LargestsumContiguousSubArray {
	
	//This function doesn't work if input array contains all negative numbers
	public static int getLargestSum(int[] arr){
		int currMax= 0, maxSoFar = 0;
		int start =0, s=0, end =0;
		for(int i=0;i<arr.length;i++){
			currMax+=arr[i];
			if(currMax < 0){
				currMax = 0;
				s=i+1;
			}
			else if(maxSoFar < currMax){
				maxSoFar = currMax;
				start =s;
				end = i;
			}
		}
		
		for(int j=start;j<=end;j++){
			System.out.print("{"+arr[j]+" }");
		}
		System.out.println("");
		return maxSoFar;
	}
	// Works for any input array
	public static int getLargestSumNew(int[] arr){
		int currMax = arr[0]; 
		int maxSoFar = arr[0];
		
		for(int i=1;i<arr.length;i++){
			currMax = Math.max(arr[i], currMax+arr[i]);
			maxSoFar = Math.max(maxSoFar, currMax);
			System.out.println("CurrMax= "+currMax+" Max So Far= "+maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] input = {-2,-3,4,-1,-2,1,5,-3};
		//System.out.println(getLargestSumNew(input));
		System.out.println(getLargestSum(input));

	}

}
