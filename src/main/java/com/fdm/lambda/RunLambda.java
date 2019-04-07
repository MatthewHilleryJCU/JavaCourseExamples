package com.fdm.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunLambda {
	public static void main(String[] args) {
		useInterface(() -> {System.out.println("Hello"); });
		useInterface(() -> {System.out.println("World"); });
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		
		List<Integer> collect = numbers.stream().filter((number) -> { return number % 2 != 0;}).collect(Collectors.toList());
		
		System.out.println(collect);
	}
	
	public static void useInterface(Command command) {
		command.excute();
	}
}
