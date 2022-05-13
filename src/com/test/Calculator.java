package com.test;

@FunctionalInterface
public interface Calculator {

	public Double operate(Double num1, Double num2);
	
	default void hello() {
		System.out.println("Calculator.hello()");
	}
}
