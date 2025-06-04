package com.spring_learning.point_of_sale.service.impl;

import com.spring_learning.point_of_sale.dto.CustomerDTO;
import com.spring_learning.point_of_sale.dto.request.CustomerUpdateDTO;
import com.spring_learning.point_of_sale.dto.request.UpdateContactDTO;
import com.spring_learning.point_of_sale.exception.NotFoundException;
import com.spring_learning.point_of_sale.model.Customer;
import com.spring_learning.point_of_sale.repository.CustomerRepository;
import com.spring_learning.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );

        customerRepository.save(customer);
        System.out.println(customerDTO.getCustomerId());
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepository.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepository.getById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepository.save(customer);
            return customerUpdateDTO.getCustomerName() + "Updated Successfully";
        } else {
            throw new RuntimeException("No data found for that ID");
        }
    }

    @Override
    public String updateContact(UpdateContactDTO updateContactDTO) {
        if (customerRepository.existsById(updateContactDTO.getCustomerId())) {
            System.out.println(updateContactDTO.getContactNumbers());
            Customer customer = customerRepository.getById(updateContactDTO.getCustomerId());
            customer.setCustomerName(updateContactDTO.getCustomerName());
            customer.setContactNumbers(updateContactDTO.getContactNumbers());

            customerRepository.save(customer);

            return "contact numbers for " + updateContactDTO.getCustomerName() + " updated";
        } else {
            throw new RuntimeException("No user exists");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepository.existsById(customerId)) {
            Customer customer = customerRepository.getById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;

        } else {
            throw new RuntimeException("No user found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getAllCustomers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        if (getAllCustomers.size()>0) {

            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNumbers(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }

            return customerDTOList;
        }else{
            throw new NotFoundException("No Customer Found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return "Deleted Successfully " + customerId;
        } else {
            throw new RuntimeException("No customer found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepository.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

}
