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
        Player player = new HumanPlayer();
        Simulation start_simulation = new Simulation(player);
        SecureRandom random = new SecureRandom();
        // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

        start_simulation.initialize(randomNumber);
        start_simulation.loopUntilPlayerSucceed();

    }
}
