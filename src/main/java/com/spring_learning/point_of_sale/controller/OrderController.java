package com.spring_learning.point_of_sale.controller;

import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseOrderDetailsDTO;
import com.spring_learning.point_of_sale.dto.request.RequestOrderSaveDTO;
import com.spring_learning.point_of_sale.service.OrderService;
import com.spring_learning.point_of_sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id +"Success", id),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            params = {"stateType","page","size"},
            path="/get-order-details"
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value="stateType") String state,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50)int size
    ){
        PagenatedResponseOrderDetailsDTO p =  null;
        if(state.equalsIgnoreCase("active")|state.equalsIgnoreCase("inactive")){
            boolean status = state.equalsIgnoreCase("active")? true : false;
            p = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successful",p),HttpStatus.OK
        );
    }
}

