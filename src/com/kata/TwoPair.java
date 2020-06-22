package com.kata;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class TwoPair {
	
	public LinkedHashSet<Integer> isTwoPair(List<Integer> values) {
		
		int pair1Value = 0;
		int pair2Value = 0;
		int remainingValue = 0;
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		
		for (Integer value: values) {
			if (Collections.frequency(values, value) == 2) {
				if (pair1Value == 0) {
					pair1Value = value;
				}
				if (pair2Value == 0 && pair1Value != value) {
					pair2Value = value;
				}
			} else {
				remainingValue = value;
			}
		}
		if (pair1Value == 0 || pair2Value == 0) {
			return set;
		} else if (pair1Value > pair2Value) {
			set.add(pair1Value);
			set.add(pair2Value);
		} else {
			set.add(pair2Value);
			set.add(pair1Value);
		}
		
		set.add(remainingValue);
		
		return set;
	}

}
