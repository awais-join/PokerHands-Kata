package com.kata;

import java.util.Collections;
import java.util.List;

public class Straight {
	
	public boolean isStraight(List<Integer> values) {
		
		Collections.sort(values);
		
		for (int i = 0; i < values.size() - 1; i++) {
			int current = values.get(i);
			int next = values.get(i + 1);
			if (!(current + 1 == next || (current == 14 && next == 2))) {
				return false;
			}
		}
		
		return true;
	}

}
