package com.academiacx.service;

import com.academiacx.handler.exceptions.ForeignKeyException;
import com.academiacx.handler.exceptions.UsuarioNaoEncontradoException;
import com.academiacx.models.CarrinhoModel;
import com.academiacx.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    public List<CarrinhoModel> findAll(){

        return carrinhoRepository.findAll();

    }

    public CarrinhoModel findById(Long id) {

        Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            return carrinhoRepository.findById(id).get();

        }
        return null;
    }
    public CarrinhoModel save(CarrinhoModel carrinhoModel) {
        carrinhoModel.setId(null);

        CarrinhoModel result = carrinhoRepository.save(carrinhoModel);

        return result;
    }

    public CarrinhoModel update(CarrinhoModel carrinhoModel){
        Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(carrinhoModel.getId());
        if (carrinho.isPresent()){
            carrinhoRepository.save(carrinhoModel);
            return carrinho.get();
        }else{
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }

    }

    public CarrinhoModel delete(CarrinhoModel carrinhoModel){
        try {
            Optional<CarrinhoModel> carrinho = carrinhoRepository.findById(carrinhoModel.getId());
            if (carrinho.isPresent()) {
                carrinhoRepository.deleteById(carrinho.get().getId());
                return carrinho.get();
            }
        } catch (Exception e) {
            throw new ForeignKeyException("Entidade presente em varias tabelas");

        }
        return null;

    }
}
