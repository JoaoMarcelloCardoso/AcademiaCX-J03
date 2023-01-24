package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.models.ItemModel;
import com.academiacx.repository.ItemRepository;

import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public List<ItemModel> findAll(){

        return itemRepository.findAll();

    }

    public ItemModel findById(Long id) {

        Optional<ItemModel> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return itemRepository.findById(id).get();

        }
        return null;
    }
    public ItemModel save(ItemModel itemModel) {
        itemModel.setId(null);

        ItemModel result = itemRepository.save(itemModel);

        return result;
    }

    public ItemModel update(ItemModel itemModel){
        Optional<ItemModel> item = itemRepository.findById(itemModel.getId());
        if (item.isPresent()){
            itemRepository.save(itemModel);
            return item.get();
        }else{
            throw new UsuarioNaoEncontradoException("Item não encontrado");
        }

    }

    public ItemModel delete(ItemModel itemModel){
        try {
            Optional<ItemModel> item = itemRepository.findById(itemModel.getId());
            if (item.isPresent()) {
                itemRepository.deleteById(item.get().getId());
                return item.get();
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
