package com.fdm.comparrisons;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class RunComparrisons {
	
	public static class IntComparator implements Comparator<Integer> {
		public int compare(Integer first, Integer second) {
			return second - first;
		}
	}
	
	public static void main(String[] args) {
		TreeMap<Integer, Object> numbers = new TreeMap<>(new IntComparator());
		numbers.put(77, null);
		numbers.put(1, null);
		numbers.put(3, null);
		System.out.println(numbers);
		
		TreeSet<Games> games = new TreeSet<Games>();
		games.add(new Games("Mario Odyssey", 40.00f, 90));
		games.add(new Games("Pokemon Let's Go", 59.99f, 86));
		games.add(new Games("Zelda BOTW", 79.99f, 100));
		games.add(new Games("Zelda", 71.99f, 78));
		games.add(new Games("Zelda", 99.99f, 10));
//		System.err.println(games);
		games.forEach(System.out::println);
	}
}
