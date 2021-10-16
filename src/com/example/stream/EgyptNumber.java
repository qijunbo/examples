package com.example.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EgyptNumber {

	public static void main(String[] args) {
		final int SCAL = 32;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split("/");
			BigDecimal a = new BigDecimal(input[0]);
			BigDecimal b = new BigDecimal(input[1]);
		 
			System.out.println(create(a.divide(b,SCAL ,RoundingMode.HALF_UP)));
		}
	}

	private static String create(BigDecimal d) {
		List<Double> result = new ArrayList<>();
		BigDecimal sum = BigDecimal.ZERO;
		for (double i = 2; i < Integer.MAX_VALUE; i += 1) {
			BigDecimal temp = new BigDecimal(1 / i);
			if (d.subtract(sum).compareTo(temp) > 0) {
				result.add(i);
				sum = sum.add(temp);
			}
			if (d.compareTo(sum) == 0) {
				break;
			}
		}

		return result.stream().map(x -> "1/" +x).collect(Collectors.joining("+"));
	}

}
