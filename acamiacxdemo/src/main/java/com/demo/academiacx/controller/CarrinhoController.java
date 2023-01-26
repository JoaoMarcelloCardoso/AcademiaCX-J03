package com.demo.academiacx.controller;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService CarrinhoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<CarrinhoModel> response = CarrinhoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public CarrinhoModel findById(@PathVariable Long id) {

        return CarrinhoService.findById(id);
    }

    @PostMapping("/save")
    public CarrinhoModel insert(@RequestBody CarrinhoModel CarrinhoModel) {

        return CarrinhoService.insert(CarrinhoModel);
    }


    @PutMapping("/update")
    public CarrinhoModel update(@RequestBody CarrinhoModel CarrinhoModel) {

        return CarrinhoService.update(CarrinhoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return CarrinhoService.delete(id);
    }
}
