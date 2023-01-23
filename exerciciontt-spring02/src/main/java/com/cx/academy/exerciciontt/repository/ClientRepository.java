package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
