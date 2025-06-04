package com.spring_learning.point_of_sale.model;

import com.spring_learning.point_of_sale.model.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @Column(name="product_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name="product_name", length = 100, nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name="balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name="supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name="selling_price", length = 100, nullable = false)
    private double sellingPrice;

    @Column(name="active_state", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy="products")
    private Set<OrderDetails> orderDetails;

}
