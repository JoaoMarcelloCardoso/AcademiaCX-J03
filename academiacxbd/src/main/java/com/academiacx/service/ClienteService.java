package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.ClienteModel;
import com.academiacx.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteModel> findAll(){

        return clienteRepository.findAll();

    }

    public ClienteModel findById(Long id) {

        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return clienteRepository.findById(id).get();

        }
        return null;
    }
    public ClienteModel save(ClienteModel clienteModel) {
        clienteModel.setId(null);

        ClienteModel result = clienteRepository.save(clienteModel);

        return result;
    }

    public ClienteModel update(ClienteModel clienteModel){
        Optional<ClienteModel> cliente = clienteRepository.findById(clienteModel.getId());
        if (cliente.isPresent()){
            clienteRepository.save(clienteModel);
            return cliente.get();
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public ClienteModel delete(ClienteModel clienteModel){
        try {
            Optional<ClienteModel> cliente = clienteRepository.findById(clienteModel.getId());
            if (cliente.isPresent()) {
                clienteRepository.deleteById(cliente.get().getId());
                return cliente.get();
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
