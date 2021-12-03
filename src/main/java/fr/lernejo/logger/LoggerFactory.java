package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        ContextualLogger simul = new ContextualLogger(
            name,
            new CompositeLogger(
                new ConsoleLogger(),
                new FilteredLogger(new FileLogger("./mylogs.txt"),
                    message -> message.contains("simul")
                )
            )
        );
        return simul;
    }
}
