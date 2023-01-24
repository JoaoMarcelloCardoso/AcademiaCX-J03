package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.EnderecoModel;
import com.example.academiacx2.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findall(){
        List<EnderecoModel> enderecoModels = enderecoRepository.findAll();

        return enderecoModels;
    }

    public EnderecoModel findById(EnderecoModel enderecoModel) {

        if (enderecoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
    }

    public EnderecoModel findById(Long id) {

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

    public boolean delete(Long id){

        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }
}
