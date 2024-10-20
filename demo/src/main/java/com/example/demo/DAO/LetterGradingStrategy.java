package com.example.demo.DAO;

public class LetterGradingStrategy implements GradingStrategy {
    @Override
    public Double calculateGrade(Double score) {
        // Convert numeric score to letter grade
        return score;
    }
}
