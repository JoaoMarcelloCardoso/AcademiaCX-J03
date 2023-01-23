package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.PrecoModel;
import com.example.ecommerce.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.handler.exceptions.ParametroInvalidoException;
import java.util.List;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    public List<PrecoModel> findAll() {
        List<PrecoModel> precoModels = precoRepository.findAll();
        return precoModels;
    }

    public PrecoModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        PrecoModel precoModel;
        try {
            precoModel = precoRepository.findById(id).get();
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return precoModel;
    }

    public PrecoModel insert(PrecoModel precoModel) {
        precoModel.setId(null);

        PrecoModel result = precoRepository.save(precoModel);

        return result;
    }

    public PrecoModel update(PrecoModel precoModel) {
        findById(precoModel.getId());

        return precoRepository.save(precoModel);
    }

    public boolean delete(Long id) {
        findById(id);

        precoRepository.deleteById(id);

        return true;
    }

}
