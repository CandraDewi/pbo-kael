package com.kidaro.kael.repository;

import com.kidaro.kael.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
