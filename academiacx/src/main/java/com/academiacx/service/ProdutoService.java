package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ProdutoModel;
import com.academiacx.repository.ProdutoRepository;
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
            throw new ParametroInvalidoException("O Produto Model deve ser informado!");
        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("O Produto Model deve conter um id!");
        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return produtoModel;
    }

    public ProdutoModel findById(Long id) {

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return produtoModel;
    }

    public ProdutoModel insert(ProdutoModel produtoModel) {
        produtoModel.setId(null);

        ProdutoModel result = null;
        try {
            result = produtoRepository.save(produtoModel);
        } catch (Exception e) {
            throw new ConstraintViolationException("Algum dado inserido viola uma restrição do banco de dados (Dado duplicado)");
        }

        return result;
    }

    public ProdutoModel update(ProdutoModel produtoModel) {

        findById(produtoModel);

        ProdutoModel result = null;
        try {
            result = produtoRepository.save(produtoModel);
        } catch (Exception e) {
            throw new ConstraintViolationException("Algum dado inserido viola uma restrição do banco de dados (Dado duplicado)");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        try {
            produtoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
