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
    private long Max_value;

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0;//TODO implement me
        this.Max_value=0;
    }

    public void initialize(long numberToGuess,long Max_value) { //public void initialize

        this.numberToGuess = numberToGuess;
        this.Max_value = Max_value;
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

        boolean detail_game = true;
        boolean Game_s;
        int mynumber_increment = 0;
        int seconnumber;
        int number2;
        long tmp_start = System.currentTimeMillis(); // commencement du jeu start


        do {
            mynumber_increment++;

            detail_game = nextRound();
            logger.log("player" + player);
            logger.log("detail " + detail_game);
        }while (!detail_game && mynumber_increment < maximum) ;

            long tmp_fin = System.currentTimeMillis();
            System.out.println("Calcul du temps");
            long time_result = tmp_fin - tmp_start;

        if (detail_game) {
          //  logger.log("player" + player);
           // logger.log("detail " + detail_game);
        } else logger.log("numero du guess: " + numberToGuess);



        System.out.println("Date au format mm:ss.SSS");
        SimpleDateFormat simpledateformat = new SimpleDateFormat("mm:ss.SSS");
        Date date_result = new Date(time_result);
        logger.log("time detail "+simpledateformat.format(date_result));
    }
}

