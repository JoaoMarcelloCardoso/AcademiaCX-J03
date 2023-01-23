package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoService {
    @Autowired
    private PrecoRepository PrecoRepository;

    public List<PrecoModel> findAll() {
        List<PrecoModel> PrecoModels = PrecoRepository.findAll();

        return PrecoModels;
    }

    public PrecoModel findById(PrecoModel PrecoModel) {

        if (PrecoModel == null) {
            throw new ParametroInvalidoException("A Preco Model deve informada");

        }

        if (PrecoModel.getId() == null) {
            throw new ParametroInvalidoException("A Preco Model deve conter um id");

        }

        try {
            PrecoModel = PrecoRepository.findById(PrecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return PrecoModel;
    }

    public PrecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        PrecoModel PrecoModel = new PrecoModel();
        try {
            PrecoModel = PrecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return PrecoModel;
    }

    public PrecoModel insert(PrecoModel PrecoModel) {
        PrecoModel.setId(null);

        PrecoModel result = PrecoRepository.save(PrecoModel);

        return result;
    }

    public PrecoModel update(PrecoModel PrecoModel) {

        findById(PrecoModel);


        return PrecoRepository.save(PrecoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        PrecoRepository.deleteById(id);

        return true;
    }
}
