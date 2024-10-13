package com.example.demo.dao;

public class GradingStrategyFactory {
    public static GradingStrategy getStrategy(String type){
        if(type.equals("letter")){
            return new LetterGradingStrategy();
        }

        return null;
    }
}
