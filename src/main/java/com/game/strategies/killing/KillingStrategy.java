package com.game.strategies.killing;

import com.game.entities.Player;
import java.util.Map;

public interface KillingStrategy {
    void apply(Player currentPlayer, int newPosition, Map<Player, Integer> playerPositions);
}