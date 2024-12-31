package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour, voici un outil calculateur factoriel!");
        System.out.print("Veuillez entrer un nobmre: ");
        int number = scanner.nextInt();
        System.out.println("Le factoriel du nombre " + number + " est: " + FactorialService.calculateFactorial(number));
        scanner.close();
    }
}
