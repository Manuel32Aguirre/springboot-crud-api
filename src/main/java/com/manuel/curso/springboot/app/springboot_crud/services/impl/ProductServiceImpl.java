package com.manuel.curso.springboot.app.springboot_crud.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manuel.curso.springboot.app.springboot_crud.entities.Product;
import com.manuel.curso.springboot.app.springboot_crud.repositories.ProductRepository;
import com.manuel.curso.springboot.app.springboot_crud.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productDb = productRepository.findById(id);
        if(productDb.isPresent()) {
            productDb.get().setName(product.getName());
            productDb.get().setPrice(product.getPrice());
            productDb.get().setDescription(product.getDescription());
            return Optional.of(productRepository.save(productDb.get()));
        }
        return productDb;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = productRepository.findById(id);
        productDb.ifPresent(p -> {
            productRepository.delete(p);
        });
        return productDb;
    }

    

}
