package com.dynamicprogramming;

public class LongestCommonSubsequence {

	public static int getLongestCommonSubsequence(char[] ch1, char[] ch2){
		int[][]lcs = new int[ch1.length+1][ch2.length+1];
		
		for(int i=0;i<lcs.length;i++){
			for(int j=0;j<lcs[i].length;j++){
				if(i==0 || j==0){
					lcs[i][j]=0;
				}
				else if(ch1[i-1]==ch2[j-1]){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else{
					lcs[i][j]=Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
			}
		}
		int index = lcs[ch1.length][ch2.length];
		int i = ch1.length, j=ch2.length;
		char[] arr = new char[index+1];
		while(i > 0 && j > 0){
			if(ch1[i-1] == ch2[j-1]){
				arr[index-1]=ch1[i-1];
				index--;
				i--;
				j--;
			}
			else
				if(lcs[i][j-1] > lcs[i-1][j]){
					j--;
				}
				else{
					i--;
				}
		}
		System.out.println("Longest Common Subsequence: ");
		for(int k=0;k<arr.length-1;k++){
			System.out.print(arr[k]+" ");
		}
		System.out.println("");
		return lcs[ch1.length][ch2.length];
	}
	

	public static void main(String[] args) {
		String s1= "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(getLongestCommonSubsequence(s1.toCharArray(), s2.toCharArray()));
	}

}
