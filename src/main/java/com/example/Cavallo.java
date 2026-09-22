package com.example;

import java.util.Random;

public class Cavallo extends Thread{

    private String nome;
    private int distanzaPercorsa = 0;
    private int lunghezzaPercorso;

    private static boolean vincitoreTrovato = false;

    public Cavallo(String nome, int lunghezzaPercorso){
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    @Override 
    public void run () {
        Random random = new Random();

        while (distanzaPercorsa < lunghezzaPercorso) {
            int metri = random.nextInt(10) + 1;
            distanzaPercorsa += metri;

            if (distanzaPercorsa > lunghezzaPercorso) {
                distanzaPercorsa = lunghezzaPercorso;
            }

            System.out.println("-" + nome + "- ha percorso " +distanzaPercorsa + "metri");

            try {
                int tempoSleep = random.nextInt(401) + 400;
                Thread.sleep(tempoSleep);
            } catch (InterruptedException e) {
                System.out.println("Il cavallo " + nome + "è stato interrotto");
            }
        }
        synchronized (Cavallo.class) {
            if(!vincitoreTrovato) {
                vincitoreTrovato = true;

                System.out.println();
                System.out.println("IL CAVALLO VINCENTE è " + nome);
                System.out.println();
            }
        }
    }  
}
