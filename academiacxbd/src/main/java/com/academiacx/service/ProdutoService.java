package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.ProdutoModel;
import com.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public List<ProdutoModel> findAll(){

        return produtoRepository.findAll();

    }

    public ProdutoModel findById(Long id) {

        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produtoRepository.findById(id).get();

        }
        return null;
    }
    public ProdutoModel save(ProdutoModel produtoModel) {
        produtoModel.setId(null);

        ProdutoModel result = produtoRepository.save(produtoModel);

        return result;
    }

    public ProdutoModel update(ProdutoModel produtoModel){
        Optional<ProdutoModel> produto = produtoRepository.findById(produtoModel.getId());
        if (produto.isPresent()){
            produtoRepository.save(produtoModel);
            return produto.get();
        }else{
            throw new UsuarioNaoEncontradoException("Endereço não encontrado");
        }

    }

    public ProdutoModel delete(ProdutoModel produtoModel) {
        try {
            Optional<ProdutoModel> produto = produtoRepository.findById(produtoModel.getId());
            if (produto.isPresent()) {
                produtoRepository.deleteById(produto.get().getId());
                return produto.get();
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
