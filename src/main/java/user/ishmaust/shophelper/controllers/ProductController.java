package user.ishmaust.shophelper.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.ProductOperationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
public class ProductController {

  private final ProductOperationService productOperationService;

  @Autowired
  public ProductController(ProductOperationService productOperationService) {
    this.productOperationService = productOperationService;
  }

  @GetMapping(path = "/product/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
    Optional<Product> product = productOperationService.findById(id);

    return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
