public class SingletonPatternExample {

    static class Logger {
        private static Logger singleInstance = null;

        
        private Logger() {
            System.out.println("Logger initialized.");
        }
        public static Logger getInstance() {
            if (singleInstance == null) {
                synchronized (Logger.class) {
                    if (singleInstance == null) {
                        singleInstance = new Logger();
                    }
                }
            }
            return singleInstance;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 point to the same instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
