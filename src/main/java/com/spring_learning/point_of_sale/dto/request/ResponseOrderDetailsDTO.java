package com.spring_learning.point_of_sale.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //customer
    //this should be in the response package inside the dto package
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumbers;

    //order
    private Date date;
    private Double total;


}
