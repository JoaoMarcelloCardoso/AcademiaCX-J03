package com.demo.academiacx.controller;

import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/price")
public class PrecoController {

    @Autowired
    private PrecoRepository precoRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<PrecoModel> response = precoRepository.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public PrecoModel findById(@PathVariable Long id){
        PrecoModel precos = precoRepository.findById(id).get();
        return precos;
    }

    @PostMapping("/save")
    public PrecoModel insert(@RequestBody PrecoModel precoModel){
        precoModel.setId(null);

        return precoRepository.save(precoModel);
    }

    @PutMapping("/update")
    public PrecoModel update(@RequestBody PrecoModel precoModel){

        if(precoModel.getId() == null){

        }

        PrecoModel result = precoRepository.save(precoModel);
        return result;
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id){

        precoRepository.deleteById(id);
        return true;
    }

}
