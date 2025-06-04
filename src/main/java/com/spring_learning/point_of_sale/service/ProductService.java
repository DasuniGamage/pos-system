package com.spring_learning.point_of_sale.service;

import com.spring_learning.point_of_sale.dto.ProductDTO;
import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public String saveProduct(ProductDTO productDTO);

    public List<ProductDTO> getProductByNameAndStatus(String productName);

    public List<ProductDTO> getProductByNameAndStatusUsingMapstruct(String productName);

    public List<ProductDTO> getProductByActiveStatus(boolean active);

    public PagenatedResponseProductDTO getProductByActiveStatusWithPagenated(boolean active, int page, int size);

    public PagenatedResponseProductDTO getAllProductsWithPagenated(int page, int size);
}
