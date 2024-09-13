package com.example;

public abstract class Slime {
    protected double vida = 10;
    protected double multiplicador = 1;
    protected double resistencia = 0;
    protected int energia = 5;
    protected String especial;
    private boolean energizado = false;
    private boolean invulneravel = false;

    public void atacar(Slime inimigo){
        if (this.energia > 0) {
            decrementarEnergia(1);
            double dano = this.multiplicador - inimigo.resistencia;
            if(this.energizado)
                dano += 0.5;
            inimigo.decrementarVida(dano);
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }

    public void energizar(){
        if(this.energia >= 2){
            decrementarEnergia(2);
            this.energizado = true;
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }

    public void desenergizar(){
        this.energizado = false;
    }

    public abstract void especial(Slime inimigo, String nomeSlime);

    public void decrementarEnergia(double energia){
        this.energia -= energia;
        if(this.energia < 0){
            this.energia = 0;
        }
    }

    public void aumentarEnergia(double energia){
        this.energia += energia;
    }

    public void decrementarVida(double vida){
        if (!invulneravel) {
            this.vida -= vida;
            if(this.vida < 0){
                this.vida = 0;
            }
        } else {
            System.out.println("Este slime está invulnerável e não sofreu dano!");
        }
    }

    public void aumentarVida(double vida){
        this.vida += vida;
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    public boolean isInvulneravel() {
        return invulneravel;
    }

    public void ativarInvulnerabilidade() {
        this.invulneravel = true;
    }

    public void desativarInvulnerabilidade() {
        this.invulneravel = false;
    }

    public void resetarMultiplicador(){
        this.multiplicador = 1;
    }

    public String getVida(){
        return String.format("%.2f", this.vida);
    }

    public int getEnergia(){
        return this.energia;
    }
}