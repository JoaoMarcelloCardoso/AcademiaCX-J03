package com.academiacxbd.atividadebd.service;

import com.academiacxbd.atividadebd.handler.exceptions.ParametroInvalidoException;
import com.academiacxbd.atividadebd.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacxbd.atividadebd.model.CarrinhoModel;
import com.academiacxbd.atividadebd.repository.CarrinhoRepository;
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
            throw new ParametroInvalidoException("O Carrinho Model deve ser informada");

        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve conter um id");

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
