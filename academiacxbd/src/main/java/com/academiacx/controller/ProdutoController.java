package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.ProdutoModel;
import com.academiacx.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtosService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ProdutoModel> produtos = produtosService.findAll();
        return ResponseEntity.ok(produtos);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        ProdutoModel produtos = produtosService.findById(id);

        if(produtos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);

    }
    @PostMapping("/save")
    public ResponseEntity<ProdutoModel> save(@Valid @RequestBody ProdutoModel produtosModel){
        produtosService.save(produtosModel);
        return ResponseEntity.ok(produtosModel);
    }

    @PutMapping("/update")
    public ResponseEntity<ProdutoModel> update(@Valid @RequestBody ProdutoModel produtosModel){
        return ResponseEntity.ok(produtosService.update(produtosModel));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ProdutoModel> delete(@Valid @RequestBody ProdutoModel produtosModel){
        return ResponseEntity.ok(produtosService.delete(produtosModel));
    }





}
