package com.example;

public abstract class Slime {
    protected double vida = 10;
    protected double multiplicador = 1;
    protected double resistencia = 0;
    protected int energia = 5;
    protected String especial;
    private boolean energizado = false;

    protected void atacar(Slime inimigo){
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

    protected void energizar(){
        if(this.energia >= 2){
            decrementarEnergia(2);
            this.energizado = true;
        } else {
            System.out.println("Sem energia suficiente para esta ação!");
        }
    }

    protected void desenergizar(){
        this.energizado = false;
    }

    protected abstract void especial(Slime inimigo, String nomeSlime);

    protected void decrementarEnergia(double energia){
        this.energia -= energia;
        if(this.energia < 0){
            this.energia = 0;
        }
    }

    protected void aumentarEnergia(double energia){
        this.energia += energia;
    }

    protected void decrementarVida(double vida){
        this.vida -= vida;
        if(this.vida < 0){
            this.vida = 0;
        }
    }

    protected void aumentarVida(double vida){
        this.vida += vida;
    }

    protected boolean estaVivo(){
        return this.vida > 0;
    }

    protected void resetarMultiplicador(){
        this.multiplicador = 1;
    }

    protected String getVida(){
        return String.format("%.2f", this.vida);
    }

    protected int getEnergia(){
        return this.energia;
    }
}