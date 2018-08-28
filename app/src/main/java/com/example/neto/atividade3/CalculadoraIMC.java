package com.example.neto.atividade3;

public class CalculadoraIMC {

    private int peso;
    private int altura;

    CalculadoraIMC(){
        this.peso=0;
        this.altura=0;
    }

    public double calcularIMC(){

        System.out.println("Peso: " + this.peso);
        System.out.println("Altura: " + this.altura);

        return ((double)this.peso)/(this.altura*this.altura)* 10000;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int nPeso) {
        this.peso = nPeso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int nAltura) {
        this.altura = nAltura;
    }
}
