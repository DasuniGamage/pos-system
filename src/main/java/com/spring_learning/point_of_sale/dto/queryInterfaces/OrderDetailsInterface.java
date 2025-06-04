package com.spring_learning.point_of_sale.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
    //type methods
    String getCustomerName();
    String getCustomerAddress();
    ArrayList getContactNumbers();
    Date getDate();
    Double getTotal();

    //use type method for following attributes of ResponseOrderDetailsDTO
//    private String customerName;
//    private String customerAddress;
//    private ArrayList contactNumbers;
//    private Date date;
//    private Double total;

}
