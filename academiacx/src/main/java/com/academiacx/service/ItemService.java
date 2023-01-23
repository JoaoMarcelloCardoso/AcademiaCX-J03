package com.academiacx.service;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.ItemModel;
import com.academiacx.repository.ItemRepository;
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
            throw new ParametroInvalidoException("O Item Model deve ser informado!");
        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("O Item Model deve conter um id!");
        }

        try {
            itemModel = itemRepository.findById(itemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return itemModel;
    }

    public ItemModel findById(Long id) {

        ItemModel itemModel = new ItemModel();
        try {
            itemModel = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return itemModel;
    }

    public ItemModel insert(ItemModel itemModel) {
        itemModel.setId(null);

        ItemModel result = null;
        try {
            result = itemRepository.save(itemModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public ItemModel update(ItemModel itemModel) {

        findById(itemModel);

        ItemModel result = null;
        try {
            result = itemRepository.save(itemModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        itemRepository.deleteById(id);

        return true;
    }
}
