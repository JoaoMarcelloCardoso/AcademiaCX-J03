package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.EnderecoModel;
import com.example.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.handler.exceptions.ParametroInvalidoException;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll() {
        List<EnderecoModel> enderecoModels = enderecoRepository.findAll();
        return enderecoModels;
    }

    public EnderecoModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        EnderecoModel enderecoModel;
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
        findById(enderecoModel.getId());

        return enderecoRepository.save(enderecoModel);
    }

    public boolean delete(Long id) {
        findById(id);

        enderecoRepository.deleteById(id);

        return true;
    }

}
