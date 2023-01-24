package com.example.ecommerce.service;

import com.example.ecommerce.handler.exceptions.ParametroInvalidoException;
import com.example.ecommerce.handler.exceptions.RecursoNaoEncontradoException;
import com.example.ecommerce.model.CarrinhoModel;
import com.example.ecommerce.repository.CarrinhoRepository;
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

    public CarrinhoModel findById(Long id) {
        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        CarrinhoModel carrinhoModel;
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
        findById(carrinhoModel.getId());

        return carrinhoRepository.save(carrinhoModel);
    }

    public boolean delete(Long id) {
        findById(id);

        carrinhoRepository.deleteById(id);

        return true;
    }

}
