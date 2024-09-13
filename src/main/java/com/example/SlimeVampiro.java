package com.example;

public class SlimeVampiro extends Slime {
    public SlimeVampiro(){
        super.especial = "Causa 2 de dano e recupera 1 de vida.";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if(this.energia >= 4){
            System.out.println(nomeSlime + " usou a habilidade especial!");
            this.decrementarEnergia(4);
            this.aumentarVida(1);
            inimigo.decrementarVida(2);
            System.out.println((nomeSlime.equalsIgnoreCase("Slime A") ? "Slime A" : "Slime B") + " teve sua vida aumentada em 1!");
            System.out.println((nomeSlime.equalsIgnoreCase("Slime A") ? "Slime B" : "Slime A") + " sofreu 2 de dano!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }
}