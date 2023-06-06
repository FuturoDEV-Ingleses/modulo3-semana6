package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// classe de testes
class CalculadoraTest {
    // criando uma nova instancia Calculador
    Calculadora calculadora = new Calculadora();

    @Test // indica que um método é um teste e que pode ser executado individualmente
    void soma() {

        // gerando o resultado da chamada do método soma()
        double resultado = calculadora.soma(1.1,2.0);

        // validando o resultado da chamada do soma
        assertEquals(3.1,resultado);
    }

    @Test
    void subtracao() {
        double resultado = calculadora.subtracao(3.2,2.1);

        assertEquals(1.1,resultado);
    }

    @Test
    void divisao() {
        double resultado = calculadora.divisao(10.5,3.0);

        assertEquals(3.5,resultado);
    }

    @Test
    void multiplicacao() {
        double resultado = calculadora.multiplicacao(3.1,2.0);

        assertEquals(6.2,resultado);
    }

    @Test
    void fatorial() {
        double resultado = calculadora.fatorial(6.0);

        assertEquals(720,resultado);
    }
}