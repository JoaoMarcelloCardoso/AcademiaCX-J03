package com.academiacx.controller;

import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.models.ClienteModel;
import com.academiacx.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ClienteModel> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id não pode ser nulo");
        }

        ClienteModel clientes = clienteService.findById(id);

        if(clientes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);

    }
    @PostMapping("/save")
    public ResponseEntity<ClienteModel> save(@Valid @RequestBody ClienteModel clienteModel){
         clienteService.save(clienteModel);
        return ResponseEntity.ok(clienteModel);
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteModel> update(@Valid @RequestBody ClienteModel clienteModel){
        return ResponseEntity.ok(clienteService.update(clienteModel));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ClienteModel> delete(@Valid @RequestBody ClienteModel clienteModel){
        return ResponseEntity.ok(clienteService.delete(clienteModel));
    }





}
