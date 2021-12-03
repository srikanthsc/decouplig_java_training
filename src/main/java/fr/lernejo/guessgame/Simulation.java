package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private long maximum;

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0;
        this.maximum = 0;
    }

    public void initialize(long numberToGuess, long maxTry) {
        this.numberToGuess = numberToGuess;
        this.maximum = maxTry;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long userGuess = player.askNextGuess();

        if (userGuess == numberToGuess) return true;
        else {
            player.respond(userGuess < numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean continueGame;
        int tryNumber = 0;

        long gameBegin = System.currentTimeMillis();
        do {
            tryNumber++;
            continueGame = nextRound();
        } while (!continueGame && tryNumber < maximum);
        long gameEnd = System.currentTimeMillis();

        long timeInGame = gameEnd - gameBegin;

        if (continueGame) {
            logger.log("well done!!!!!!!!!!!!!");
            logger.log("The number was " + numberToGuess);
            logger.log("It took you " + tryNumber + " try again.");
        } else logger.log("not good " + numberToGuess);

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        Date resultTime = new Date(timeInGame);
        logger.log("Time in-game: " + sdf.format(resultTime));
    }
}
