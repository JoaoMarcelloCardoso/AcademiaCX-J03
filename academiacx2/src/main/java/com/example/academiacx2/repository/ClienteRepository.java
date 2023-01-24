package com.example.academiacx2.repository;

import com.example.academiacx2.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
