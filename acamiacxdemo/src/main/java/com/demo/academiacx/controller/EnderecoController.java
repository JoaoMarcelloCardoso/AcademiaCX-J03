package com.demo.academiacx.controller;

import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService EnderecoService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<EnderecoModel> response = EnderecoService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public EnderecoModel findById(@PathVariable Long id) {

        return EnderecoService.findById(id);
    }

    @PostMapping("/save")
    public EnderecoModel insert(@RequestBody EnderecoModel EnderecoModel) {

        return EnderecoService.insert(EnderecoModel);
    }


    @PutMapping("/update")
    public EnderecoModel update(@RequestBody EnderecoModel EnderecoModel) {

        return EnderecoService.update(EnderecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return EnderecoService.delete(id);
    }
}
