package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" type a value > ");
        String userinput = scanner.nextLine();
        long guess = Long.parseLong(userinput);
        return guess;




    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("input number was" + (lowerOrGreater ? "lower" : "greater"));


    }
}
