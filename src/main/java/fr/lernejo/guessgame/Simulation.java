package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import javax.lang.model.type.NullType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Simulation {
    private long maximum;
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0;//TODO implement me
    }

    public void initialize(long numberToGuess) { //public void initialize
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long user = player.askNextGuess();
        if (user == numberToGuess)
            return true;
        else {
            player.respond(user < numberToGuess);
        }
        return false;  //TODO implement me
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me

        boolean detail_game;
        boolean Game_s;
        int mynumber_increment = 0;
        int seconnumber;
        int number2;


        do {
            mynumber_increment++;

            detail_game = nextRound();
        } while (!detail_game && mynumber_increment < maximum);

        if (detail_game) {
            logger.log("player" + player);
            logger.log("detail " + detail_game);
        } else logger.log("numero du guess: " + numberToGuess);




    }
}
