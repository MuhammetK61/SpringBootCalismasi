package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Sınıfın istemci tarafından yapılan istekleri işlemesine izin verir.
@RestController
// Web isteklerini belirli işleyici sınıflarına ve yöntemlerine eşlemek ve web kaynaklarını adreslenebilir hale getirmek için kullanılır.
@RequestMapping("/api/products")
public class ProductsController {



    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //@GetMapping açıklamalı yöntemler, verilen URI ifadesiyle eşleşen HTTP GET isteklerini işler.
    @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(Product product){
        return new Result(true, "Ürün eklendi");
    }
}
