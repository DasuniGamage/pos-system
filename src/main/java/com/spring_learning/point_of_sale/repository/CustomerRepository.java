package com.spring_learning.point_of_sale.repository;

import com.spring_learning.point_of_sale.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByActiveEquals(boolean activeState);
}
