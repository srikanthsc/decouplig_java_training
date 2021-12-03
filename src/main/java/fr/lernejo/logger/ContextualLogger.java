package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger logger;
    private final String name;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ContextualLogger(String name, Logger logger) {
        this.logger = logger;
        this.name = name;
    }

    @Override
    public void log(String message) {
        logger.log(LocalDateTime.now().format(formatter) + " " + name + " " + message);
    }
}
