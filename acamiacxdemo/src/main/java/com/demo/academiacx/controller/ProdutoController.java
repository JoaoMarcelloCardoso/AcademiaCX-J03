package com.demo.academiacx.controller;

import com.demo.academiacx.model.ProdutoModel;
import com.demo.academiacx.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService ProdutoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<ProdutoModel> response = ProdutoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ProdutoModel findById(@PathVariable Long id) {

        return ProdutoService.findById(id);
    }

    @PostMapping("/save")
    public ProdutoModel insert(@RequestBody ProdutoModel ProdutoModel) {

        return ProdutoService.insert(ProdutoModel);
    }


    @PutMapping("/update")
    public ProdutoModel update(@RequestBody ProdutoModel ProdutoModel) {

        return ProdutoService.update(ProdutoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return ProdutoService.delete(id);
    }
}
