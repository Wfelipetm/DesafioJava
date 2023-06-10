package com.mycompany.calculadora;


public class Calculos {
    public double adicao(double n1, double n2) {
        return n1 + n2;
    }

    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    public double potencia(double n, int expoente) {
        return Math.pow(n, expoente);
    }

    public double primeiroVezesQuadradoDoSegundo(double n1, double n2) {
        return n1 * Math.pow(n2, 2);
    }

    public double somaDosQuadrados(double n1, double n2) {
        return Math.pow(n1, 2) + Math.pow(n2, 2);
    }

    public double raizQuadrada(double n) {
        return Math.sqrt(n);
    }

    public double seno(double n) {
        return Math.sin(n);
    }

    public double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }
}

