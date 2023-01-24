package com.example.academiacx2.repository;

import com.example.academiacx2.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
