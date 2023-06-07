package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//Adiciona as anotações do mockito para serem utilizadas no JUnit
class ProdutoServiceTest {

    @Mock // prepara o ProdutoRepository para receber resposta pré-determinadas
    ProdutoRepository produtoRepository;

    @InjectMocks // indica que o ProdutoService irá receber o Mock do ProdutoRepository
    ProdutoService produtoService;

    @Test
    void retornaTodosProdutos() {
        //definição dos dados
        List<Produto> produtosMock = List.of(
                new Produto(1L,"Bloco Notas", 10.0,0.05, LocalDate.MIN)
        );

        //quando o método findAll for chamado eu retorno sempre o produtosMock
        when(produtoRepository.findAll()).thenReturn(produtosMock);

        //a chamado do método a ser testado
        List<Produto> produtosResultado = produtoService.retornaTodosProdutos();

        //a validação da resposta do método
        assertNotNull(produtosResultado);
        assertEquals(produtosMock.get(0).getNomeProduto(),produtosResultado.get(0).getNomeProduto());
        verify(produtoRepository).findAll(); // valido se o método findAll foi chamado alguma vez
    }

    @Test
    void salvaProduto() {

        //definição dos dados
        Produto produtoMock =
                new Produto(1L,"Bloco Notas", 10.0,0.05, LocalDate.MIN);

        //quando o método findAll for chamado eu retorno sempre o produtosMock
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoMock);

        //a chamado do método a ser testado
        Produto produtoResultado = produtoService.salvaProduto(
                new ProdutoDto("Bloco Notas", 10.0)
        );

        //a validação da resposta do método
        assertNotNull(produtoResultado);
        assertEquals(produtoMock.getNomeProduto(),produtoResultado.getNomeProduto());
        verify(produtoRepository,times(1)).save(any()); // valido se o método findAll foi chamado alguma vez
        // times(1) indica que eu espero que o save seja chamado 1 vez
    }
}