package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository CarrinhoRepository;

    public List<CarrinhoModel> findAll() {
        List<CarrinhoModel> CarrinhoModels = CarrinhoRepository.findAll();

        return CarrinhoModels;
    }

    public CarrinhoModel findById(CarrinhoModel CarrinhoModel) {

        if (CarrinhoModel == null) {
            throw new ParametroInvalidoException("A Carrinho Model deve informada");

        }

        if (CarrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("A Carrinho Model deve conter um id");

        }

        try {
            CarrinhoModel = CarrinhoRepository.findById(CarrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return CarrinhoModel;
    }

    public CarrinhoModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        CarrinhoModel CarrinhoModel = new CarrinhoModel();
        try {
            CarrinhoModel = CarrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return CarrinhoModel;
    }

    public CarrinhoModel insert(CarrinhoModel CarrinhoModel) {
        CarrinhoModel.setId(null);

        CarrinhoModel result = CarrinhoRepository.save(CarrinhoModel);

        return result;
    }

    public CarrinhoModel update(CarrinhoModel CarrinhoModel) {

        findById(CarrinhoModel);


        return CarrinhoRepository.save(CarrinhoModel);
    }

    public boolean delete(Long id) {

        findById(id);

        CarrinhoRepository.deleteById(id);

        return true;
    }
}
