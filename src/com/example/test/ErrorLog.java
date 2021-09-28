package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ErrorLog {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> errors = new ArrayList<>();
		Map<String, Integer> count = new HashMap<>();
	 
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			if(str.length() < 1) {
				sc.close();
				break;
			}
			String[] coup = str.split(" ");
			 
			String error = getName(coup[0]) + " " + coup[1];
		 
			if (!errors.contains(error)) {
				errors.add(error);
			}

			count.computeIfPresent(error, (k, v) -> {
				 return count.get(k) + 1 ;
			});
			count.computeIfAbsent(error, k-> 1);

		}
		if(errors.size() > 8 )
			errors = errors.subList(errors.size() - 8 , errors.size());
		
		for (String item : errors) {
			System.out.print(item);
			System.out.println( " " + count.get(item));
		}

	}
	
	public static String getName(String str) {
		if(str.indexOf('\\' )> 0){
			String n = str.substring(str.lastIndexOf('\\') + 1);
			if(n.length()> 16) {
				n = n.substring(n.length() - 16);
			}
			return n;
		}else {
			return str;
		}
	}

}
