package com.example;

public class SlimeDragao extends Slime {
    private boolean invulneravel = false;

    public SlimeDragao() {
        super.especial = "Ganha 0.2 de multiplicador de dano e invulnerabilidade por um turno.";
    }

    @Override
    public void especial(Slime inimigo, String nomeSlime) {
        if (this.energia >= 4) {
            System.out.println(nomeSlime + " usou a habilidade especial!");
            decrementarEnergia(4);
            this.multiplicador += 0.2;
            System.out.println(nomeSlime + " teve seu multiplicador aumentado em 0.2 até o próximo turno!");
            ativarInvulnerabilidade();
            System.out.println(nomeSlime + " está invulnerável até o próximo turno!");
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }

    @Override
    public void decrementarVida(double vida){
        if(this.estaInvulneravel()){
            System.out.println("Este slime está invulnerável e não sofreu dano!");
        } else {
            this.vida -= vida;
            if(this.vida < 0){
                this.vida = 0;
            }
        }
    }

    public boolean estaInvulneravel() {
        return invulneravel;
    }

    public void ativarInvulnerabilidade() {
        this.invulneravel = true;
    }

    public void desativarInvulnerabilidade() {
        this.invulneravel = false;
    }
}
