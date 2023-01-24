package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.EnderecoModel;
import com.academiacx.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<EnderecoModel> enderecos = enderecoService.findAll();
        return ResponseEntity.ok(enderecos);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        EnderecoModel enderecos = enderecoService.findById(id);

        if(enderecos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecos);

    }
    @PostMapping("/save")
    public ResponseEntity<EnderecoModel> save(@Valid @RequestBody EnderecoModel enderecoModel){
        enderecoService.save(enderecoModel);
        return ResponseEntity.ok(enderecoModel);
    }

    @PutMapping("/update")
    public ResponseEntity<EnderecoModel> update(@Valid @RequestBody EnderecoModel enderecoModel){
        return ResponseEntity.ok(enderecoService.update(enderecoModel));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<EnderecoModel> delete(@Valid @RequestBody EnderecoModel enderecoModel){
        return ResponseEntity.ok(enderecoService.delete(enderecoModel));
    }





}
