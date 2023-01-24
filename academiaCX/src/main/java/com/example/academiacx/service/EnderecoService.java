package com.example.academiacx.service;

import com.example.academiacx.handler.exceptions.ErroInternoException;
import com.example.academiacx.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx.model.EnderecoModel;
import com.example.academiacx.model.PrecoModel;
import com.example.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        List<EnderecoModel> EnderecoModels = enderecoRepository.findAll();

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
            EnderecoModel = enderecoRepository.findById(EnderecoModel.getId()).get();

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
            EnderecoModel = enderecoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return EnderecoModel;
    }

    public EnderecoModel insert(EnderecoModel EnderecoModel) {
        EnderecoModel.setId(null);

        EnderecoModel result = enderecoRepository.save(EnderecoModel);

        return result;
    }

    public EnderecoModel update(EnderecoModel EnderecoModel) {

        findById(EnderecoModel);


        return enderecoRepository.save(EnderecoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            EnderecoModel enderecoModel = findById(id);
            try {
                enderecoRepository.delete(enderecoModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
}