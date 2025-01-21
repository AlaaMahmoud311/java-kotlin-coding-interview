package com.example.rps.service;

import com.example.rps.model.Move;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RpsService {
    private final Random random = new Random();

    public Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    public String determineWinner(Move playerA, Move playerB) {
        if (playerA == playerB) {
            return "DRAW";
        }
        return playerA.beats(playerB) ? "A" : "B";
    }
    public String playGames(int rounds) {
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            Move playerA = getRandomMove();  // Player A plays randomly
            Move playerB = Move.ROCK;       // Player B always plays ROCK

            String result = determineWinner(playerA, playerB);
            if (result.equals("A")) {
                playerAWins++;
            } else if (result.equals("B")) {
                playerBWins++;
            } else {
                draws++;
            }
        } return String.format("Player A wins %d of %d games%nPlayer B wins %d of %d games%nDraws: %d of %d games",
                playerAWins, rounds, playerBWins, rounds, draws, rounds);
    }

}
