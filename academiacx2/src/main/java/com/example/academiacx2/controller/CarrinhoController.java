package com.example.academiacx2.controller;

import com.example.academiacx2.model.CarrinhoModel;
import com.example.academiacx2.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CarrinhoModel> response =  carrinhoService.findall();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public CarrinhoModel findById(@PathVariable Long id){

        return carrinhoService.findById(id);
    }

    @PostMapping("/save")
    public CarrinhoModel insert(@RequestBody CarrinhoModel carrinhoModel) {

        return carrinhoService.insert(carrinhoModel);
    }

    @PutMapping("/update")
    public CarrinhoModel update(@RequestBody CarrinhoModel carrinhoModel) {

        return carrinhoService.update(carrinhoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return carrinhoService.delete(id);
    }
}
