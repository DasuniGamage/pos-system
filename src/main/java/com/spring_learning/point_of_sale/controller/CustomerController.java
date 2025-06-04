package com.spring_learning.point_of_sale.controller;

import com.spring_learning.point_of_sale.dto.CustomerDTO;
import com.spring_learning.point_of_sale.dto.request.CustomerUpdateDTO;
import com.spring_learning.point_of_sale.dto.request.UpdateContactDTO;
import com.spring_learning.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String SaveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "ABC";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }

    @PutMapping("/update-contact")
    public String updateContact(@RequestBody UpdateContactDTO updateContactDTO){
        String message = customerService.updateContact(updateContactDTO);
        return message;
    }


    @GetMapping("get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path="/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(path = "/get-by-id-active-state/{status}")
    public List<CustomerDTO> getAllCUstomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}
