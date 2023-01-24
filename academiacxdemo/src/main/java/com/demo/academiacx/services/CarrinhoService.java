package com.demo.academiacx.services;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.*;
import com.demo.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> findAll(){

        List<CarrinhoModel> carrinhoModel = carrinhoRepository.findAll();
        return carrinhoModel;
    }

    public CarrinhoModel findById(CarrinhoModel carrinhoModel) {

        if (carrinhoModel == null) {
            throw new ParametroInvalidoException("A Cliente Model deve ser informada");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("A Cliente Model deve conter um id");

        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public CarrinhoModel findById(Long id){

        if(id == null){
            throw new ParametroInvalidoException("Id informado inválido");
        }

        CarrinhoModel carrinhoModel = new CarrinhoModel();
        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        }catch (Exception e){
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public CarrinhoModel insert(CarrinhoModel carrinhoModel){

        carrinhoModel.setId(null);
        return carrinhoRepository.save(carrinhoModel);
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel){

        findById(carrinhoModel);


        return carrinhoRepository.save(carrinhoModel);

    }

    public boolean delete(Long id){

        findById(id);
        carrinhoRepository.deleteById(id);
        return true;

    }

}
