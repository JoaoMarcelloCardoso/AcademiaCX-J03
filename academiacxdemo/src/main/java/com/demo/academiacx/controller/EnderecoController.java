package com.demo.academiacx.controller;

import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.repository.EnderecoRepository;
import com.demo.academiacx.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<EnderecoModel> response = enderecoService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public EnderecoModel findById(@PathVariable Long id){
        return enderecoService.findById(id);
    }

    @PostMapping("/save")
    public EnderecoModel insert(@RequestBody EnderecoModel enderecoModel){
        return enderecoService.insert(enderecoModel);
    }

    @PutMapping("/update")
    public EnderecoModel update(@RequestBody EnderecoModel enderecoModel){

        return enderecoService.update(enderecoModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        return enderecoService.delete(id);
    }

}
