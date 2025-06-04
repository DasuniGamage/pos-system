package com.spring_learning.point_of_sale.service.impl;

import com.spring_learning.point_of_sale.dto.ProductDTO;
import com.spring_learning.point_of_sale.dto.paginated.PagenatedResponseProductDTO;
import com.spring_learning.point_of_sale.exception.NotFoundException;
import com.spring_learning.point_of_sale.model.Product;
import com.spring_learning.point_of_sale.model.enums.MeasuringUnitType;
import com.spring_learning.point_of_sale.repository.ProductRepository;
import com.spring_learning.point_of_sale.service.ProductService;
import com.spring_learning.point_of_sale.util.mappers.ProductMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public String saveProduct(ProductDTO productDTO) {
//        Product product = new Product(
//                productDTO.getProductId(),
//                productDTO.getProductName(),
//                productDTO.getMeasuringUnitType(),
//                productDTO.getBalanceQty(),
//                productDTO.getSupplierPrice(),
//                productDTO.getSellingPrice(),
//                productDTO.isActive()
//        );
//        productRepository.save(product);
//        return "Product Saved Successfully";

//        Product product = modelMapper.map(productDTO,Product.class);
        Product product=productMapper.dtoToEntity(productDTO);
            productRepository.save(product);
            return product.getProductName() +" Saved Successfullly";
    }

    @Override
    public List<ProductDTO> getProductByNameAndStatus(String productName) {
        boolean b = true;
        List<Product> products = productRepository.findAllByProductNameEqualsAndActiveEquals(productName,b);
        if (products.size()>0){
            List<ProductDTO> productDTOList = modelMapper.map(products,new TypeToken<List<ProductDTO>>(){}.getType());
            return productDTOList;
        }else {
            throw new RuntimeException("Not Found");
        }

    }

    @Override
    public List<ProductDTO> getProductByNameAndStatusUsingMapstruct(String productName) {
        List<Product> products = productRepository.findAllByProductNameEqualsAndActiveEquals(productName,true);
        if (products.size()>0){
            List<ProductDTO> productDTOList = productMapper.entityListToDtoList(products);
            return productDTOList;
        }else {
            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public List<ProductDTO> getProductByActiveStatus(boolean active) {
        List<Product> products = productRepository.findAllByActiveEquals (active);
        if (products.size()>0){
            List<ProductDTO> productDTOList = modelMapper.map(products,new TypeToken<List<ProductDTO>>(){}.getType());
            return productDTOList;
        }else {
            throw new NotFoundException("Not Found");
        }
    }

    @Override
    public PagenatedResponseProductDTO getProductByActiveStatusWithPagenated(boolean active, int page, int size) {
        Page<Product> products = productRepository.findAllByActiveEquals(active, PageRequest.of(page, size));
        int count = productRepository.countAllByActiveEquals(active);
        if(products.getSize()<1){
            throw new NotFoundException("No products found");
        }else{
            PagenatedResponseProductDTO pagenatedResponseProductDTO =new PagenatedResponseProductDTO(
                    productMapper.listDTOToPage(products), count

            );
            return pagenatedResponseProductDTO;

        }
    }

    @Override
    public PagenatedResponseProductDTO getAllProductsWithPagenated(int page, int size) {
        Page<Product> allProducts = productRepository.findAll(PageRequest.of(page, size));
        if(allProducts.getSize()<1){
            throw new NotFoundException("No Products Found");
        }else{
            PagenatedResponseProductDTO pagenatedResponseProductDTO=new PagenatedResponseProductDTO(
                    productMapper.pageToList(allProducts), productRepository.count()
            );
            return pagenatedResponseProductDTO ;
        }

    }
}
