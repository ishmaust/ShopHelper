package user.ishmaust.shophelper.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.dto.ProductDto;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.ProductServiceImpl;
import user.ishmaust.shophelper.servicies.interfacies.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping(value = "/product")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductServiceImpl productService) {
    this.productService = productService;
  }

  //PUT calls
  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> addNewProduct(@RequestBody @Valid ProductDto productDto) {
    return new ResponseEntity<>(productService.addNewProduct(productDto), HttpStatus.OK);
  }

  //PATCH calls
  @PatchMapping(value = "/{id:[\\d]+}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
      @RequestBody @Valid ProductDto productDto) {
    return new ResponseEntity<>(productService.updateProduct(productDto, id), HttpStatus.OK);
  }

  //DELETE calls
  @DeleteMapping(value = "/{id:[\\d]+}")
  public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
    return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
  }

  //GET calls
  @GetMapping(value = "/{id:[\\d]+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> getProductsByFilter(@RequestParam(value = "name", defaultValue = "") String name) {
    return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.OK);
  }

}
