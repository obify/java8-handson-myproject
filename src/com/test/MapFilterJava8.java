package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFilterJava8 {

	public static void main(String[] args) {
		Employee[] empArr = {
				new Employee("John", 500.67),
				new Employee("Jacky", 210.90),
				new Employee("Jacky", 210.90),
				new Employee("Rajiv", 10.56)
		};
		List<Employee> empList = Arrays.asList(empArr);
		
		//map
		List<Employee2> emp2List = 
				empList.parallelStream().map((e)->{
			Employee2 e2 = new Employee2(e.getName(), e.getSalary());
			return e2;
		}).collect(Collectors.toList());
		
		//just print
		emp2List.forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		
		//transform data
		List<String> newEmpList = empList.stream().
				map((e)->{
					if(e.getName().startsWith("J")) {
						return "Jacky";
					}
						return e.getName();
				})
				.collect(Collectors.toList());
		
		System.out.println("****get only names list****");
		System.out.println(newEmpList);

		System.out.println("****multiple filters*****");
		List<Employee> newEmpLs = empList.stream().filter((e)->{
			if(e.getSalary() > 20.0) {
				return true;
			}
			return false;
		})
		.filter(e->e.getName().startsWith("J"))
		.collect(Collectors.toList());
		
		newEmpLs.forEach((e)->System.out.println(e.getName()));
		
	}

}
