package com.rucreativedeveloper.kubernates_demo_crud.service;

import com.rucreativedeveloper.kubernates_demo_crud.dto.request.RequestProductDto;
import com.rucreativedeveloper.kubernates_demo_crud.dto.response.ResponseProductDto;

public interface ProductService {
    public void save(RequestProductDto requestProductDto);
    public void update(RequestProductDto requestProductDto,String productId);
    public void delete(String productId);
    public ResponseProductDto get(String productId);
}
