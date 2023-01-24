package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.ClienteModel;
import com.example.academiacx2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findall(){
        List<ClienteModel> clienteModels = clienteRepository.findAll();

        return clienteModels;
    }

    public ClienteModel findById(ClienteModel clienteModel) {

        if (clienteModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return clienteModel;
    }

    public ClienteModel findById(Long id) {

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

    public boolean delete(Long id){

        findById(id);

        clienteRepository.deleteById(id);

        return true;
    }
}
