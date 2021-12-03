package fr.lernejo.logger;

public class CompositeLogger implements Logger {

    private final Logger fLogger;
    private final Logger sLogger;

    public CompositeLogger(Logger fLogger, Logger sLogger) {
        this.fLogger = fLogger;
        this.sLogger = sLogger;
    }

    @Override
    public void log(String message) {
        fLogger.log(message);
        sLogger.log(message);
    }
}
