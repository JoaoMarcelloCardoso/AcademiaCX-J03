package com.academiacxbd.atividadebd.service;

import com.academiacxbd.atividadebd.handler.exceptions.ParametroInvalidoException;
import com.academiacxbd.atividadebd.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacxbd.atividadebd.model.EnderecoModel;
import com.academiacxbd.atividadebd.repository.EnderecoRepository;
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
            throw new ParametroInvalidoException("O Endereço Model deve ser informada");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("O Endereço Model deve conter um id");

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
