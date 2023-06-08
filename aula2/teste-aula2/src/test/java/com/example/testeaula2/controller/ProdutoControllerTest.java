package com.example.testeaula2.controller;

import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//Exemplo de Teste de Integração


@SpringBootTest // Carrega o contexto do spring e inicializa a aplicação
@AutoConfigureMockMvc // Configura automaticamente o MockMvc
class ProdutoControllerTest {

    @Autowired //injeção da dependencia MockMvc
    MockMvc mockMvc; //quem realiza as chamadas aos endpoints

    @MockBean //gera um falsificação dentro do contexto do Spring
            //esse Mock está dentro do Spring então não precisa ser Injetado com o @InjectMock
            //o Spring é que vai fazer a Injeção
            //Só posso usar o @MockBean com o SpringBootTest
    ProdutoRepository produtoRepository;

    @Test
    void encontraProdutos() throws Exception {
        //dados que serão usados no lugar do banco de dados
        List<Produto> produtosMock = List.of(
                new Produto(1L,"Bloco Notas", 10.0,0.05,LocalDate.of(2023,6,6))
        );

        //mock da chamada do findAll
        when(produtoRepository.findAll()).thenReturn(produtosMock);

        //chamada do endpoint
        mockMvc.perform( //realizar uma chamada ao endpoint
                MockMvcRequestBuilders // constrói uma requisição http
                        .get("/produtos") // chama o /produtos com o método GET
                        .accept(MediaType.APPLICATION_JSON) // espera receber um JSON como resposta
        ).andExpect(MockMvcResultMatchers.status().isOk() // valido se a resposta da requisição é de status OK
        ).andExpect(MockMvcResultMatchers.content().json(//espera receber um JSON usamos """ """
                """
                [
                      {
                          "id": 1,
                          "nomeProduto": "Bloco Notas",
                          "valorProduto": 10.0,
                          "descontoVip": 0.05,
                          "dataCriacaoProduto": "2023-06-06"
                      }
                ]
                """
        ));
    }

    @Test
    void salvaProduto() throws Exception {
        //dados que serão usados no lugar do banco de dados
        Produto produtoMock =
                new Produto(1L,
                        "Bloco Notas",
                        10.0,
                        0.05,
                        LocalDate.of(2023,6,6));

        //mock da chamada do save
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoMock);


        mockMvc.perform( //realizar uma chamada ao endpoint
                MockMvcRequestBuilders // constrói uma requisição http
                        .post("/produtos") // chama o /produtos com o método POST
                        .accept(MediaType.APPLICATION_JSON) // espera receber um JSON como resposta
                        .contentType(MediaType.APPLICATION_JSON) //indica que o corpo da requisição é um JSON
                        .content( //conteúdo da requisição, o conteúdo é um JSON
                                """ 
                                {
                                    "nomeProduto":"Bloco Notas",
                                    "valorProduto":10.0
                                }
                                """
                        )
        ).andExpect(MockMvcResultMatchers.status().isCreated() // valido se a resposta da requisição é de status CREATED (201)
        ).andExpect(MockMvcResultMatchers.content().json(//espera receber um JSON usamos """ """
                """
                {
                    "id": 1,
                    "nomeProduto": "Bloco Notas",
                    "valorProduto": 10.0,
                    "descontoVip": 0.05,
                    "dataCriacaoProduto": "2023-06-06"
                }
                """
        ));
    }

    @Test
    void atualizaProduto() {
    }

    @Test
    void deletaProduto() {
    }
}