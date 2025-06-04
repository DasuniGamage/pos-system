package com.spring_learning.point_of_sale.service.impl;

import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseOrderDetailsDTO;
import com.spring_learning.point_of_sale.dto.queryInterfaces.OrderDetailsInterface;
import com.spring_learning.point_of_sale.dto.request.RequestOrderSaveDTO;
import com.spring_learning.point_of_sale.dto.request.ResponseOrderDetailsDTO;
import com.spring_learning.point_of_sale.model.OrderDetails;
import com.spring_learning.point_of_sale.model.Orders;
import com.spring_learning.point_of_sale.repository.CustomerRepository;
import com.spring_learning.point_of_sale.repository.OrderDetailsRepository;
import com.spring_learning.point_of_sale.repository.OrderRepository;
import com.spring_learning.point_of_sale.repository.ProductRepository;
import com.spring_learning.point_of_sale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders = new Orders(
                customerRepository.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepository.save(orders);

        if(orderRepository.existsById(orders.getOrderId())){
            List<OrderDetails> orderDetails =modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}.getType());
            for(int i=0; i< orderDetails.size();i++){
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setProducts(productRepository.getById(requestOrderSaveDTO.getOrderDetails().get(i).getProducts()));
            }

            if( orderDetails.size()>0){
                orderDetailsRepository.saveAll(orderDetails);
            }
            return "Order Saved";
        }
        return null;
    }

    @Override
    public PagenatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size) {
        //since we have to use joint query we cant get data as ResponseOrderDetailsDTO dto where we
        // have mingel the attributes of 2 different objects, customer and order so we are going to
        // use an interface with type methods
        List<OrderDetailsInterface> orderDetailsDTOS = orderRepository.getAllOrderDEtails(status, PageRequest.of(page, size));

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for(OrderDetailsInterface o: orderDetailsDTOS){
            ResponseOrderDetailsDTO r =new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumbers(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(r);
        }
        PagenatedResponseOrderDetailsDTO pagenatedResponseOrderDetailsDTO = new PagenatedResponseOrderDetailsDTO(
                list,
                orderRepository.countAllOrderDetails(status)
        );
        return pagenatedResponseOrderDetailsDTO;
    }
}
