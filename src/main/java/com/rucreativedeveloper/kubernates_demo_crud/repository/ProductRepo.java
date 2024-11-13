package com.rucreativedeveloper.kubernates_demo_crud.repository;

import com.rucreativedeveloper.kubernates_demo_crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProductRepo extends JpaRepository<Product, String> {



}
