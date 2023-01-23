package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.ItemModel;
import com.spring.academiacx.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        List<ItemModel> itemModels = itemRepository.findAll();

        return itemModels;
    }

    public ItemModel findById(ItemModel itemModel) {

        if (itemModel == null) {
            throw new ParametroInvalidoException("O Model Item deve informado");

        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("O Model Item deve conter um id");

        }

        try {
            itemModel = itemRepository.findById(itemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemModel;
    }

    public ItemModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ItemModel itemModel = new ItemModel();
        try {
            itemModel = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return itemModel;
    }

    public ItemModel insert(ItemModel itemModel) {
        itemModel.setId(null);

        ItemModel result = itemRepository.save(itemModel);

        return result;
    }

    public ItemModel update(ItemModel itemModel) {

        findById(itemModel);


        return itemRepository.save(itemModel);
    }

    public boolean delete(Long id) {

        findById(id);

        itemRepository.deleteById(id);

        return true;
    }
}


