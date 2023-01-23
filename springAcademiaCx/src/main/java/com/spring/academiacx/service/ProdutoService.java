package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> produtoModels = produtoRepository.findAll();

        return produtoModels;
    }

    public ProdutoModel findById(ProdutoModel produtoModel) {

        if (produtoModel == null) {
            throw new ParametroInvalidoException("O Model Produto deve informado");

        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("O Model Produto deve conter um id");

        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoModel;
    }

    public ProdutoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoModel;
    }

    public ProdutoModel insert(ProdutoModel produtoModel) {
        produtoModel.setId(null);

        ProdutoModel result = produtoRepository.save(produtoModel);

        return result;
    }

    public ProdutoModel update(ProdutoModel produtoModel) {

        findById(produtoModel);


        return produtoRepository.save(produtoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        produtoRepository.deleteById(id);

        return true;
    }
}



