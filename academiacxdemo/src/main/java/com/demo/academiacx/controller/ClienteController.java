package com.demo.academiacx.controller;

import java.util.List;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.repository.ClienteRepository;
import com.demo.academiacx.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ClienteModel> response = clienteService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ClienteModel findById(@PathVariable Long id){
        return clienteService.findById(id);

    }

    @PostMapping("/save")
    public ClienteModel insert(@RequestBody ClienteModel clienteModel) {

        return clienteService.insert(clienteModel);
    }

    @PutMapping("/update")
    public ClienteModel update(@RequestBody ClienteModel clienteModel){

        return clienteService.update(clienteModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        return clienteService.delete(id);
    }
}
