package com.spring_learning.point_of_sale.service;

import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseOrderDetailsDTO;
import com.spring_learning.point_of_sale.dto.request.RequestOrderSaveDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    public PagenatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size);
}
