package com.rucreativedeveloper.kubernates_demo_crud.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDto {

    private String productName;
    private int qty;

}
