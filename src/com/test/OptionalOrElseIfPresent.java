package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalOrElseIfPresent {

	public static void main(String[] args) {
		Employee[] empArr = {
				new Employee("Rajiv", 500.67),
				new Employee("Jacky", 210.90),
				new Employee("John", 10.56)
		};
		List<Employee> empList = Arrays.asList(empArr);
		
		try {
		Optional<Employee> optEmp = empList.stream().filter((e)->{
			if(e.getSalary() > 200.0) {
				return true;
			}
			return false;
		})
		//.filter(e->e.getName().startsWith("J"))
		.findFirst();
		//.findAny();
		
		if(!optEmp.isEmpty()) {
			System.out.println("Employee found, inside if of isEmpty");
			System.out.println("Name: "+optEmp.get().getName());
		}else {
			System.out.println("No match found, inside else of isEmpty");
		}
		optEmp.ifPresent(e->System.out.println("Salary: "+e.getSalary()));
		
		Employee emp = optEmp.orElse(new Employee("Default Employee", 0000.00));
		System.out.println("Default employee: "+emp.getName());
		
		optEmp.orElseThrow(()->new RuntimeException("not found"));
		
		}catch(RuntimeException ex) {
			ex.printStackTrace();
		}
		
	}

}
