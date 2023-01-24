package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.CarrinhoModel;
import com.academiacx.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<CarrinhoModel> carrinhos = carrinhoService.findAll();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
            }
        CarrinhoModel carrinhos = carrinhoService.findById(id);

        if(carrinhos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrinhos);
    }

    @PostMapping("/save")
    public ResponseEntity<CarrinhoModel> save(@Valid @RequestBody CarrinhoModel carrinhoModel){
        carrinhoService.save(carrinhoModel);
        return ResponseEntity.ok(carrinhoModel);
    }
    @PutMapping("/update")
    public ResponseEntity<CarrinhoModel> update(@Valid @RequestBody CarrinhoModel carrinhoModel){
        return ResponseEntity.ok(carrinhoService.update(carrinhoModel));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<CarrinhoModel> delete(@Valid @RequestBody CarrinhoModel carrinhoModel){
        return ResponseEntity.ok(carrinhoService.delete(carrinhoModel));
    }


}












