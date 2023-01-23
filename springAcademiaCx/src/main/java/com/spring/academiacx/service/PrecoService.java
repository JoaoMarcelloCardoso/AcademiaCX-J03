package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public List<PrecoModel> findAll() {
        List<PrecoModel> precoModels = precoRepository.findAll();

        return precoModels;
    }

    public PrecoModel findById(PrecoModel precoModel) {

        if (precoModel == null) {
            throw new ParametroInvalidoException("O Model Preco deve ser informado");

        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("O Model Preco deve conter um id");

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

        PrecoModel result = precoRepository.save(precoModel);

        return result;
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


