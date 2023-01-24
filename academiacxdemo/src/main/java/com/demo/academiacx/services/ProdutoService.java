package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoModel> findAll(){

        List<ProdutoModel> produtoModel = produtoRepository.findAll();
        return produtoModel;
    }

    public ProdutoModel findById(ProdutoModel produtoModel) {

        if (produtoModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (produtoModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            produtoModel = produtoRepository.findById(produtoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoModel;
    }

    public ProdutoModel findById(Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = produtoRepository.findById(id).get();

        }catch (Exception e){
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return produtoModel;
    }

    public ProdutoModel insert(ProdutoModel produtoModel){

        produtoModel.setId(null);
        return produtoRepository.save(produtoModel);
    }

    public ProdutoModel update(ProdutoModel produtoModel){

        findById(produtoModel);


        return produtoRepository.save(produtoModel);

    }

    public boolean delete(Long id){

        findById(id);
        produtoRepository.deleteById(id);
        return true;

    }

}
