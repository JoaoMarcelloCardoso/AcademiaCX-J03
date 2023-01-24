package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll(){

        List<ItemModel> itemModel = itemRepository.findAll();
        return itemModel;
    }

    public ItemModel findById(ItemModel itemModel) {

        if (itemModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            itemModel = itemRepository.findById(itemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemModel;
    }

    public ItemModel findById(Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id informado inválido");
        }

        ItemModel itemModel = new ItemModel();
        try {
            itemModel = itemRepository.findById(id).get();

        }catch (Exception e){
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemModel;
    }

    public ItemModel insert(ItemModel itemModel){

        itemModel.setId(null);
        return itemRepository.save(itemModel);
    }

    public ItemModel update(ItemModel itemModel){

        findById(itemModel);


        return itemRepository.save(itemModel);

    }

    public boolean delete(Long id){

        findById(id);
        itemRepository.deleteById(id);
        return true;

    }

}
