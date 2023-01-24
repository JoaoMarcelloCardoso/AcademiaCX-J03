package com.example.academiacx.controller;

import com.example.academiacx.model.PrecoModel;
import com.example.academiacx.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preco")
public class PrecoController {
    @Autowired
    private PrecoService PrecoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<PrecoModel> response = PrecoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public PrecoModel findById(@PathVariable Long id) {

        return PrecoService.findById(id);
    }

    @PostMapping("/save")
    public PrecoModel insert(@RequestBody PrecoModel PrecoModel) {

        return PrecoService.insert(PrecoModel);
    }


    @PutMapping("/update")
    public PrecoModel update(@RequestBody PrecoModel PrecoModel) {

        return PrecoService.update(PrecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return PrecoService.delete(id);
    }
}