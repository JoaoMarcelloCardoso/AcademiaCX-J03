package com.academiacxbd.atividadebd.repository;

import com.academiacxbd.atividadebd.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
}
