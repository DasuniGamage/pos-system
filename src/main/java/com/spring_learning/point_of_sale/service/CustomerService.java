package com.spring_learning.point_of_sale.service;

import com.spring_learning.point_of_sale.dto.CustomerDTO;
import com.spring_learning.point_of_sale.dto.request.CustomerUpdateDTO;
import com.spring_learning.point_of_sale.dto.request.UpdateContactDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public String updateContact(UpdateContactDTO updateContactDTO);

    public CustomerDTO getCustomerById(int customerId);

    public List<CustomerDTO> getAllCustomers();

    public String deleteCustomer(int customerId);

    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
