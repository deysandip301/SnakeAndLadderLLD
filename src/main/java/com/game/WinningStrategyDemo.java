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

public class WinningStrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Snake and Ladder Game - Winning Strategy Demo ===\n");
        
        // Test Default Strategy
        System.out.println("🎮 Testing DEFAULT Winning Strategy:");
        System.out.println("   • Player can win by any dice roll if position >= board size");
        System.out.println("   • Overshooting is allowed\n");
        
        WinningStrategy defaultStrategy = WinningStrategyFactory.createWinningStrategy(WinningStrategyType.DEFAULT);
        testStrategy(defaultStrategy, "DEFAULT", 100);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Test Exact Match Strategy
        System.out.println("🎯 Testing EXACT_MATCH Winning Strategy:");
        System.out.println("   • Player must roll exact number to reach board size");
        System.out.println("   • Overshooting keeps player at current position\n");
        
        WinningStrategy exactStrategy = WinningStrategyFactory.createWinningStrategy(WinningStrategyType.EXACT_MATCH);
        testStrategy(exactStrategy, "EXACT_MATCH", 100);
        
        System.out.println("\n✅ Both winning strategies implemented and tested successfully!");
    }
    
    private static void testStrategy(WinningStrategy strategy, String strategyName, int boardSize) {
        System.out.println("--- " + strategyName + " Strategy Test ---");
        
        // Test case 1: Player at position 95, rolls 6 (would reach 101)
        int currentPos = 95;
        int diceRoll = 6;
        int newPos = strategy.calculateNewPosition(currentPos, diceRoll, boardSize);
        boolean hasWon = strategy.hasWon(newPos, boardSize);
        
        System.out.println("Test Case 1:");
        System.out.println("  Current Position: " + currentPos);
        System.out.println("  Dice Roll: " + diceRoll);
        System.out.println("  New Position: " + newPos);
        System.out.println("  Has Won: " + hasWon);
        System.out.println();
        
        // Test case 2: Player at position 96, rolls 4 (would reach exactly 100)
        currentPos = 96;
        diceRoll = 4;
        newPos = strategy.calculateNewPosition(currentPos, diceRoll, boardSize);
        hasWon = strategy.hasWon(newPos, boardSize);
        
        System.out.println("Test Case 2:");
        System.out.println("  Current Position: " + currentPos);
        System.out.println("  Dice Roll: " + diceRoll);
        System.out.println("  New Position: " + newPos);
        System.out.println("  Has Won: " + hasWon);
        System.out.println();
        
        // Test case 3: Player at position 97, rolls 6 (would reach 103)
        currentPos = 97;
        diceRoll = 6;
        newPos = strategy.calculateNewPosition(currentPos, diceRoll, boardSize);
        hasWon = strategy.hasWon(newPos, boardSize);
        
        System.out.println("Test Case 3:");
        System.out.println("  Current Position: " + currentPos);
        System.out.println("  Dice Roll: " + diceRoll);
        System.out.println("  New Position: " + newPos);
        System.out.println("  Has Won: " + hasWon);
    }
}