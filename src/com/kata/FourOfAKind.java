package com.kata;

import java.util.Collections;
import java.util.List;

public class FourOfAKind {
	
	public int isFourOfAKind(List<Integer> values) {
		
		for (Integer value: values) {
			if (Collections.frequency(values, value) == 4) {
				return value;
			}
		}
		
		return 0;
	}

}
