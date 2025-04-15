public class Logger {
    private static Logger instance = new Logger();

    private Logger() {
    }// its for private constructor prevents creation of additional instances

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {// this is method for displaying a message
        System.out.println(message);
    }
}