package com.example.academiacx.repository;

import com.example.academiacx.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
