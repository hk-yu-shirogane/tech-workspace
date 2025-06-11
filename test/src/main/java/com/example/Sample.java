package com.example;

public class Sample {
    public static String calculateGrade(int score) {
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else {
            grade = "D";
        }
        return grade;
    }

    public static void main(String[] args) {
        int score = 85;  // 任意のスコア
        String result = calculateGrade(score);
        System.out.println("成績は " + result + " です");
    }
}
