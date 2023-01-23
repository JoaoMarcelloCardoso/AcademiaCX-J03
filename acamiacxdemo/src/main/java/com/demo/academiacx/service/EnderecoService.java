package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository EnderecoRepository;

    public List<EnderecoModel> findAll() {
        List<EnderecoModel> EnderecoModels = EnderecoRepository.findAll();

        return EnderecoModels;
    }

    public EnderecoModel findById(EnderecoModel EnderecoModel) {

        if (EnderecoModel == null) {
            throw new ParametroInvalidoException("A Endereco Model deve informada");

        }

        if (EnderecoModel.getId() == null) {
            throw new ParametroInvalidoException("A Endereco Model deve conter um id");

        }

        try {
            EnderecoModel = EnderecoRepository.findById(EnderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return EnderecoModel;
    }

    public EnderecoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        EnderecoModel EnderecoModel = new EnderecoModel();
        try {
            EnderecoModel = EnderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return EnderecoModel;
    }

    public EnderecoModel insert(EnderecoModel EnderecoModel) {
        EnderecoModel.setId(null);

        EnderecoModel result = EnderecoRepository.save(EnderecoModel);

        return result;
    }

    public EnderecoModel update(EnderecoModel EnderecoModel) {

        findById(EnderecoModel);


        return EnderecoRepository.save(EnderecoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        EnderecoRepository.deleteById(id);

        return true;
    }
}
