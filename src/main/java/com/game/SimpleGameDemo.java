package com.game;

import com.game.core.Game;
import com.game.entities.HumanPlayer;
import com.game.entities.Player;
import java.util.List;

public class SimpleGameDemo {
    public static void main(String[] args) {
        try {
            System.out.println("=== Simple Snake and Ladder Game ===");
            System.out.println("Using default strategies automatically!");
            System.out.println();
            
            // Create players
            List<Player> players = List.of(
                    new HumanPlayer("Alice"),
                    new HumanPlayer("Bob"));

            // Create game with minimal configuration - strategies will be default
            Game snakeAndLadderGame = Game.builder()
                    .withPlayers(players)
                    .withRandomLayout(100)
                    .build(); // No explicit strategies - uses defaults!

            // Start the game
            snakeAndLadderGame.start();

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error during game setup: " + e.getMessage());
        }
    }
}