package com.exfantasy.example.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCollection {

	@Test
	public void testList() {
		List<Integer> numsList = new ArrayList<>();
		numsList.add(1);
		System.out.println(numsList.contains(1));
		numsList.add(1);
		System.out.println(numsList.size());
	}
}
