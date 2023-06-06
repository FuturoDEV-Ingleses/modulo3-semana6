package com.example.testeaula2.controller;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // cria um controller
@RequestMapping("/produtos") // sempre que chamar o /produto vamos entrar nessa classe
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> encontraProdutos(){
        List<Produto> produtosResposta = produtoService.retornaTodosProdutos();

        return ResponseEntity.ok(produtosResposta);
    }

    @PostMapping
    public ResponseEntity<Produto> salvaProduto(@RequestBody ProdutoDto produtoDto){
        Produto produtoResposta = produtoService.salvaProduto(produtoDto);

        return new ResponseEntity<>(produtoResposta, HttpStatus.CREATED);
    }

}
