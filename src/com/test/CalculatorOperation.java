package com.test;

public class CalculatorOperation {

	public static void main(String[] args) {
		
		Calculator calculator = (n1, n2)->n1+n2;
		System.out.println("****Perform addition****");
		System.out.println(calculator.operate(22.0, 12.0));
		
		calculator = (n1, n2)->n1*n2;
		System.out.println("****Perform multiplication****");
		System.out.println(calculator.operate(2.0, 12.0));
		calculator.hello();

	}

}
