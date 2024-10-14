package com.example.demo.DAO;

public class GradingStrategyFactory {
    public static GradingStrategy getStrategy(String type) {
        if (type.equalsIgnoreCase("letter")) {
            return null;
        }
//        else if (type.equalsIgnoreCase("percentage")) {
//            return new PercentageGradingStrategy();
//        }
        return null;
    }
}
