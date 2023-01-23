package com.cx.academy.exerciciontt.service;

import com.cx.academy.exerciciontt.handler.exceptions.ErroDeFormatoException;
import com.cx.academy.exerciciontt.handler.exceptions.ParametroInvalidoException;
import com.cx.academy.exerciciontt.handler.exceptions.RecursoNaoEncontradoExeception;
import com.cx.academy.exerciciontt.handler.exceptions.SemConteudoException;
import com.cx.academy.exerciciontt.model.AddressModel;
import com.cx.academy.exerciciontt.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {

    @Autowired
    private AdressRepository addressRepository;

    public List<AddressModel> findAll() {
        try {
            List<AddressModel> addressList = addressRepository.findAll();
            if(addressList.isEmpty()) {
                throw new SemConteudoException("Não há conteúdo no endpoint address");
            }
            return addressList;
        } catch (Exception e){
            throw new ErroDeFormatoException("Erro ao buscar endereços");
        }
    }

    public AddressModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        try {
            return addressRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoExeception("Endereço não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar endereço pelo id");
        }
    }

    public AddressModel findById(AddressModel addressModel) {
        if (addressModel == null) {
            throw new ParametroInvalidoException("A Address Model deve ser informada");
        }

        if (addressModel.getId() == null) {
            throw new ParametroInvalidoException("A Address Model deve conter um id");
        }

        try {
            return addressRepository.findById(addressModel.getId()).orElseThrow(() -> new RecursoNaoEncontradoExeception("Endereço não encontrado com o id informado"));
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao buscar endereço pelo id");
        }
    }


    public AddressModel insert(AddressModel addressModel) {
        addressModel.setId(null);

        return addressRepository.save(addressModel);
    }


    public AddressModel update(AddressModel addressModel) {
        if(!addressRepository.existsById(addressModel.getId())) {
            throw new RecursoNaoEncontradoExeception("Não existe endereço com o id informado");
        }

        try {
            return addressRepository.save(addressModel);
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao atualizar endereço");
        }
    }

    public boolean delete(Long id) {

        if(id == null || !addressRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExeception("Não existe endereço com o id informado");
        }
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ErroDeFormatoException("Erro ao deletar endereço");
        }

    }
}
