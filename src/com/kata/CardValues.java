package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardValues {
	
	List<Integer> values = new ArrayList<>(5);
	List<String> suites = new ArrayList<>(5);
	String[] splits;
	
	public CardValues(List<String> hand) {
		for (String str: hand) {
			splits = str.split("");
			values.add(faceValueToInt(splits[0]));
			suites.add(splits[1]);
		}
		Collections.sort(values);
	}
	
	private int faceValueToInt(String str) {
		
		switch (str) {
			case "T":
				return 10;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
			case "A":
				return 14;
			default:
				return Integer.parseInt(str);
		}
		
	}
}
