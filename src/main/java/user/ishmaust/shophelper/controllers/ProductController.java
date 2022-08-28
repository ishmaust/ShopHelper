package user.ishmaust.shophelper.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.ContainerOperationService;
import user.ishmaust.shophelper.servicies.ProductServiceImpl;
import user.ishmaust.shophelper.servicies.ProductUpdateService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/product")
public class ProductController {

  private final ProductServiceImpl productServiceImpl;
  private final ProductUpdateService productUpdateService;

  @Autowired
  public ProductController(ProductServiceImpl productServiceImpl,
      ContainerOperationService containerService, ProductUpdateService productUpdateService) {
    this.productServiceImpl = productServiceImpl;
    this.productUpdateService = productUpdateService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> addNewProduct(@Valid @RequestBody Product bodyProduct) {
    if(bodyProduct.getCount() == 0) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(productServiceImpl.addEntity(bodyProduct), HttpStatus.CREATED);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> updateProductContainer(@PathVariable("id") Long id,
      @RequestParam(name = "container") String containerId) {
    Product product = productUpdateService.updateProductContainer(id, containerId);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
    Optional<Product> product = productServiceImpl.findById(id);

    return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Product>> getAllProducts() {
    return new ResponseEntity<>(productServiceImpl.getAllProduct(), HttpStatus.OK);
  }

  //FIXME: Change "/name" to enum with entity field name and get user opportunity choose way for collect data
  @GetMapping(value = "/all/name", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<String>> getAllProductsName() {
    return new ResponseEntity<>(productServiceImpl.getAllProductName(), HttpStatus.OK);
  }


}
