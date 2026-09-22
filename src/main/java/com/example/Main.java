package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di cavalli: ");
        int numeroCavalli = scanner.nextInt();

        int lunghezzaPercorso = 100;

        Cavallo[] cavalli = new Cavallo[numeroCavalli];

        for (int i = 0; i < numeroCavalli; i++) {

            System.out.print("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nome = scanner.next();

            cavalli[i] = new Cavallo(nome, lunghezzaPercorso);
        }

        System.out.println();
        System.out.println("--- INIZIO GARA ---");
        System.out.println();

        for (int i = 0; i < numeroCavalli; i++) {
            cavalli[i].start();
        }

        for (int i = 0; i < numeroCavalli; i++) {
            cavalli[i].join();
        }

        System.out.println();
        System.out.println("-> gara terminata <-");
        scanner.close();
    }
}