package com.example.demo.DAO;

public class ConfiguratonManager {
    private static ConfiguratonManager instance;

    private ConfiguratonManager() {}

    public static ConfiguratonManager getInstance() {
        if (instance == null) {
            instance = new ConfiguratonManager();
        }
        return instance;
    }
}
