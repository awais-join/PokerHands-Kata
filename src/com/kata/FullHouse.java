package com.kata;

import java.util.List;
import java.util.Set;

public class FullHouse {
	
	public int isFullHouse(List<Integer> values) {
	
		ThreeOfAKind threeOfAKind = new ThreeOfAKind();
		int threeOfAKindValue = threeOfAKind.isThreeOfAKind(values);
		
		Pair pair = new Pair();
		Set<Integer> pairValues = pair.isPair(values);
		int pairValue = pairValues.isEmpty() ? 0 : pairValues.iterator().next();
		
		if (pairValue == 0 || threeOfAKindValue == 0) {
			return 0;
		}
		
		return threeOfAKindValue;
	}

}
