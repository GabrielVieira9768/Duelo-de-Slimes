package com.example;

public class SlimeSereia extends Slime {
    public SlimeSereia(){
        super.especial = "Fica com 2 de energia para zerar a energia do alvo (precisa de 6 de energia para usar).";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if(this.energia >= 6){
            System.out.println(nomeSlime + " usou a habilidade especial!");
            this.energia = 2;
            inimigo.energia = 0;
            System.out.println((nomeSlime.equalsIgnoreCase("Slime A") ? "Slime A" : "Slime B") + " teve sua energia reduzida para 2!");
            System.out.println((nomeSlime.equalsIgnoreCase("Slime A") ? "Slime B" : "Slime A") + " teve sua energia reduzida para 0!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }
}
