package com.security.learning.program.controllers;

import com.security.learning.program.entities.product.Product;
import com.security.learning.program.entities.product.ProductRequestDTO;
import com.security.learning.program.entities.product.ProductResponseDTO;
import com.security.learning.program.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {

        var productResponseList = repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productResponseList);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> post(@Valid @RequestBody ProductRequestDTO request) {
        var product = new Product(request);

        repository.save(product);

        return ResponseEntity.ok().build();
    }
}
