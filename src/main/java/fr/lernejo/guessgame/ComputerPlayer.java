package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.Scanner;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("ComputerPlayer");
    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;
    private long player;

    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        long guess = random.nextLong(min, max);

        logger.log("Guessed " + guess);

        player = guess;
        return guess;

    }



    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            logger.log("This number is lower.");
            max = player;
        } else {
            logger.log("This number is higher.");
            min = player;
        }
    }
}

