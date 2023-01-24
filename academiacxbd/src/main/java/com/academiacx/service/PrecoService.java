package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.PrecoModel;
import com.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecoService {
    @Autowired
    private PrecoRepository precoRepository;
    public List<PrecoModel> findAll(){

        return precoRepository.findAll();

    }

    public PrecoModel findById(Long id) {

        Optional<PrecoModel> preco = precoRepository.findById(id);
        if (preco.isPresent()) {
            return precoRepository.findById(id).get();

        }
        return null;
    }
    public PrecoModel save(PrecoModel precoModel) {
        precoModel.setId(null);

        PrecoModel result = precoRepository.save(precoModel);

        return result;
    }

    public PrecoModel update(PrecoModel precoModel){
        Optional<PrecoModel> preco = precoRepository.findById(precoModel.getId());
        if (preco.isPresent()){
            precoRepository.save(precoModel);
            return preco.get();
        }else{
            throw new UsuarioNaoEncontradoException("Endereço não encontrado");
        }

    }

    public PrecoModel delete(PrecoModel precoModel){
        try {
            Optional<PrecoModel> preco = precoRepository.findById(precoModel.getId());
            if(preco.isPresent()){
                precoRepository.deleteById(preco.get().getId());
                return preco.get();
            }
        }catch (Exception e){
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
