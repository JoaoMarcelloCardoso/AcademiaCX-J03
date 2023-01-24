package com.example.academiacx.service;

import com.example.academiacx.handler.exceptions.ErroInternoException;
import com.example.academiacx.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx.model.ProdutoModel;
import com.example.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> ProdutoModels = produtoRepository.findAll();

        return ProdutoModels;
    }

    public ProdutoModel findById(ProdutoModel ProdutoModel) {

        if (ProdutoModel == null) {
            throw new ParametroInvalidoException("A Produto Model deve informada");

        }

        if (ProdutoModel.getId() == null) {
            throw new ParametroInvalidoException("A Produto Model deve conter um id");

        }

        try {
            ProdutoModel = produtoRepository.findById(ProdutoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ProdutoModel;
    }

    public ProdutoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ProdutoModel ProdutoModel = new ProdutoModel();
        try {
            ProdutoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ProdutoModel;
    }

    public ProdutoModel insert(ProdutoModel ProdutoModel) {
        ProdutoModel.setId(null);

        ProdutoModel result = produtoRepository.save(ProdutoModel);

        return result;
    }

    public ProdutoModel update(ProdutoModel ProdutoModel) {

        findById(ProdutoModel);


        return produtoRepository.save(ProdutoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ProdutoModel produtoModel = findById(id);
            try {
                produtoRepository.delete(produtoModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }

            return true;
        }
        return false;
    }
}