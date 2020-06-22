package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Pair {
	
	public LinkedHashSet<Integer> isPair(List<Integer> values) {
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (Integer value: values) {
			if (Collections.frequency(values, value) == 2) {
				if (set.isEmpty()) {
					set.add(value);
				}
			} else {
				list.add(value);
			}
		}
		
		if (set.isEmpty()) {
			return set;
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		for (Integer i: list) {
			set.add(i);
		}
		
		return set;
	}

}
