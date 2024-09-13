package com.example;

public class SlimeDemonio extends Slime {
    public SlimeDemonio(){
        super.especial = "Ganha 0.2 de multiplicador de dano pelo resto do jogo.";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if(this.energia >= 4){
            System.out.println(nomeSlime + " usou a habilidade especial!");
            this.decrementarEnergia(4);
            this.multiplicador += 0.2;
            System.out.println(nomeSlime + " teve seu multiplicador aumentado em 0.2!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }
}
