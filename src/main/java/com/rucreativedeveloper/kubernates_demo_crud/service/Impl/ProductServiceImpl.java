package com.rucreativedeveloper.kubernates_demo_crud.service.Impl;

import com.rucreativedeveloper.kubernates_demo_crud.dto.request.RequestProductDto;
import com.rucreativedeveloper.kubernates_demo_crud.dto.response.ResponseProductDto;
import com.rucreativedeveloper.kubernates_demo_crud.entity.Product;
import com.rucreativedeveloper.kubernates_demo_crud.exception.EntryNotFoundException;
import com.rucreativedeveloper.kubernates_demo_crud.repository.ProductRepo;
import com.rucreativedeveloper.kubernates_demo_crud.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void save(RequestProductDto requestProductDto) {

        Product product= Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName(requestProductDto.getProductName())
                .qty(requestProductDto.getQty())
                .build();

        productRepo.save(product);
    }

    @Override
    public void update(RequestProductDto requestProductDto, String productId) {

        Optional<Product> product = productRepo.findById(productId);

        if(product.isEmpty()){
            throw new EntryNotFoundException("Product Not Found");
        }

        Product selectedproduct=product.get();

        selectedproduct.setProductName(requestProductDto.getProductName());
        selectedproduct.setQty(requestProductDto.getQty());
        productRepo.save(selectedproduct);

    }


    @Override
    public void delete(String productId) {
        Optional<Product> product = productRepo.findById(productId);

        if(product.isEmpty()){
            throw new EntryNotFoundException("Product Not Found");
        }

        productRepo.deleteById(product.get().getProductId());

    }

    @Override
    public ResponseProductDto get(String productId) {
        Optional<Product> product = productRepo.findById(productId);
        if(product.isEmpty()){
            throw new EntryNotFoundException("Product Not Found");
        }

        return toResponseProductDto(product.get());

    }


    private ResponseProductDto toResponseProductDto(Product product) {
        if(product == null){
            throw new EntryNotFoundException("Product Not Found");
        }

        return ResponseProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .qty(product.getQty())
                .build();

    }
}
