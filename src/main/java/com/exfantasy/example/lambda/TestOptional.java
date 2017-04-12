package com.exfantasy.example.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptional {
	

	private void start() {
		testOptional();
	}
	
	private void testOptional() {
		Family tommy = new Family("Tommy", 1980);
		Family alice = new Family("Alice", 1985);
		
		List<Family> familys = new ArrayList<>();
		familys.add(tommy);
		familys.add(alice);
		
		Optional<Family> ageLessThan30 = 
			familys.stream().filter(f -> f.getAge() <= 30).findFirst();
		
		if (ageLessThan30.isPresent()) {
			System.out.println(ageLessThan30.get().getName() + " age is less than 30");
		}
		else {
			System.out.println("Nobody age less than 30");
		}
		
		Family fakeMan = ageLessThan30.orElse(new Family("FakeLessThan30", 2000));
		System.out.println(fakeMan);
		
		Optional<Family> ageOver35 = 
				familys.stream().filter(f -> f.getAge() >= 35).findFirst();

		if (ageOver35.isPresent()) {
			System.out.println(ageOver35.get().getName() + " age is over 35");
		}
		else {
			System.out.println("Nobody age over 35");
		}
		
		Family familyOver35 = ageOver35.orElse(new Family("FakeOver35", 1954));
		familyOver35.setIsOver30(true);
		System.out.println(familyOver35);
	}

	public static void main(String[] args) {
		new TestOptional().start();
	}
	
	private class Family {
		private String name;
		private int birthdayYear;
		private boolean isOver30;
		
		public Family(String name, int birthdayYear) {
			this.name = name;
			this.birthdayYear = birthdayYear;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			LocalDate dateOfToday = LocalDate.now();
			int year = dateOfToday.getYear();
			return year - birthdayYear;
		}
		
		public void setIsOver30(boolean isOver30) {
			this.isOver30 = isOver30;
		}
		
		public boolean isOver30() {
			return isOver30;
		}

		@Override
		public String toString() {
			return "Family [name=" + name + ", birthdayYear=" + birthdayYear + ", isOver30=" + isOver30 + "]";
		}
	}
}
