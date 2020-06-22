package com.kata;

import java.util.List;

public class Flush {
	
	public boolean isFlush(List<String> suites) {
		return suites.stream().allMatch(s -> suites.get(0).equals(s));
	}

}
