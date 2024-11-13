package com.rucreativedeveloper.kubernates_demo_crud.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {
    private String productId;
    private String productName;
    private int qty;
}
