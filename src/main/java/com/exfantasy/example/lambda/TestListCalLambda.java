package com.exfantasy.example.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TestListCalLambda {
	private List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
	private final double tax = 0.12;
	
	private List<String> members = Arrays.asList("Ben", "Tommy", "Alice", "Jeff");
	
	private List<Integer> testNumbers_1 = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
	
	private List<Integer> testPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

	private void start() {
		printTestDatas();
		
		testCostAfterTax();
		
		testPlusAllAfterTax();
		
		filterToNewList();
		
		applyFunctionOnEachElements();
		
		createSubListOfSquareOfAllDistinceTestNumbers_1();
		
		calcualteOfTestPrime();
	}

	private void printTestDatas() {
		System.out.printf("All cost %s with tax: %f %n", costBeforeTax, tax);
		
		System.out.printf("All members: %s %n", members);
		
		System.out.printf("Test Number 1: %s %n", testNumbers_1);
		
		System.out.printf("Test Prime: %s %n", testPrimes);
		
		System.out.println("-----------------------------------------------");
	}
	
	private void testCostAfterTax() {
		// Old Way
		long lStartTime = System.nanoTime();
		
		System.out.println("<Calculate all cost plus tax old way>");
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("-----------------------------------------------");
		
		// New Way
		lStartTime = System.nanoTime();
		
		System.out.println("<Calculate all cost plus tax new way>");
		costBeforeTax.stream()
					 .map((cost) -> cost + 0.12 * cost)
					 .forEach(System.out::println);
		
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("-----------------------------------------------");
	}

	private void testPlusAllAfterTax() {
		// Old Way
		long lStartTime = System.nanoTime();
		
		System.out.println("<Calculate plus all after tax old way>");
		
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			total += price;
		}
		System.out.println(total);
		
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("-----------------------------------------------");
		
		// New Way
		lStartTime = System.nanoTime();
		
		System.out.println("<Calculate plus all after tax new way>");
		
		total 
			= costBeforeTax.stream()
						   .map((cost) -> cost + 0.12 * cost)
						   .reduce((sum, cost) -> sum + cost)
						   .get();
		
		System.out.println(total);
		
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("-----------------------------------------------");
	}

	private void filterToNewList() {
		long lStartTime = System.nanoTime();
		
		List<String> newMembers
			= members.stream()
					 .filter(member -> member.length() > 4)
					 .collect(Collectors.toList());
		
		System.out.printf("Original members: %s, New members which name's length greater than 4: %s %n", members, newMembers);
		
		System.out.println("Spent Time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("-----------------------------------------------");
	}

	private void applyFunctionOnEachElements() {
		System.out.println("Test all members to upper case:");
		
		String allMembers 
			= members.stream()
					 .map(member -> member.toUpperCase()).collect(Collectors.joining(", "));
		
		System.out.println(allMembers);
		
		System.out.println("-----------------------------------------------");
	}

	private void createSubListOfSquareOfAllDistinceTestNumbers_1() {
		List<Integer> distinct 
			= testNumbers_1.stream()
				     .map(i -> i * i)
				     .distinct()
				     .collect(Collectors.toList());
		
		System.out.printf("Original numbers: %s, Square without duplicates: %s %n", testNumbers_1, distinct);
	}

	private void calcualteOfTestPrime() {
		IntSummaryStatistics stats = testPrimes.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("Highest prime number is List: " + stats.getMax());
		System.out.println("Lowest prime number is List: " + stats.getMin());
		System.out.println("Sum of all prime numbers: " + stats.getSum());
		System.out.println("Average of all prime numbers: " + stats.getAverage());
	}

	public static void main(String[] args) {
		new TestListCalLambda().start();
	}
}
