package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.PrecoModel;
import com.academiacx.repository.PrecoRepository;
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
            throw new ParametroInvalidoException("O Preço Model deve ser informado!");
        }

        if (precoModel.getId() == null) {
            throw new ParametroInvalidoException("O Preço Model deve conter um id!");
        }

        try {
            precoModel = precoRepository.findById(precoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return precoModel;
    }

    public PrecoModel findById(Long id) {

        PrecoModel precoModel = new PrecoModel();
        try {
            precoModel = precoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return precoModel;
    }

    public PrecoModel insert(PrecoModel precoModel) {
        precoModel.setId(null);

        PrecoModel result = null;
        try {
            result = precoRepository.save(precoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public PrecoModel update(PrecoModel precoModel) {

        findById(precoModel);

        PrecoModel result = null;
        try {
            result = precoRepository.save(precoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        try {
            precoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
