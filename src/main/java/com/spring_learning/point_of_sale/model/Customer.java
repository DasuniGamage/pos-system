package com.spring_learning.point_of_sale.model;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name="customer_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name",length=100,nullable = false)
    private String customerName;

    @NotNull
    @Column(name="customer_Address",length=255)
    private String customerAddress;

    @Column(name="customer_salary")
    private double customerSalary;

    @Type(type="json")
    @Column(name="contact_numbers",columnDefinition = "json")
    private ArrayList<String> contactNumbers;

    @Column(name="nic")
    private String nic;

    @Column(name="active_state", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy="customer")
    private Set<Orders> orders;

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList<String> contactNumbers, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.active = active;
    }
}
