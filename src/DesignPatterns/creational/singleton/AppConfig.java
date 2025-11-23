package DesignPatterns.creational.singleton;

// This is called Double Checked Locking.
public class AppConfig {

    private static volatile AppConfig instance;

    private AppConfig() {
    }   // private constructor

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
}


