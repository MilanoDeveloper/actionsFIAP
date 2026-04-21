package com.fiap.actions.controller;

import com.fiap.actions.dto.ProductDTO;
import com.fiap.actions.model.Product;
import com.fiap.actions.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody ProductDTO data) {
        return repository.save(new Product(null, data.name(), data.price()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
