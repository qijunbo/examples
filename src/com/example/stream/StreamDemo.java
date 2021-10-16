package com.example.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.Scanner;

public class StreamDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			int k = Integer.parseInt(input[input.length - 1]);
			final String x = input[input.length - 2];
			List<String> ans = Arrays.stream(input, 1, input.length - 2).filter(s -> isbrother(s, x)).sorted()
					.collect(Collectors.toList());
			ans.remove(x);
			System.out.println(ans.size());
			if (k - 1 < ans.size())
				System.out.println(ans.get(k - 1));
		}
	}

	public static boolean isbrother(String a, String b) {
		
        if(a.equals(b)){
            return false;
        }
       
        
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		Arrays.sort(as);
		Arrays.sort(bs);
		String astr = new String(as);
		String bstr = new String(bs);

		return astr.equals(bstr);
	}

}
