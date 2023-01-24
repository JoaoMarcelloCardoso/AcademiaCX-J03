package com.academiacxbd.atividadebd.service;

import com.academiacxbd.atividadebd.handler.exceptions.ParametroInvalidoException;
import com.academiacxbd.atividadebd.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacxbd.atividadebd.model.ClienteModel;
import com.academiacxbd.atividadebd.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll() {
        List<ClienteModel> clienteModels = clienteRepository.findAll();

        return clienteModels;
    }

    public ClienteModel findById(ClienteModel clienteModel) {

        if (clienteModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return clienteModel;
    }

    public ClienteModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ClienteModel clienteModel = new ClienteModel();
        try {
            clienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return clienteModel;
    }

    public ClienteModel insert(ClienteModel clienteModel) {
        clienteModel.setId(null);

       ClienteModel result = clienteRepository.save(clienteModel);

        return result;
    }

    public ClienteModel update(ClienteModel clienteModel) {

        findById(clienteModel);


        return clienteRepository.save(clienteModel);
    }

    public boolean delete(Long id) {

        findById(id);

        clienteRepository.deleteById(id);

        return true;
    }
}
