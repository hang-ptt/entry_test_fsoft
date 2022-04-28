package com.example.entrytest.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    @NotNull
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    @Pattern(regexp = "/((09|03|07|08|05)+(d{8})\\b)/")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
