package com.spring_learning.point_of_sale.dto.request;

import com.spring_learning.point_of_sale.model.Orders;
import com.spring_learning.point_of_sale.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {

    private String productName;
    private double qty;
    private double amount;
    private int products;
    private int orders;
}
