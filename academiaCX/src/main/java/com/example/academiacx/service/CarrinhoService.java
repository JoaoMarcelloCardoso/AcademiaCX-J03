package com.example.academiacx.service;

import com.example.academiacx.handler.exceptions.ErroInternoException;
import com.example.academiacx.handler.exceptions.ParametroInvalidoException;
import com.example.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.example.academiacx.model.CarrinhoModel;
import com.example.academiacx.model.ClienteModel;
import com.example.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<CarrinhoModel> findAll() {
        List<CarrinhoModel> CarrinhoModels = carrinhoRepository.findAll();

        return CarrinhoModels;
    }

    public CarrinhoModel findById(CarrinhoModel CarrinhoModel) {

        if (CarrinhoModel == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve informada");

        }

        if (CarrinhoModel.getId() == null) {
            throw new ParametroInvalidoException("O Carrinho Model deve conter um id");
        }

        try {
            CarrinhoModel = carrinhoRepository.findById(CarrinhoModel.getId()).get();

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
            CarrinhoModel = carrinhoRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return CarrinhoModel;
    }

    public CarrinhoModel insert(CarrinhoModel CarrinhoModel) {
        CarrinhoModel.setId(null);

        CarrinhoModel result = carrinhoRepository.save(CarrinhoModel);

        return result;
    }

    public CarrinhoModel update(CarrinhoModel CarrinhoModel) {

        findById(CarrinhoModel);


        return carrinhoRepository.save(CarrinhoModel);
    }

    public boolean delete(Long id) {

        if (findById(id) != null) {
            CarrinhoModel carrinhoModel = findById(id);
            try {
                carrinhoRepository.delete(carrinhoModel);
            } catch (Exception e) {
                throw new ErroInternoException("Erro interno ao deletar", e);
            }
            return true;
        }
        return false;
    }
}
