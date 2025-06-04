package com.spring_learning.point_of_sale.repository;

import com.spring_learning.point_of_sale.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByProductNameEqualsAndActiveEquals(String productName, boolean b);


    List<Product> findAllByActiveEquals(boolean active);
    Page<Product> findAllByActiveEquals(boolean active, Pageable pageable);


    int countAllByActiveEquals(boolean active);
}
