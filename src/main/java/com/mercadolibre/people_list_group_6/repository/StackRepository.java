package com.mercadolibre.people_list_group_6.repository;

import com.mercadolibre.people_list_group_6.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StackRepository extends JpaRepository<Stack, UUID> {
}
