package com.academiacx.controller;

import com.academiacx.models.ItemModel;
import com.academiacx.service.ItemService;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<ItemModel> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        ItemModel items = itemService.findById(id);

        if (items == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);

    }

    @PostMapping("/save")
    public ResponseEntity<ItemModel> save(@Valid @RequestBody ItemModel itemModel) {
        itemService.save(itemModel);
        return ResponseEntity.ok(itemModel);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemModel> update(@Valid @RequestBody ItemModel itemModel) {
        return ResponseEntity.ok(itemService.update(itemModel));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ItemModel> delete(@Valid @RequestBody ItemModel itemModel) {
        return ResponseEntity.ok(itemService.delete(itemModel));
    }
}


