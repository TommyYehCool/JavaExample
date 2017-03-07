package com.exfantasy.example.basic;

class StaticExampleAnimal {
	private int age;
	private int weight;

	private static int number = 0;

	public StaticExampleAnimal(int a, int w) {
		number++;
		setAge(a);
		setWeight(w);
		System.out.println("Animal物件已建立....");
	}

	public StaticExampleAnimal(int w) {
		number++;
		setAge(3);
		setWeight(w);
		System.out.println("Animal物件已建立....");
	}

	public StaticExampleAnimal() {
		number++;
		setAge(3);
		setWeight(15);
		System.out.println("Animal物件已建立....");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int n) {
		if (n < 0) {
			age = 1;
		} else {
			age = n;
		}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int n) {
		if (n < 0) {
			weight = 1;
		} else {
			weight = n;
		}
	}

	public static int getNumber() {
		return number;
	}

	public void speak() {
		System.out.println("哈囉，我已經" + getAge() + "歲，有" + getWeight() + "公斤重");
	}
}