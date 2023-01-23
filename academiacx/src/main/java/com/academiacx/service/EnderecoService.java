package com.academiacx.service;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.EnderecoModel;
import com.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        List<EnderecoModel> enderecoModels = enderecoRepository.findAll();

        return enderecoModels;
    }

    public EnderecoModel findById(EnderecoModel enderecoModel) {

        if (enderecoModel == null) {
            throw new ParametroInvalidoException("O Endereço Model deve ser informado!");
        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("O Endereço Model deve conter um id!");
        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return enderecoModel;
    }

    public EnderecoModel findById(Long id) {

        EnderecoModel enderecoModel = new EnderecoModel();
        try {
            enderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return enderecoModel;
    }

    public EnderecoModel insert(EnderecoModel enderecoModel) {
        enderecoModel.setId(null);

        EnderecoModel result = null;
        try {
            result = enderecoRepository.save(enderecoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public EnderecoModel update(EnderecoModel enderecoModel) {

        findById(enderecoModel);

        EnderecoModel result = null;
        try {
            result = enderecoRepository.save(enderecoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }
}
