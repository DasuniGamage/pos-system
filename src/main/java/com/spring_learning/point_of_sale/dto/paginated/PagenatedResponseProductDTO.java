package com.spring_learning.point_of_sale.dto.paginated;

import com.spring_learning.point_of_sale.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagenatedResponseProductDTO {
    List<ProductDTO> list;
    private long dataCount;
}
