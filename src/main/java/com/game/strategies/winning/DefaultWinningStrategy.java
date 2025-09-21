package com.game.strategies.winning;

public class DefaultWinningStrategy implements WinningStrategy {
    @Override
    public boolean hasWon(int position, int boardSize) {
        return position == boardSize;
    }
}