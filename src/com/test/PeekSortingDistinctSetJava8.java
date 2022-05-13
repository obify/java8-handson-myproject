package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekSortingDistinctSetJava8 {

	public static void main(String[] args) {
		Employee2[] empArr = {
				new Employee2("John", 500.67),
				new Employee2("Jacky", 210.90),
				new Employee2("Jacky", 210.90),
				new Employee2("Rajiv", 10.56)
		};
		List<Employee2> empList = Arrays.asList(empArr);
		//map one object type to another - converter layer
		List<Employee2> emp2List = 
				empList.parallelStream().map((e)->{
			Employee2 e2 = new Employee2(e.getName(), e.getSalary());
			return e2;
		}).collect(Collectors.toList());
		
		// examples of sorting
		emp2List.forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		System.out.println("*******after asc salary sorting*******");
		emp2List.stream().sorted(
				(e1, e2) -> {
					if(e1.getSalary() > e2.getSalary()) {
						return 1;
					}
					return -1;
				}
			).forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		
		System.out.println("*******after desc salary sorting*******");
		emp2List.stream().sorted(
				(e1, e2) -> {
					if(e1.getSalary() > e2.getSalary()) {
						return -1;
					}
					return 1;
				}
			).forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		
		System.out.println("*******after asc name sorting n distinct name*******");
		Set<Employee2> emp2ListData = emp2List.stream()
		.sorted(
				(e1, e2) -> {
					return e1.getName().compareTo(e2.getName());
				}
			)
		.peek(
				(e)->{
					//System.out.print(e);
				}
		)
		.peek(
				(e)->{
					//System.out.print(e);
				}
		).collect(Collectors.toCollection(
				() -> new TreeSet<Employee2>((p1, p2) -> p1.getName().compareTo(p2.getName()))
		));
		emp2ListData.forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		
		System.out.println("*******after desc name sorting*******");
		emp2List.stream().sorted(
				(e1, e2) -> {
					return e2.getName().compareTo(e1.getName());
				}
			).forEach(e->System.out.println(e.getName() + " - "+e.getSalary()));
		
	}

}
