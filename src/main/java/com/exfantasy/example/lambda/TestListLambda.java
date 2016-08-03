package com.exfantasy.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestListLambda {
	List<String> members = Arrays.asList("Tommy", "Jeff", "Beny", "Daniel", "Vincent", "Tony", "Tina");
	
	private void start() {
		testPrintListValues();
		
		testPredicate(true);
		
		testCombinePredicate();
	}
	
	private void testPrintListValues() {
		// Old
		long lStartTime = System.nanoTime();
		
		System.out.println("Print List Values Old Way:");
		for (String member : members) {
			System.out.println(member);
		}
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("------------------------------");
		
		// New 1
		lStartTime = System.nanoTime();
		
		System.out.println("Print List Values New Way1:");
		members.forEach(member -> System.out.println(member));
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("------------------------------");
		
		// New 2
		lStartTime = System.nanoTime();
		
		System.out.println("Print List Values New Way2:");
		members.forEach(System.out::println);
		System.out.println("Spent time: " + (System.nanoTime() - lStartTime));
		
		System.out.println("------------------------------");
	}

	private void testPredicate(boolean isBetterWay) {
		if (!isBetterWay) {
			System.out.println("<Normal way>");
			normalWay();
		}
		else {
			System.out.println("<Better way>");
			betterWay();
		}
		System.out.println("------------------------------");
	}

	private void normalWay() {
		System.out.println("<Member name start with T>");
		filter((str) -> str.startsWith("T"));
		
		System.out.println("<Member name end with y>");
		filter((str) -> str.endsWith("y"));
		
		System.out.println("<All member>");
		filter((str) -> true);
		
		System.out.println("<No member>");
		filter((str) -> false);
		
		System.out.println("<Member name length greater than 4>");
		filter((str) -> str.length() > 4);
	}
	
	private void filter(Predicate<String> condition) {
		for (String member : members) {
			if (condition.test(member)) {
				System.out.println(member + " ");
			}
		}
		System.out.println();
	}

	private void betterWay() {
		System.out.println("<Member name start with T>");
		betterFilter((str) -> str.startsWith("T"));
		
		System.out.println("<Member name end with y>");
		betterFilter((str) -> str.endsWith("y"));
		
		System.out.println("<All member>");
		betterFilter((str) -> true);
		
		System.out.println("<No member>");
		betterFilter((str) -> false);
		
		System.out.println("<Member name length greater than 4>");
		betterFilter((str) -> str.length() > 4);
	}
	
	private void betterFilter(Predicate<String> condition) {
		members.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name);
		});
	}
	
	private void testCombinePredicate() {
		Predicate<String> startsWithT = (member) -> member.startsWith("T");
		Predicate<String> endsWithY = (member) -> member.endsWith("y");
		
		members.stream()
			   .filter(startsWithT.and(endsWithY))
			   .forEach((member) -> System.out.println("Member name startsWithT and endsWithy: " + member));
	}

	public static void main(String[] args) {
		new TestListLambda().start();
	}
}
