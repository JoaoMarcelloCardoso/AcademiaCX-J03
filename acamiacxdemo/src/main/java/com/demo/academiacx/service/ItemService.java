package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ErroInternoException;
import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        List<ItemModel> ItemModels = itemRepository.findAll();

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
            ItemModel = itemRepository.findById(ItemModel.getId()).get();

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
            ItemModel = itemRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return ItemModel;
    }

    public ItemModel insert(ItemModel ItemModel) {
        ItemModel.setId(null);

        ItemModel result = itemRepository.save(ItemModel);

        return result;
    }

    public ItemModel update(ItemModel ItemModel) {

        findById(ItemModel);


        return itemRepository.save(ItemModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            ItemModel itemModel = findById(id);
            try {
                itemRepository.delete(itemModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }

            return true;
        }
        return false;
    }
}
