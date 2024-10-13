package com.example.demo.dao;

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
