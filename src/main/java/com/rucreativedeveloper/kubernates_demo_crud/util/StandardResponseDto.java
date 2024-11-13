package com.rucreativedeveloper.kubernates_demo_crud.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseDto {
    private int code;
    private String message;
    private Object data;
}
