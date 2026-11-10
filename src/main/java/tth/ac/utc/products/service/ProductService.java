package tth.ac.utc.products.service;

import java.util.List;
import java.util.Optional;
import tth.ac.utc.products.model.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByName(String keyword);

    Product save(Product product);
}
