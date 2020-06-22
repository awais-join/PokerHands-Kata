package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighCard {

	public List<Integer> highCard(List<Integer> values) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(values);
		Collections.sort(list);
		Collections.reverse(list);
		
		return list;
	}
	
}
