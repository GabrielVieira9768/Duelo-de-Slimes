package com.example;

public class SlimeAnjo extends Slime {
    public SlimeAnjo(){
        super.especial = "Ganha 0.2 de resistência pelo resto do jogo.";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if(this.energia >= 4){
            System.out.println(nomeSlime + " usou a habilidade especial!");
            this.decrementarEnergia(4);
            this.resistencia += 0.2;
            System.out.println(nomeSlime + " teve sua resistência aumentada em 0.2!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }
}
