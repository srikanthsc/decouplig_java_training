package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("ComputerPlayer");
    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        return middle();

    }

    private long middle() {
        return (min - max) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            max = middle();
        } else {
            min = middle();
        }
    }
}

