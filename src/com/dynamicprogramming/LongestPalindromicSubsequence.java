package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubsequence {
	
	public static int getLPS(String str){
		int n = str.length();
		int[][] palindrome = new int[n][n];
		
		for(int i=0;i<n;i++){
			palindrome[i][i]=1;
		}
		
		for(int currLength=2;currLength <=n;currLength++){
			for(int i=0;i<n-currLength+1;i++){
				int j = i+currLength-1;
				if(currLength == 2 && str.charAt(i) == str.charAt(j)){
					palindrome[i][j]=2;
				}
				else{
					if(str.charAt(i) == str.charAt(j)){
						palindrome[i][j] = 2+ palindrome[i+1][j-1];
					}
					else{
						palindrome[i][j] = Math.max(palindrome[i][j-1], palindrome[i+1][j]);
					}
				}
			}
		}
		printLPS(palindrome, str);
		return palindrome[0][n-1];
	}
	
	
	
	public static void printLPS(int[][] temp, String s){
		int length = temp[0][s.length()-1];
		int start = 0, end = length-1;
		int i = 0, j=s.length()-1;
		char[] tempArray = new char[length];
		while(start <= end){
			if(s.charAt(i) == s.charAt(j)){
				tempArray[start]=s.charAt(i);
				tempArray[end]=s.charAt(i);
				start++;
				end--;
				i++;
				j--;
				
			}
			else{
				if(temp[i+1][j] > temp[i][j-1]){
					i++;
				}
				else{
					j--;
				}
			}
		}
		/*if(start == end){
			tempArray[start] = s.charAt(i);
		}*/
		System.out.println("Longest Palindrome Subsequence: ");
		for(int k=0;k<tempArray.length;k++){
			System.out.print(tempArray[k]+" ");
		}
	}

	public static void main(String[] args) {
		String s = "adbgcfbea";
		System.out.println("");
		System.out.println("Length of Longest Palindromic Subsequence: "+getLPS(s));
	}

}
