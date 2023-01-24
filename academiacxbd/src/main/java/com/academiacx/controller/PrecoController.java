package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.PrecoModel;
import com.academiacx.service.PrecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {
    @Autowired
    private PrecoService precoService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<PrecoModel> precos = precoService.findAll();
        return ResponseEntity.ok(precos);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        PrecoModel precos = precoService.findById(id);

        if(precos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(precos);

    }
    @PostMapping("/save")
    public ResponseEntity<PrecoModel> save(@Valid @RequestBody PrecoModel precoModel){
        precoService.save(precoModel);
        return ResponseEntity.ok(precoModel);
    }

    @PutMapping("/update")
    public ResponseEntity<PrecoModel> update(@Valid @RequestBody PrecoModel precoModel){
        return ResponseEntity.ok(precoService.update(precoModel));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<PrecoModel> delete(@Valid @RequestBody PrecoModel precoModel){
        return ResponseEntity.ok(precoService.delete(precoModel));
    }





}
