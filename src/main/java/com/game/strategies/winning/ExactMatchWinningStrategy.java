package com.game.strategies.winning;

public class ExactMatchWinningStrategy implements WinningStrategy {
    @Override
    public boolean hasWon(int position, int boardSize) {
        return position == boardSize;
    }

    @Override
    public int calculateNewPosition(int currentPosition, int diceRoll, int boardSize) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > boardSize) {
            // In exact match strategy, if the roll would overshoot, player stays at current
            // position
            System.out.println(
                    "Exact match required! Roll would overshoot the board. Staying at position " + currentPosition);
            return currentPosition;
        }
        return newPosition;
    }
}