package com.example.ecommerce.service;

import com.example.ecommerce.model.ItemModel;
import com.example.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findAll() {
        return itemRepository.findAll();
    }

    public ItemModel findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public ItemModel insert(ItemModel itemModel) {
        return itemRepository.save(itemModel);
    }

    public ItemModel update(ItemModel itemModel) {
        return itemRepository.save(itemModel);
    }

    public boolean delete(Long id) {
        itemRepository.deleteById(id);
        return true;
    }
}
