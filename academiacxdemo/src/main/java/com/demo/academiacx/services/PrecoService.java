package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public List<PrecoModel> findAll() {

        List<PrecoModel> precoModel = precoRepository.findAll();
        return precoModel;
    }

    public PrecoModel findById(PrecoModel precoModel) {

        if (precoModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            precoModel = precoRepository.findById(precoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return precoModel;
    }

    public PrecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        PrecoModel precoModel = new PrecoModel();
        try {
            precoModel = precoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return precoModel;
    }

    public PrecoModel insert(PrecoModel precoModel) {

        precoModel.setId(null);
        return precoRepository.save(precoModel);
    }

    public PrecoModel update(PrecoModel precoModel) {

        findById(precoModel);


        return precoRepository.save(precoModel);
    }

    public boolean delete(Long id) {

        findById(id);
        precoRepository.deleteById(id);
        return true;
    }
}