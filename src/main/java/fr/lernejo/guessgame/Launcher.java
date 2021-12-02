package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.security.SecureRandom;
//import fr.lernejo.logger.Logger;
public class Launcher {
    public static Logger logger = LoggerFactory.getLogger("mylauncher");
    public static void main(String[] args){
       // Player player= new Player();
        //Simulation simulation = new Simulation(player);

        switch (args[0]) {
            // avec humain
            case "-interactive" : {
                Player player = new HumanPlayer();
                Simulation start_simulation = new Simulation(player);
                SecureRandom random = new SecureRandom();

                // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
                long randomNumber = random.nextLong(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
                logger.log("Avec humain");
                start_simulation.initialize(randomNumber,Long.MAX_VALUE);
                start_simulation.loopUntilPlayerSucceed();
                break;


            }
             //moi-meme
            case "-auto": {
                Player player = new ComputerPlayer();
                Simulation start_simulation = new Simulation(player);
                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextLong(100);
                logger.log("Moi-meme");
                start_simulation.initialize(randomNumber,Long.parseLong(args[1]));
                start_simulation.loopUntilPlayerSucceed();
                break;
            }
        }
    }
}
