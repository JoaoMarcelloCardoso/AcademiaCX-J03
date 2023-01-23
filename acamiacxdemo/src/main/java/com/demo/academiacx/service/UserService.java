package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoExeception;
import com.demo.academiacx.model.UserModel;
import com.demo.academiacx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        List<UserModel> userModels = userRepository.findAll();

        return userModels;
    }

    public UserModel findById(UserModel userModel) {

        if (userModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (userModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            userModel = userRepository.findById(userModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoExeception("Id informado não encontrado");
        }

        return userModel;
    }

    public UserModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoExeception("Id informado não encontrado");
        }

        return userModel;
    }

    public UserModel insert(UserModel userModel) {
        userModel.setId(null);

        UserModel result = userRepository.save(userModel);

        return result;
    }

    public UserModel update(UserModel userModel) {

        findById(userModel);


        return userRepository.save(userModel);
    }

    public boolean delete(Long id) {

        findById(id);

        userRepository.deleteById(id);

        return true;
    }
}
