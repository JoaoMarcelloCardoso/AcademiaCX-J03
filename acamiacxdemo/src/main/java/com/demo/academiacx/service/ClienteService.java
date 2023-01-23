package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.repository.ClienteRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepostory ClienteRepository;

    public List<ClienteModel> findAll() {
        List<ClienteModel> ClienteModels = ClienteRepository.findAll();

        return ClienteModels;
    }

    public ClienteModel findById(ClienteModel ClienteModel) {

        if (ClienteModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve informada");

        }

        if (ClienteModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            ClienteModel = ClienteRepository.findById(ClienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ClienteModel;
    }

    public ClienteModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ClienteModel ClienteModel = new ClienteModel();
        try {
            ClienteModel = ClienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ClienteModel;
    }

    public ClienteModel insert(ClienteModel ClienteModel) {
        ClienteModel.setId(null);

        ClienteModel result = ClienteRepository.save(ClienteModel);

        return result;
    }

    public ClienteModel update(ClienteModel ClienteModel) {

        findById(ClienteModel);


        return ClienteRepository.save(ClienteModel);
    }

    public boolean delete(Long id) {

        findById(id);

        ClienteRepository.deleteById(id);

        return true;
    }
}
