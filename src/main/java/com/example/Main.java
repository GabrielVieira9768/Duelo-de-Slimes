package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Jogador 1, escolha o tipo do Slime A (1) Vampiro, (2) Dragão, (3) Sereia, (4) Anjo, (5) Demônio:");
        Slime A = criarSlime(input.nextInt());

        System.out.println("Jogador 2, escolha o tipo do Slime B (1) Vampiro, (2) Dragão, (3) Sereia, (4) Anjo, (5) Demônio:");
        Slime B = criarSlime(input.nextInt());

        Duelo duelo = new Duelo(A, B);
        duelo.iniciar();

        input.close();
    }

    private static Slime criarSlime(int escolha) {
        switch (escolha) {
            case 1:
                return new SlimeVampiro();
            case 2:
                return new SlimeDragao();
            case 3:
                return new SlimeSereia();
            case 4:
                return new SlimeAnjo();
            case 5:
                return new SlimeDemonio();
            default:
                System.out.println("Escolha inválida, criando Slime Vampiro por padrão.");
                return new SlimeVampiro();
        }
    }
}
