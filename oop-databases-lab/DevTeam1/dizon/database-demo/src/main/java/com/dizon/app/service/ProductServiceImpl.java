package com.dizon.springboot.service;

import com.dizon.springboot.dto.ProductDTO;
import com.dizon.springboot.entity.Product;
import com.dizon.springboot.exception.DuplicateResourceException;
import com.dizon.springboot.exception.ResourceNotFoundException;
import com.dizon.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        return toDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productRepository.existsByName(productDTO.getName())) {
            throw new DuplicateResourceException("A product with name '" + productDTO.getName() + "' already exists.");
        }
        Product product = toEntity(productDTO);
        Product saved = productRepository.save(product);
        return toDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));

        if (productDTO.getName() != null) existing.setName(productDTO.getName());
        if (productDTO.getDescription() != null) existing.setDescription(productDTO.getDescription());
        if (productDTO.getPrice() != null) existing.setPrice(productDTO.getPrice());
        if (productDTO.getStock() != null) existing.setStock(productDTO.getStock());
        if (productDTO.getCategory() != null) existing.setCategory(productDTO.getCategory());

        return toDTO(productRepository.save(existing));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product", id);
        }
        productRepository.deleteById(id);
    }

    private ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }

    private Product toEntity(ProductDTO dto) {
        return new Product(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStock(),
                dto.getCategory()
        );
    }
}