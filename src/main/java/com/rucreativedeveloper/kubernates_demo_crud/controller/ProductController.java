package com.rucreativedeveloper.kubernates_demo_crud.controller;

import com.rucreativedeveloper.kubernates_demo_crud.dto.request.RequestProductDto;
import com.rucreativedeveloper.kubernates_demo_crud.dto.response.ResponseProductDto;
import com.rucreativedeveloper.kubernates_demo_crud.entity.Product;
import com.rucreativedeveloper.kubernates_demo_crud.service.ProductService;
import com.rucreativedeveloper.kubernates_demo_crud.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

@PostMapping("/save")
   public ResponseEntity<StandardResponseDto> save(@RequestBody RequestProductDto requestProductDto) {


    productService.save(requestProductDto);
    return new
            ResponseEntity<>(
                    new StandardResponseDto(
                            201,"Product Successfully saved",requestProductDto
                    ), HttpStatus.CREATED
    );

}

@GetMapping("/get/{productId}")
    public ResponseEntity<StandardResponseDto> get(@PathVariable(name = "productId") String productId) {

    ResponseProductDto productDto=productService.get(productId);

    return new
            ResponseEntity<>(
            new StandardResponseDto(
                    201,"Your Product is:",productDto
            ), HttpStatus.OK
    );

}

@DeleteMapping("/delete/{productId}")
    public ResponseEntity<StandardResponseDto> delete(@PathVariable(name = "productId") String productId) {

    productService.delete(productId);
    return new
            ResponseEntity<>(
            new StandardResponseDto(
                    201,"Your Product is sucessfully deleted",productId
            ), HttpStatus.OK
    );

}

@PutMapping("/update/{productId}")
    public ResponseEntity<StandardResponseDto> update(@PathVariable(name = "productId") String productId, @RequestBody RequestProductDto requestProductDto) {

    productService.update(requestProductDto, productId);
    return new
            ResponseEntity<>(
            new StandardResponseDto(
                    201,"Your Product is updated",productId
            ), HttpStatus.OK
    );

}


}
