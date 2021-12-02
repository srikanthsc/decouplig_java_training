package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        long guess = 0;
        Scanner scanner = new Scanner(System.in);
        return guess;




    }

    @Override
    public void respond(boolean lowerOrGreater) {

    }
}
