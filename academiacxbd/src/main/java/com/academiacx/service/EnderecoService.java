package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.EnderecoModel;
import com.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    public List<EnderecoModel> findAll(){

        return enderecoRepository.findAll();

    }

    public EnderecoModel findById(Long id) {

        Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            return enderecoRepository.findById(id).get();

        }
        return null;
    }
    public EnderecoModel save(EnderecoModel enderecoModel) {
        enderecoModel.setId(null);

        EnderecoModel result = enderecoRepository.save(enderecoModel);

        return result;
    }

    public EnderecoModel update(EnderecoModel enderecoModel){
        Optional<EnderecoModel> endereco = enderecoRepository.findById(enderecoModel.getId());
        if (endereco.isPresent()){
            enderecoRepository.save(enderecoModel);
            return endereco.get();
        }else{
            throw new UsuarioNaoEncontradoException("Endereço não encontrado");
        }

    }

    public EnderecoModel delete(EnderecoModel enderecoModel){
        try {
            Optional<EnderecoModel> endereco = enderecoRepository.findById(enderecoModel.getId());
            if (endereco.isPresent()) {
                enderecoRepository.deleteById(endereco.get().getId());
                return endereco.get();
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
