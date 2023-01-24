package com.academiacxbd.atividadebd.service;

import com.academiacxbd.atividadebd.handler.exceptions.ParametroInvalidoException;
import com.academiacxbd.atividadebd.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacxbd.atividadebd.model.EnderecoModel;
import com.academiacxbd.atividadebd.model.ItemModel;
import com.academiacxbd.atividadebd.repository.EnderecoRepository;
import com.academiacxbd.atividadebd.repository.ItemRepository;
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
            throw new ParametroInvalidoException("O Item Model deve ser informada");

        }

        if (itemModel.getId() == null) {
            throw new ParametroInvalidoException("O Item Model deve conter um id");

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
