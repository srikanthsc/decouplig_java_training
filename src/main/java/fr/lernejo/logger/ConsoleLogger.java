package fr.lernejo.logger;

public class ConsoleLogger implements Logger { //implementation


    @Override
    public void log(String message) {
        System.out.println(message);
    } //methode log(),Créer ensuite une classe ConsoleLogger implémentant Logger et affichant le message passé en paramètre dans la console en utilisant System.out.
}
