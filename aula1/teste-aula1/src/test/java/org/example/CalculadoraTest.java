package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// classe de testes
class CalculadoraTest {

    @Test // indica que um método é um teste e que pode ser executado individualmente
    void soma() {
        // criando uma nova instancia Calculador
        Calculadora calculadora = new Calculadora();

        // gerando o resultado da chamada do método soma()
        double resultado = calculadora.soma(1.1,2.0);

        // validando o resultado da chamada do soma
        assertEquals(3.1,resultado);
    }
}