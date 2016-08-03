package com.exfantasy.example.annotation;

public class TestClass {
  @MyAnnotation
  private String name;

//  @MyAnnotation(value = "Alice")
  @MyAnnotation
  public void test() {
    System.out.println("Hello");
  }
}
