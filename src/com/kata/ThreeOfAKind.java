package com.kata;

import java.util.Collections;
import java.util.List;

public class ThreeOfAKind {
	
	public int isThreeOfAKind(List<Integer> values) {
		
		for (Integer value: values) {
			if (Collections.frequency(values, value) == 3) {
				return value;
			}
		}
		
		return 0;
	}

}
