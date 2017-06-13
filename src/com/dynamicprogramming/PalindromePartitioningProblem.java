package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningProblem {
	
	public static int getMinCuts(String s){
		boolean[][] palindrome = new boolean[s.length()][s.length()];
		int[] cuts = new int[s.length()];
		
		for(int i=0;i<s.length();i++){
			palindrome[i][i]=true;
		}
		
		for(int currLength = 2; currLength <=s.length();currLength++)
			for(int i=0;i<s.length()-currLength+1;i++){
				int j = i+currLength-1;
				if(currLength == 2 && s.charAt(i) == s.charAt(j)){
					palindrome[i][j]=true;
				}
				else{
					if(s.charAt(i)==s.charAt(j) && palindrome[i+1][j-1]){
						palindrome[i][j]=palindrome[i+1][j-1];
					}
				}
			}
		
		for(int i=0;i<s.length();i++){
			if(palindrome[0][i]){
				cuts[i]=0;
			}
			else{
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (palindrome[j + 1][i] && temp > cuts[j] + 1) {
						temp = cuts[j] + 1;
					}
				}
				cuts[i]=temp;
			}
			
		}
		return cuts[s.length()-1];
	}
	
	public static List<String> palindromePartitioning(String str){
		List<String> result = new ArrayList<>();
		boolean[][] palindrome = new boolean[str.length()][str.length()];
		if(str == null){
			return result;
		}
		
		if(str.length() <= 1){
			result.add(str);
			return result;
		}
		
		for(int i=0;i<str.length();i++){
			palindrome[i][i]=true;
			result.add(str.substring(i,i+1));
		}
		
		for(int currLength = 2; currLength <=str.length();currLength++)
			for(int i=0;i<str.length()-currLength+1;i++){
				int j = i+currLength-1;
				if(currLength == 2 && str.charAt(i) == str.charAt(j)){
					palindrome[i][j]=true;
				}
				else if(str.charAt(i)==str.charAt(j) && palindrome[i+1][j-1]){
						palindrome[i][j]=palindrome[i+1][j-1];
					}
				if(palindrome[i][j]){
					result.add(str.substring(i, j+1));
				}
			}
		return result;
	}

	public static void main(String[] args) {
		String str = "aab";
		System.out.println("Minimum Cuts = "+getMinCuts(str));
		for(String s: palindromePartitioning(str)){
			System.out.print(s+" ");
		}

	}

}
