package com.example.ecommerce.controller;

import com.example.ecommerce.model.ProdutoModel;
import com.example.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ProdutoModel> response = produtoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ProdutoModel findById(@PathVariable Long id) {

        return produtoService.findById(id);
    }

    @PostMapping("/save")
    public ProdutoModel insert(@RequestBody ProdutoModel produtoModel) {

        return produtoService.insert(produtoModel);
    }

    @PutMapping("/update")
    public ProdutoModel update(@RequestBody ProdutoModel produtoModel) {

        return produtoService.update(produtoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return produtoService.delete(id);
    }

}