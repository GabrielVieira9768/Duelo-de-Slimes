package com.example;

import java.util.Scanner;

public class Duelo {
    private final Slime slimeA;
    private final Slime slimeB;
    private boolean jogoAtivo = true;

    public Duelo(Slime slimeA, Slime slimeB) {
        this.slimeA = slimeA;
        this.slimeB = slimeB;
    }

    public void iniciar() {
        Scanner input = new Scanner(System.in);
        int turno = 1;

        while (jogoAtivo) {
            Slime atacante = turno % 2 != 0 ? slimeA : slimeB;
            Slime defensor = turno % 2 != 0 ? slimeB : slimeA;
            String nomeSlime = turno % 2 != 0 ? "Slime A" : "Slime B";

            System.out.println("\n----------------\nTurno do " + nomeSlime + "\n----------------");
            exibirEstado(slimeA, slimeB);
            realizarJogada(atacante, defensor, input, nomeSlime);

            turno++;

            if (defensor instanceof SlimeDragao) {
                ((SlimeDragao)defensor).desativarInvulnerabilidade();
                defensor.resetarMultiplicador();
            }

            atacante.aumentarEnergia(2);
            atacante.desenergizar();
        }

        input.close();
    }

    private void realizarJogada(Slime atacante, Slime defensor, Scanner input, String nomeSlime) {
        int acao;
        do {
            System.out.println(nomeSlime + ", escolha uma ação:\n(0) Terminar Turno\n(1) Atacar\n(2) Energizar\n(3) Especial");
            acao = input.nextInt();

            switch (acao) {
                case 0:
                    System.out.println(nomeSlime + " terminou seu turno!");
                    break;
                case 1:
                    if(atacante.getEnergia() >= 1){
                        atacante.atacar(defensor);
                        System.out.println(nomeSlime + " atacou!");
                    break;
                    }
                case 2:
                    if(atacante.getEnergia() >= 2){
                        atacante.energizar();
                        System.out.println(nomeSlime + " energizou!");
                    }
                    break;
                case 3:
                    atacante.especial(defensor, nomeSlime);
                    break;
                default:
                    System.out.println("Ação inválida.");
            }

            exibirEstado(slimeA, slimeB);

            if (!slimeA.estaVivo() || !slimeB.estaVivo()) {
                jogoAtivo = false;
                System.out.println((slimeA.estaVivo() ? "Slime A" : "Slime B") + " venceu o duelo!");
                System.exit(0);
            }

        } while (acao != 0);
    }

    private void exibirEstado(Slime slimeA, Slime slimeB) {
        System.out.println("\nEstado do Slime A: Vida = " + slimeA.getVida() + ", Energia = " + slimeA.getEnergia());
        System.out.println("Estado do Slime B: Vida = " + slimeB.getVida() + ", Energia = " + slimeB.getEnergia());
    }
}