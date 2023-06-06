package org.example;

public class Calculadora {


    //divisão, multiplicação, subtração, um fatorial 6! = 6*5*4*3*2*1
    public Double soma(Double valor1, Double valor2){
        return valor1+valor2;
    }

    public Double subtracao(Double valor1, Double valor2){
        return valor1-valor2;
    }

    public Double divisao(Double valor1, Double valor2){
        return valor1/valor2;
    }

    public Double multiplicacao(Double valor1, Double valor2){
        return valor1*valor2;
    }

    public Double fatorial(Double valor){
        double resultado = 1;
        while (valor > 1){
            resultado *= valor;
            valor--;
        }
        return resultado;
    }
}
