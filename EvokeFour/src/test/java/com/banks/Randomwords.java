package com.banks;

import java.util.Random;


public class Randomwords {

	
	
	public static String user="Raghu";
	
	public   String stp(){
		
		//String ho2 = "" ;

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		//System.out.println(user+output);
		
		return output;

		}	
	
	
public static void main(String[] args) {
	
	
	//ho2.stp();
	
	Randomwords h=new Randomwords();

	String raaaa=h.stp();
	
	System.out.println(user+raaaa);
	
	//System.out.println(raaaa);
}	
	
}
	
	
		

		
	

