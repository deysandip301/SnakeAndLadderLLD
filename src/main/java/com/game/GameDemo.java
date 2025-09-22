package com.game;

import com.game.core.Game;
import com.game.entities.HumanPlayer;
import com.game.entities.Player;
import com.game.factories.KillingStrategyFactory;
import com.game.factories.WinningStrategyFactory;
import com.game.strategies.killing.KillingStrategy;
import com.game.strategies.killing.KillingStrategyType;
import com.game.strategies.winning.WinningStrategy;
import com.game.strategies.winning.WinningStrategyType;
import java.util.List;

public class GameDemo {
    public static void main(String[] args) {
        try {
            List<Player> players = List.of(
                    new HumanPlayer("Alice"),
                    new HumanPlayer("Bob"));

            // Option 1: Simple game creation with default strategies
            // Uncomment this block and comment the next one to use default strategies
            /*
            Game snakeAndLadderGame = Game.builder()
                    .withPlayers(players)
                    .withRandomLayout(100)
                    .build(); // Uses default strategies automatically!
            */

            // Option 2: Game creation with custom strategies
            Game.Builder gameBuilder = Game.builder()
                    .withPlayers(players)
                    .withRandomLayout(100);

            // Optional: You can customize strategies or leave them as default
            WinningStrategy winningStrategy = WinningStrategyFactory
                    .createWinningStrategy(WinningStrategyType.EXACT_MATCH);
            KillingStrategy killingStrategy = KillingStrategyFactory
                    .createKillingStrategy(KillingStrategyType.START_AGAIN);

            gameBuilder.withWinningStrategy(winningStrategy);
            gameBuilder.withKillingStrategy(killingStrategy);

            Game snakeAndLadderGame = gameBuilder.build();
            snakeAndLadderGame.start();

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error during game setup: " + e.getMessage());
        }
    }
}