package com.spring_learning.point_of_sale.dto.paginated;

import com.spring_learning.point_of_sale.dto.request.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagenatedResponseOrderDetailsDTO  {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
