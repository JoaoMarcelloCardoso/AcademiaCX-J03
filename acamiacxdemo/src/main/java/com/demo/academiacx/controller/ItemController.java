package com.demo.academiacx.controller;

import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService ItemService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ItemModel> response = ItemService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ItemModel findById(@PathVariable Long id) {

        return ItemService.findById(id);
    }

    @PostMapping("/save")
    public ItemModel insert(@RequestBody ItemModel ItemModel) {

        return ItemService.insert(ItemModel);
    }


    @PutMapping("/update")
    public ItemModel update(@RequestBody ItemModel ItemModel) {

        return ItemService.update(ItemModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return ItemService.delete(id);
    }
}
