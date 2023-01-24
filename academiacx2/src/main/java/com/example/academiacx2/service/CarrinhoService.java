package com.example.academiacx2.service;

import com.example.academiacx2.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx2.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx2.model.CarrinhoModel;
import com.example.academiacx2.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> findall(){
        List<CarrinhoModel> carrinhoModels = carrinhoRepository.findAll();

        return carrinhoModels;
    }

    public CarrinhoModel findById(CarrinhoModel carrinhoModel) {

        if (carrinhoModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public CarrinhoModel findById(Long id) {

        CarrinhoModel carrinhoModel = new CarrinhoModel();

        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public CarrinhoModel insert(CarrinhoModel carrinhoModel) {
        carrinhoModel.setId(null);

        CarrinhoModel result = carrinhoRepository.save(carrinhoModel);

        return result;
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel) {

        findById(carrinhoModel);


        return carrinhoRepository.save(carrinhoModel);
    }

    public boolean delete(Long id){

        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }
}
