package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> retornaTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Produto salvaProduto(ProdutoDto produtoDto){
        Double valorDescontoCalculado = 0d;
        if (produtoDto.getValorProduto() > 100d)
            valorDescontoCalculado = 0.1;
        else
            valorDescontoCalculado = 0.05;

        return produtoRepository.save(
                new Produto(
                        produtoDto.getNomeProduto(),
                        produtoDto.getValorProduto(),
                        valorDescontoCalculado,
                        LocalDate.now()
                )
        );
    }

    public Produto atualizaProduto(ProdutoDto produtoDto, Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        produto.setNomeProduto(produtoDto.getNomeProduto());
        produto.setValorProduto(produtoDto.getValorProduto());

        return produtoRepository.save(produto);
    }

    public void deletaProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
