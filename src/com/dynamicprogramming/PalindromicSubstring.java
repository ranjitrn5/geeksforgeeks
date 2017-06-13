package com.dynamicprogramming;

public class PalindromicSubstring {
	// Has complexity of O(N^2)
	public static String findLPS(String str){
		int n = str.length();
		boolean[][] palindrome = new boolean[n][n];
		int maxLength =0, palindromeBeginsAt =0;
		
		for(int i=0;i<n;i++){
			palindrome[i][i]=true;
		}
		
		for(int i = 0;i<n-1;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				palindrome[i][i+1]=true;
				palindromeBeginsAt = i;
				maxLength = 2;
			}
		}
		
		for(int currLength = 3;currLength<=n;currLength++){
			for(int i=0;i<n-currLength+1;i++){
				int j = i+currLength-1;
				if(str.charAt(i) == str.charAt(j) && palindrome[i+1][j-1]){
					palindrome[i][j] = true;
					palindromeBeginsAt = i;
					maxLength = currLength;
				}
			}
		}
		System.out.println("Longest Palindrome Length: "+maxLength);
		
		if(palindromeBeginsAt!=0)
		{		
			return str.substring(palindromeBeginsAt, maxLength+1);
		}
		else{
			return str.substring(palindromeBeginsAt, maxLength);
		}
	}
	
	//Manacher's algorithm
	public static String getLPS(String s){
		char[] T = new char[s.length()*2+3];
		int[] P = new int[T.length];
		
		T[0] = '$';
		T[T.length-1] = '@';
		for(int i=0;i<s.length();i++){
			T[i*2+1] = '#';
			T[i*2+2] = s.charAt(i);
		}
		T[s.length()*2+1] = '#';
		int center = 0, right = 0, mirror = 0;
		for(int i=1;i<T.length-1;i++){
			mirror = 2*center - i;
			
			if(i < right){
				P[i] = Math.min(right-i, P[mirror]);
			}
			
			while(T[i+(1+P[i])] == T[i-(1+P[i])]){
				P[i]++;
			}
			
			if(i+P[i] > right){
				center = i;
				right = i+P[i];
			}
		}
		int length = 0;
		center = 0;
		for(int i=1;i<P.length-1;i++){
			if(P[i] > length){
				length = P[i];
				center = i;
			}
		}
		return s.substring((center-1-length)/2, (center-1+length)/2);
	}

	public static void main(String[] args) {
		String s = "abababa";
		System.out.println(findLPS(s));
		System.out.println(getLPS(s));

	}

}
