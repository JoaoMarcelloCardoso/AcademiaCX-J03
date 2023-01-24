package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> findAll(){

        List<EnderecoModel> enderecoModel = enderecoRepository.findAll();
        return enderecoModel;
    }

    public EnderecoModel findById(EnderecoModel enderecoModel) {

        if (enderecoModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (enderecoModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            enderecoModel = enderecoRepository.findById(enderecoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
    }

    public EnderecoModel findById(Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id informado inválido");
        }

        EnderecoModel enderecoModel = new EnderecoModel();
        try {
            enderecoModel = enderecoRepository.findById(id).get();

        }catch (Exception e){
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return enderecoModel;
    }

    public EnderecoModel insert(EnderecoModel enderecoModel){

        enderecoModel.setId(null);
        return enderecoRepository.save(enderecoModel);
    }

    public EnderecoModel update(EnderecoModel enderecoModel){

        findById(enderecoModel);


        return enderecoRepository.save(enderecoModel);

    }

    public boolean delete(Long id){

        findById(id);
        enderecoRepository.deleteById(id);
        return true;

    }
}
