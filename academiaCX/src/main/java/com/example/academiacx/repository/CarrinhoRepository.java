package com.example.academiacx.repository;

import com.example.academiacx.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
}
