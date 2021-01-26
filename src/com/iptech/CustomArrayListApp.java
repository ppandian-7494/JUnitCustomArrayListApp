package com.iptech;

public class CustomArrayListApp {

	public static void main(String[] args) {
		CustomList<Integer> numbers = new CustomArrayList<>();
		for (int i=1; i<=11; i++) {
			numbers.add(i);
			System.out.println(numbers.get(i-1));
		}
		
		for (int i=0; i < numbers.getSize(); i++) {
			System.out.println(numbers.get(i));
		}
	}

}
