package com.dynamicprogramming;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Fibonacci {
	public static int getFibonacciNumberWithRecursion(int n){
		if(n<=1){
			return n;
		}
		else{
			return (getFibonacciNumberWithRecursion(n-1)+getFibonacciNumberWithRecursion(n-2));
		}
	}
	
	public static int getFiboWithTabulation(int n){
		int[] result = new int[n+1];
		result[0]=0;
		result[1]=1;
		for(int i=2;i<=n;i++){
			result[i]=result[i-1]+result[i-2];
		}
		return result[n];
	}
	
	public static int getFiboWithMemoization(int n){
		int[] lookup = new int[n+1];
		
		if(lookup[n]==0){
			if(n<=1){
				lookup[n]=n;
			}
			else{
				lookup[n]=getFiboWithMemoization(n-1)+getFiboWithMemoization(n-2);
			}
		}
		return lookup[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat formatter = new DecimalFormat("#0.00000");
		long startTime = System.currentTimeMillis();
		int n=40;
		//Scanner sc = new Scanner(System.in);
		
		System.out.println(getFibonacciNumberWithRecursion(n));
		//long endTime = System.currentTimeMillis();
		
		System.out.println("Recursion Runtime: ");
		System.out.print(formatter.format((System.currentTimeMillis()-startTime)/1000d)+" seconds");
		System.out.println("");
		
		startTime =0;
		startTime = System.currentTimeMillis();
		System.out.println(getFiboWithTabulation(n));
		System.out.println("Tabulation Runtime: ");
		System.out.print(formatter.format((System.currentTimeMillis()-startTime)/1000d)+" seconds");
		System.out.println("");
		
		startTime =0;
		startTime = System.currentTimeMillis();
		System.out.println(getFiboWithMemoization(n));
		System.out.println("Memoization Runtime: ");
		System.out.print(formatter.format((System.currentTimeMillis()-startTime)/1000d)+" seconds");
	}

}
