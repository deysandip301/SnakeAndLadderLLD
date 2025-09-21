package com.game.strategies.winning;

public interface WinningStrategy {
    boolean hasWon(int position, int boardSize);
}