package com.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Runner {

	public static void main(String[] args) {

		String[] input = { "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH",
				"Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S", 
				"Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH",
				"Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH" };
		
		for (String str: input) {
			playPokerHands(str);
		}

	}

	static void playPokerHands(String input) {
		String[] splits = input.split("  ");

		String p1Input = splits[0];
		String p2Input = splits[1];

		String player1 = p1Input.split(":")[0];
		String player2 = p2Input.split(":")[0];

		List<String> player1Hand = new ArrayList<>();
		List<String> player2Hand = new ArrayList<>();

		for (String card : p1Input.split(":")[1].trim().split(" ")) {
			player1Hand.add(card);
		}

		for (String card : p2Input.split(":")[1].trim().split(" ")) {
			player2Hand.add(card);
		}

		Game game = new Game();

		game.play(player1Hand, player2Hand, player1, player2);
	}

}
