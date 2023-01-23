package com.academiacx.service;

import com.academiacx.handler.exceptions.ConstraintViolationException;
import com.academiacx.handler.exceptions.ParametroInvalidoException;
import com.academiacx.handler.exceptions.ParametroNullException;
import com.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.academiacx.model.CarrinhoModel;
import com.academiacx.repository.CarrinhoRepository;
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
            throw new ParametroInvalidoException("O Carrinho Model deve ser informado!");
        }

        if (carrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve conter um id!");
        }

        try {
            carrinhoModel = carrinhoRepository.findById(carrinhoModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return carrinhoModel;
    }

    public CarrinhoModel findById(Long id) {

        CarrinhoModel carrinhoModel = new CarrinhoModel();
        try {
            carrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return carrinhoModel;
    }

    public CarrinhoModel insert(CarrinhoModel carrinhoModel) {
        carrinhoModel.setId(null);

        CarrinhoModel result = null;
        try {
            result = carrinhoRepository.save(carrinhoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel) {

        findById(carrinhoModel);

        CarrinhoModel result = null;
        try {
            result = carrinhoRepository.save(carrinhoModel);
        } catch (Exception e) {
            throw new ParametroNullException("Algum dado obrigatório não foi inserido!");
        }

        return result;
    }

    public boolean delete(Long id) {

        findById(id);

        try {
            carrinhoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new ConstraintViolationException("Esta ação viola a integridade dos dados presentes no banco de dados!");
        }

    }
}
