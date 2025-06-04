package com.spring_learning.point_of_sale.dto.request;

import com.spring_learning.point_of_sale.model.Customer;
import com.spring_learning.point_of_sale.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetails;

}
