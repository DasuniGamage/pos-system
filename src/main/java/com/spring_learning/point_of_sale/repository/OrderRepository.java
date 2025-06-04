package com.spring_learning.point_of_sale.repository;

import com.spring_learning.point_of_sale.dto.queryInterfaces.OrderDetailsInterface;
import com.spring_learning.point_of_sale.dto.request.ResponseOrderDetailsDTO;
import com.spring_learning.point_of_sale.model.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Orders,Integer> {

    @Query(value = "SELECT c.customer_name AS customerName,c.customer_address AS customerAddress,c.contact_numbers AS contactNumbers,o.order_date AS date, o.total AS total FROM customer c INNER JOIN orders o USING(customer_id) WHERE c.active_state =?1 ", nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDEtails(boolean status, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM customer c INNER JOIN orders o USING(customer_id) WHERE c.active_state =?1 ", nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
