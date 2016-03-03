package com.cmm.leedcode.longestSubString003;
/**
 * 
 * @author cmm
 *    没弄明白2015-12-2
 */
public class LongestSubString {
public int lengthOfLongestSubString(String str){
	int res=0;
	int left=0;
	int prev[]=new int[200];
	for(int i=0;i<prev.length;i++){
		prev[i]=-1;
	}
	for(int i=0;i<str.length();i++){
		if(prev[str.charAt(i)]>=left){
			left=prev[str.charAt(i)]+1;
		}
		prev[str.charAt(i)]=i;
		System.out.println("prev[str.charAt(i)]="+prev[str.charAt(i)]);
		if(res<i-left+1) res=i-left+1;
	}
	return res;
}
	public static void main(String[] args) {
		String str="aabbbcccc";
		LongestSubString lsb=new LongestSubString();
		System.out.println(lsb.lengthOfLongestSubString(str));
	}

}
