package tth.ac.utc.products.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tth.ac.utc.products.model.Product;
import tth.ac.utc.products.service.InMemoryProductService;
import tth.ac.utc.products.service.ProductService;

@RestController
public class ProductController {
    @GetMapping("/")
    public String home(){
        return "Hello, Spring Boot!";
    }

    @GetMapping("/about")
    public String about(){
        return "This is about page...";
    }

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return productService.findAll();
    }
    @GetMapping("/product")
    public Product one(@RequestParam Long id) {
        return productService.findById(id).orElse(null);
    }

    @GetMapping("/products/s")
    public List<Product> search(@RequestParam String keyword) {
        return productService.findByName(keyword);
    }

    @GetMapping("/product/add")
    public Product add(@RequestParam String name,
                       @RequestParam double price,
                       @RequestParam int stock) {
        return productService.save(new Product(null, name, price, stock));
    }
}
