package com.test.tett;

import org.junit.Test;

public class Reversel {
	//递归算法
	@Test
	public void test() {
		String st = "abcdefghigklmn";
		System.out.println(reversel(st));
	}
	
	public static  String reversel(String st){
		
		int lengh = st.length();
		if (lengh<=1) {
			return st;
		}
		String left = st.substring(0, lengh/2);
		String right = st.substring(lengh/2, lengh);
		
		return reversel(right)+reversel(left);
		
		
		
		
	}
	
	
}
