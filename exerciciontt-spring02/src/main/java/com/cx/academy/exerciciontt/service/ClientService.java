package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.model.CartModel;
import com.cx.academy.exerciciontt.model.ClientModel;
import com.cx.academy.exerciciontt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> findAll() {
        try {
            List<ClientModel> clientList = clientRepository.findAll();
            if(clientList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint client");
            }
            return clientList;
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar clientes");
        }
    }

    public ClientModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            return clientRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Cliente não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar cliente pelo id");
        }
    }

    public ClientModel findById(ClientModel clientModel) {
        if (clientModel == null) {
            throw new ParametroInvalidoException("A Client Model deve ser informada");
        }

        if (clientModel.getId() == null) {
            throw new ParametroInvalidoException("A Client Model deve conter um id");
        }

        try {
            return clientRepository.findById(clientModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Cliente não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar cliente pelo id");
        }
    }


    public ClientModel insert(ClientModel clientModel) {
        clientModel.setId(null);

        return clientRepository.save(clientModel);
    }


    public ClientModel update(ClientModel clientModel) {
        if(!clientRepository.existsById(clientModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe cliente com o id informado");
        }

        try {
            return clientRepository.save(clientModel);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar cliente");
        }
    }

    public boolean delete(Long id) {
        if(id == null || !clientRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe cliente com o id informado");
        }
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar cliente");
        }
}}
