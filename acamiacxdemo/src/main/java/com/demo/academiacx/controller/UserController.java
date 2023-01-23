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
    public UserModel findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserModel insert(@RequestBody UserModel userModel) {

        return userService.insert(userModel);
    }


    @PutMapping("/update")
    public UserModel update(@RequestBody UserModel userModel) {

        return userService.update(userModel);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id", required = false) Long id) {

        return userService.delete(id);
    }


}
