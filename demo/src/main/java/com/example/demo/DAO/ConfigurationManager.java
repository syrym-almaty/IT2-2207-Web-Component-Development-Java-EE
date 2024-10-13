package com.example.demo.DAO;
public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // Загрузите конфигурацию
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
}
