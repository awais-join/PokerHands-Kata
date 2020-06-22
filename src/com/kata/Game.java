package com.kata;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Game {

	public void play(List<String> player1Hand, List<String> player2Hand, String player1, String player2) {

		CardValues player1Values = new CardValues(player1Hand);
		CardValues player2Values = new CardValues(player2Hand);

		HighCard highCard = new HighCard();

		List<Integer> p1HighList = highCard.highCard(player1Values.values);
		List<Integer> p2HighList = highCard.highCard(player2Values.values);

		int p1HighValue = p1HighList.get(0);
		int p2HighValue = p2HighList.get(0);

		Flush flush = new Flush();

		boolean isP1Flush = flush.isFlush(player1Values.suites);
		boolean isP2Flush = flush.isFlush(player2Values.suites);

		Straight straight = new Straight();

		boolean isP1Straight = straight.isStraight(player1Values.values);
		boolean isP2Straight = straight.isStraight(player2Values.values);

		boolean p1IsStraightFlush = isP1Flush && isP1Straight;
		boolean p2IsStraightFlush = isP2Flush && isP2Straight;

		// Straight Flush winner.
		if (p1IsStraightFlush && !p2IsStraightFlush) {
			System.out.println(player1 + " wins. - with a straight flush.");
			return;
		} else if (!p1IsStraightFlush && p2IsStraightFlush) {
			System.out.println(player2 + " wins. - with a straight flush.");
			return;
		} else if (p1IsStraightFlush && p2IsStraightFlush) {
			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with a straight flush.");
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with a straight flush.");
				return;
			} else {
				System.out.println("Tie.");
				return;
			}
		}

		FourOfAKind fourOfAKind = new FourOfAKind();

		int p1FourOfAKind = fourOfAKind.isFourOfAKind(player1Values.values);
		int p2FourOfAKind = fourOfAKind.isFourOfAKind(player2Values.values);

		// Four of a kind winner
		if (p1FourOfAKind != 0 && p2FourOfAKind == 0) {
			System.out.println(player1 + " wins. - four of a kind.");
			return;
		} else if (p1FourOfAKind == 0 && p2FourOfAKind != 0) {
			System.out.println(player2 + " wins. - four of a kind.");
			return;
		} else if (p1FourOfAKind != 0 && p2FourOfAKind != 0) {
			if (p1FourOfAKind > p2FourOfAKind) {
				System.out.println(player1 + " wins. - four of a kind.");
				return;
			} else if (p1FourOfAKind < p2FourOfAKind) {
				System.out.println(player2 + " wins. - four of a kind.");
				return;
			}
		}

		FullHouse fullHouse = new FullHouse();

		int p1FullHouseValue = fullHouse.isFullHouse(player1Values.values);
		int p2FullHouseValue = fullHouse.isFullHouse(player2Values.values);

		boolean isP1FullHouse = p1FullHouseValue != 0;
		boolean isP2FullHouse = p2FullHouseValue != 0;

		// Full house winner
		if (isP1FullHouse && !isP2FullHouse) {
			System.out.println(player1 + " wins. - with a full house.");
			return;
		} else if (!isP1FullHouse && isP2FullHouse) {
			System.out.println(player2 + " wins. - with a full house.");
			return;
		} else if (isP1FullHouse && isP2FullHouse) {
			if (p1FullHouseValue > p2FullHouseValue) {
				System.out.println(player1 + " wins. - with a full house.");
				return;
			} else {
				System.out.println(player2 + " wins. - with a full house.");
				return;
			}
		}

		// Flush winner
		if (isP1Flush && !isP2Flush) {
			System.out.println(player1 + " wins. - with a flush.");
			return;
		} else if (!isP1Flush && isP2Flush) {
			System.out.println(player2 + " wins. - with a flush.");
			return;
		} else if (isP1Flush && isP2Flush) {
			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with a flush.");
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with a flush.");
				return;
			} else {
				System.out.println("Tie.");
				return;
			}
		}

		// Straight winner
		if (isP1Straight && !isP2Straight) {
			System.out.println(player1 + " wins. - with a straight.");
			return;
		} else if (!isP1Straight && isP2Straight) {
			System.out.println(player2 + " wins. - with a straight.");
			return;
		} else if (isP1Straight && isP2Straight) {
			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with a straight.");
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with a straight.");
				return;
			} else {
				System.out.println("Game Tie.");
				return;
			}
		}

		ThreeOfAKind threeOfAKind = new ThreeOfAKind();

		int p1ThreeOfAKindValue = threeOfAKind.isThreeOfAKind(player1Values.values);
		int p2ThreeOfAKindValue = threeOfAKind.isThreeOfAKind(player2Values.values);

		boolean isP1ThreeOfAKind = p1ThreeOfAKindValue != 0;
		boolean isP2ThreeOfAKind = p2ThreeOfAKindValue != 0;

		// Three of kind winner
		if (isP1ThreeOfAKind && !isP2ThreeOfAKind) {
			System.out.println(player1 + " wins. - with a three of a kind.");
			return;
		} else if (!isP1ThreeOfAKind && isP2ThreeOfAKind) {
			System.out.println(player2 + " wins. - with a three of a kind.");
			return;
		} else if (isP1ThreeOfAKind && isP2ThreeOfAKind) {
			if (p1ThreeOfAKindValue > p2ThreeOfAKindValue) {
				System.out.println(player1 + " wins. - with a three of a kind.");
				return;
			} else if (p1ThreeOfAKindValue < p2ThreeOfAKindValue) {
				System.out.println(player2 + " wins. - with a three of a kind.");
				return;
			} else {
				System.out.println("Tie.");
				return;
			}
		}

		TwoPair twoPair = new TwoPair();

		LinkedHashSet<Integer> p1TwoPairSet = twoPair.isTwoPair(player1Values.values);
		LinkedHashSet<Integer> p2TwoPairSet = twoPair.isTwoPair(player2Values.values);

		Iterator<Integer> p1TwoPairSetIterator = p1TwoPairSet.iterator();
		Iterator<Integer> p2TwoPairSetIterator = p2TwoPairSet.iterator();

		// Two pair winner
		if (!p1TwoPairSet.isEmpty() && p2TwoPairSet.isEmpty()) {
			System.out.println(player1 + " wins. - with a two pair.");
			return;
		} else if (p1TwoPairSet.isEmpty() && !p2TwoPairSet.isEmpty()) {
			System.out.println(player2 + " wins. - with a two pair.");
			return;
		} else if (!p1TwoPairSet.isEmpty() && !p2TwoPairSet.isEmpty()) {

			int pair1Value = p1TwoPairSetIterator.next();
			int pair2Value = p2TwoPairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a two pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a two pair.");
				return;
			}

			pair1Value = p1TwoPairSetIterator.next();
			pair2Value = p2TwoPairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a two pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a two pair.");
				return;
			}

			pair1Value = p1TwoPairSetIterator.next();
			pair2Value = p2TwoPairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a two pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a two pair.");
				return;
			} else {
				System.out.println("Tie.");
				return;
			}
		}

		Pair pair = new Pair();

		Set<Integer> p1PairSet = pair.isPair(player1Values.values);
		Set<Integer> p2PairSet = pair.isPair(player2Values.values);

		Iterator<Integer> p1PairSetIterator = p1PairSet.iterator();
		Iterator<Integer> p2PairSetIterator = p2PairSet.iterator();

		// Pair winner
		if (!p1PairSet.isEmpty() && p2PairSet.isEmpty()) {
			System.out.println(player1 + " wins. - with a pair.");
			return;
		} else if (p1PairSet.isEmpty() && !p2PairSet.isEmpty()) {
			System.out.println(player2 + " wins. - with a pair.");
			return;
		} else if (!p1PairSet.isEmpty() && !p2PairSet.isEmpty()) {

			int pair1Value = p1PairSetIterator.next();
			int pair2Value = p2PairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a pair.");
				return;
			}

			pair1Value = p1PairSetIterator.next();
			pair2Value = p2PairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a pair.");
				return;
			}

			pair1Value = p1PairSetIterator.next();
			pair2Value = p2PairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a pair.");
				return;
			}

			pair1Value = p1PairSetIterator.next();
			pair2Value = p2PairSetIterator.next();

			if (pair1Value > pair2Value) {
				System.out.println(player1 + " wins. - with a pair.");
				return;
			} else if (pair1Value < pair2Value) {
				System.out.println(player2 + " wins. - with a pair.");
				return;
			} else {
				System.out.println("Tie.");
				return;
			}

		}

		// High card winner
		if (p1HighValue > p2HighValue) {
			System.out.println(player1 + " wins. - with high Card: " + intToName(p1HighValue));
			return;
		} else if (p1HighValue < p2HighValue) {
			System.out.println(player2 + " wins. - with high Card: " + intToName(p2HighValue));
			return;
		} else {

			p1HighValue = p1HighList.get(1);
			p2HighValue = p2HighList.get(1);

			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with high Card: " + intToName(p1HighValue));
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with high Card: " + intToName(p2HighValue));
				return;
			}

			p1HighValue = p1HighList.get(2);
			p2HighValue = p2HighList.get(2);

			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with high Card: " + intToName(p1HighValue));
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with high Card: " + intToName(p2HighValue));
				return;
			}

			p1HighValue = p1HighList.get(3);
			p2HighValue = p2HighList.get(3);

			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with high Card: " + intToName(p1HighValue));
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with high Card: " + intToName(p2HighValue));
				return;
			}

			p1HighValue = p1HighList.get(4);
			p2HighValue = p2HighList.get(4);

			if (p1HighValue > p2HighValue) {
				System.out.println(player1 + " wins. - with high Card: " + intToName(p1HighValue));
				return;
			} else if (p1HighValue < p2HighValue) {
				System.out.println(player2 + " wins. - with high Card: " + intToName(p2HighValue));
				return;
			} else {
				System.out.println("Tie.");
				return;
			}
		}

	}

	private String intToName(int value) {
		switch (value) {
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		case 14:
			return "Ace";
		default:
			return Integer.toString(value);
		}
	}
}
