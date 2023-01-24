package com.example.ecommerce.controller;

import com.example.ecommerce.model.ItemModel;
import com.example.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ItemModel> response = itemService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ItemModel findById(@PathVariable Long id) {

        return itemService.findById(id);
    }

    @PostMapping("/save")
    public ItemModel insert(@RequestBody ItemModel itemModel) {

        return itemService.insert(itemModel);
    }

    @PutMapping("/update")
    public ItemModel update(@RequestBody ItemModel itemModel) {

        return itemService.update(itemModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return itemService.delete(id);
    }

}