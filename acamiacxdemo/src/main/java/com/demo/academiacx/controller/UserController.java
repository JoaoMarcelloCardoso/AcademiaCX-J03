package com.demo.academiacx.controller;

import com.demo.academiacx.model.UserModel;
import com.demo.academiacx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<UserModel> response = userService.findAll();

        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        UserModel response = userService.findById(id);

        return response == null? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> insert(@RequestBody UserModel userModel) {

        UserModel response = userService.insert(userModel);

        return response == null? ResponseEntity.badRequest().build(): ResponseEntity.ok(response) ;
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserModel userModel) {

        UserModel response = userService.update(userModel);

        return response == null? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id", required = false) Long id) {

        boolean success = userService.delete(id);

        return success? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


}
