package com.spring.academiacx.service;

import com.spring.academiacx.handler.exceptions.ParametroInvalidoException;
import com.spring.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> findAll() {
        List<CarrinhoModel> carrinhoModels = carrinhoRepository.findAll();

        return carrinhoModels;
    }

    public CarrinhoModel findById(CarrinhoModel carrinhoModel) {

        if (carrinhoModel == null) {
            throw new ParametroInvalidoException("O Model Carrinho deve informado");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("O Model Carrinho deve conter um id");

        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return carrinhoModel;
    }

    public CarrinhoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

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

    public boolean delete(Long id) {

        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }
}