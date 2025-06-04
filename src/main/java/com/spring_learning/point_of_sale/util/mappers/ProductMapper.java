package com.spring_learning.point_of_sale.util.mappers;

import com.spring_learning.point_of_sale.dto.ProductDTO;
import com.spring_learning.point_of_sale.model.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDTO> entityListToDtoList(List<Product> products);

    Product dtoToEntity(ProductDTO productDTO);

    List<ProductDTO> listDTOToPage(Page<Product> product);

    List<ProductDTO> pageToList(Page<Product> allProducts);
}
