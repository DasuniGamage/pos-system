package com.spring_learning.point_of_sale.controller;

import com.spring_learning.point_of_sale.dto.CustomerDTO;
import com.spring_learning.point_of_sale.dto.ProductDTO;
import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseProductDTO;
import com.spring_learning.point_of_sale.service.ProductService;
import com.spring_learning.point_of_sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping("/save")
//    public String saveProduct(@RequestBody ProductDTO productDTO){
//        String message = productService.saveProduct(productDTO);
//        return message;
//    }


    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody ProductDTO productDTO){
        String message = productService.saveProduct(productDTO);
//        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"Success", message), HttpStatus.CREATED
//        );
//        return response;
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ProductDTO> getProductByNameAndStatus(@RequestParam(value = "name") String productName){
        List<ProductDTO> productDTOS = productService.getProductByNameAndStatus(productName);
        return productDTOS;
    }
    @GetMapping(
            path = "/get-by-name-using-mapstruct",
            params = "name"
    )
    public List<ProductDTO> getProductByNameAndStatusUsingMapstruct(@RequestParam(value = "name") String productName){
        List<ProductDTO> productDTOS = productService.getProductByNameAndStatusUsingMapstruct(productName);
        return productDTOS;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> getProductByActiveStatus(
            @RequestParam(value = "activeStatus") boolean active,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
//        List<ProductDTO> productDTOS = productService.getProductByActiveStatus(active,page,size);
        PagenatedResponseProductDTO pagenatedResponseProductDTO = productService.getProductByActiveStatusWithPagenated(active,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",pagenatedResponseProductDTO),HttpStatus.OK
        );
    }
    @GetMapping(
            path = "/get-all-products",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getProductByActiveStatus(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
//        List<ProductDTO> productDTOS = productService.getProductByActiveStatus(active,page,size);
        PagenatedResponseProductDTO pagenatedResponseProductDTO = productService.getAllProductsWithPagenated(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",pagenatedResponseProductDTO),HttpStatus.OK
        );
    }

}
