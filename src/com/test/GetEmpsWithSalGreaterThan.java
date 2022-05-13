package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetEmpsWithSalGreaterThan {

	public static void main(String[] args) {
		Employee[] empArr = {
				new Employee("John", 500.67),
				new Employee("Jacky", 210.90),
				new Employee("Rajiv", 10.56)
		};
		List<Employee> empList = Arrays.asList(empArr);
		
		List<Employee> newList = 
				empList.stream()
				.filter(e->e.getSalary() > 20.00)
				.collect(Collectors.toList());
		
		System.out.println("*****Return only those employees whose salary>20****");
		newList.forEach(e->System.out.println(e.getName()));
		
		System.out.println("*****Remove the employee whose name starts with Jo****");
		newList.removeIf(e->e.getName().startsWith("Jo"));
		newList.forEach(e->System.out.println(e.getName()));

	}

}
