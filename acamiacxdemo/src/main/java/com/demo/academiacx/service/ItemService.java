package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository ItemRepository;

    public List<ItemModel> findAll() {
        List<ItemModel> ItemModels = ItemRepository.findAll();

        return ItemModels;
    }

    public ItemModel findById(ItemModel ItemModel) {

        if (ItemModel == null) {
            throw new ParametroInvalidoException("A Item Model deve informada");

        }

        if (ItemModel.getId() == null) {
            throw new ParametroInvalidoException("A Item Model deve conter um id");

        }

        try {
            ItemModel = ItemRepository.findById(ItemModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ItemModel;
    }

    public ItemModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        ItemModel ItemModel = new ItemModel();
        try {
            ItemModel = ItemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ItemModel;
    }

    public ItemModel insert(ItemModel ItemModel) {
        ItemModel.setId(null);

        ItemModel result = ItemRepository.save(ItemModel);

        return result;
    }

    public ItemModel update(ItemModel ItemModel) {

        findById(ItemModel);


        return ItemRepository.save(ItemModel);
    }

    public boolean delete(Long id) {

        findById(id);

        ItemRepository.deleteById(id);

        return true;
    }
}
