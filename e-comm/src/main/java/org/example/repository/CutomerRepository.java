package org.example.repository;

import org.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CutomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
