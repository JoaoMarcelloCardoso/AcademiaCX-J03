package com.spring.academiacx.repository;

import com.spring.academiacx.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
}
