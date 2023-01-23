package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository ProdutoRepository;

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> ProdutoModels = ProdutoRepository.findAll();

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
            ProdutoModel = ProdutoRepository.findById(ProdutoModel.getId()).get();

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
            ProdutoModel = ProdutoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ProdutoModel;
    }

    public ProdutoModel insert(ProdutoModel ProdutoModel) {
        ProdutoModel.setId(null);

        ProdutoModel result = ProdutoRepository.save(ProdutoModel);

        return result;
    }

    public ProdutoModel update(ProdutoModel ProdutoModel) {

        findById(ProdutoModel);


        return ProdutoRepository.save(ProdutoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        ProdutoRepository.deleteById(id);

        return true;
    }
}
