package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ClienteModel;
import com.academiacx.repository.ClienteRepository;
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
            throw new ParametroInvalidoException("O Cliente Model deve ser informado!");
        }

        if (clienteModel.getId() == null) {
            throw new ParametroInvalidoException("O Cliente Model deve conter um id!");
        }

        try {
            clienteModel = clienteRepository.findById(clienteModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return clienteModel;
    }

    public ClienteModel findById(Long id) {

        ClienteModel clienteModel = new ClienteModel();
        try {
            clienteModel = clienteRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return clienteModel;
    }

    public ClienteModel insert(ClienteModel clienteModel) {
        clienteModel.setId(null);

        ClienteModel result = null;
        try {
            result = clienteRepository.save(clienteModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado inserido viola uma restrição do banco de dados (dado nulo ou já existente)");
        }

        return result;
    }

    public ClienteModel update(ClienteModel clienteModel) {

        findById(clienteModel);

        ClienteModel result = null;
        try {
            result = clienteRepository.save(clienteModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado inserido viola uma restrição do banco de dados (dado nulo ou já existente)");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
