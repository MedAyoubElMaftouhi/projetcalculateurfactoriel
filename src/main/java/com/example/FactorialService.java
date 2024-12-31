package com.example;

public class FactorialService {
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Le nombre doit être supérieur strictement à zero.");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
