package com.example;

public class SlimeDragao extends Slime {
    public SlimeDragao() {
        super.especial = "Ganha 0.2 de multiplicador de dano e invulnerabilidade por um turno.";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if (this.energia >= 4) {
            System.out.println(nomeSlime + " usou a habilidade especial!");
            decrementarEnergia(4);
            this.multiplicador += 0.2;
            System.out.println(nomeSlime + " teve seu multiplicador aumentado em 0.2 neste turno!");
            ativarInvulnerabilidade();
            System.out.println(nomeSlime + " está invulnerável neste turno!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }
}
