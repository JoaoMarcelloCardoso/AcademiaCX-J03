package com.example.academiacx.service;

import com.example.academiacx.handler.exceptions.ErroInternoException;
import com.example.academiacx.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx.model.ClienteModel;
import com.example.academiacx.model.EnderecoModel;
import com.example.academiacx.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll() {
        List<ClienteModel> ClienteModels = clienteRepository.findAll();

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
            ClienteModel = clienteRepository.findById(ClienteModel.getId()).get();

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
            ClienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ClienteModel;
    }

    public ClienteModel insert(ClienteModel ClienteModel) {
        ClienteModel.setId(null);

        ClienteModel result = clienteRepository.save(ClienteModel);

        return result;
    }

    public ClienteModel update(ClienteModel ClienteModel) {

        findById(ClienteModel);


        return clienteRepository.save(ClienteModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ClienteModel clienteModel = findById(id);
            try {
                clienteRepository.delete(clienteModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
}
