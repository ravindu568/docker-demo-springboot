package com.rucreativedeveloper.kubernates_demo_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="product")
@Builder

public class Product {
    @Id
    private String productId;

    private String productName;

    private int qty;
}
