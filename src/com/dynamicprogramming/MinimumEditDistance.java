package com.dynamicprogramming;

public class MinimumEditDistance {

	public int minimumEditDistance(char[] str1, char[] str2){
		int dist;
		int[][] dp = new int[str2.length+1][str1.length+1];
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length;j++){
				if(i == 0){
					dp[i][j]=j;
				}
				else if(j == 0){
					dp[i][j]=i;
				}
				else if(str2[i-1] == str1[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}
				else{
					dp[i][j]=1+min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		
		printEditOperations(dp,str1,str2);
		
		return dp[str2.length][str1.length];
	}
	
	private void printEditOperations(int[][] temp, char[] ch1, char[] ch2){
		int i = temp.length-1;
		int j = temp[0].length-1;
		
		while(i!=0 || j!=0){
			if(ch2[i-1] == ch1[j-1]){
				i--;
				j--;
			}
			else if(temp[i][j]==temp[i][j-1]+1){
				System.out.println("Insert Operation in string2: "+ch1[i]);
				j--;
			}
			else if(temp[i][j]==temp[i-1][j-1]+1){
				System.out.println("Modify: "+ch2[j-1]+" in string 2 to "+ch1[i-1]+" in string 1");
				i--;
				j--;
			}
			else{
				System.out.println("Delete operation in String2: "+ch2[j]);
				i--;
			}

		}
	}
	
	private int min(int a, int b, int c){
		int temp = (a<b)?a:b;
		return (temp<c)?temp:c;
	}
	
	public static void main(String[] args) {
		String str1= "March";
		String str2 = "Cart";
		MinimumEditDistance md = new MinimumEditDistance();
		System.out.println(md.minimumEditDistance(str1.toCharArray(), str2.toCharArray()));
		
		
	}

}
