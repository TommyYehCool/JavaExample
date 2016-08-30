package com.exfantasy.example;

public class StaticExampleDemo {
	public static void main(String[] args) {
        System.out.println("動物有" + StaticExampleAnimal.getNumber() + "隻");
         
        StaticExampleAnimal puppy1 = new StaticExampleAnimal(6, 70);
        puppy1.speak();
         
        StaticExampleAnimal puppy2 = new StaticExampleAnimal(142);
        puppy2.speak();
         
        StaticExampleAnimal puppy3 = new StaticExampleAnimal();
        puppy3.speak();
         
        System.out.println("動物有" + StaticExampleAnimal.getNumber() + "隻");
    }
}
