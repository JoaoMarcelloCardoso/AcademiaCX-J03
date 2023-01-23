package com.academiacxbd.atividadebd.repository;

import com.academiacxbd.atividadebd.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
