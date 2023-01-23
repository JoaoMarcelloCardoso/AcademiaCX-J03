package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.EnderecoModel;
import com.spring.academiacx.repository.EnderecoRepository;
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
            throw new ParametroInvalidoException("O Model Endereco deve informado");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("O Model Endereco deve conter um id");

        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
    }

    public EnderecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        EnderecoModel enderecoModel = new EnderecoModel();
        try {
            enderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
    }

    public EnderecoModel insert(EnderecoModel enderecoModel) {
        enderecoModel.setId(null);

        EnderecoModel result = enderecoRepository.save(enderecoModel);

        return result;
    }

    public EnderecoModel update(EnderecoModel enderecoModel) {

        findById(enderecoModel);


        return enderecoRepository.save(enderecoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }
}

