package com.example.test;

import java.util.*;

public class Back2Front {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split("\\W");
			StringBuffer output = new StringBuffer();
			for (int i = input.length - 1; i >= 0; i--) {
				output.append(input[i]).append(" ");
			}
			System.out.println(output.toString());

		}

	}

}
