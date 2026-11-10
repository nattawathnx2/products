package tth.ac.utc.products.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tth.ac.utc.products.model.Product;
import  java.text.NumberFormat;
import tth.ac.utc.products.service.ProductService;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ProductService productService;
    private final NumberFormat priceFormater;

    @GetMapping("/report")
    public  Map<String, Object> report() {
        List<Product> all = productService.findAll();
        double total = all.stream().mapToDouble(Product::getTotalValue).sum();
        return Map.of("count ", all.size(), "totalValue", priceFormater.format(total));
    }
}
