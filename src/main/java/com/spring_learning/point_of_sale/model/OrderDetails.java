package com.spring_learning.point_of_sale.model;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name="order_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name="order_details_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name="product_name", length = 100, nullable = false)
    private String productName;

    @Column(name="qty", length = 100, nullable = false)
    private double qty;

    @Column(name="amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product products;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Orders orders;

}
