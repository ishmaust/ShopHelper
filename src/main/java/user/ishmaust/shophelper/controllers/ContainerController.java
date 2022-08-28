package user.ishmaust.shophelper.controllers;

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
import org.springframework.web.bind.annotation.RestController;
import user.ishmaust.shophelper.repositories.entity.Container;
import user.ishmaust.shophelper.repositories.entity.Product;
import user.ishmaust.shophelper.servicies.ContainerServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/container")
public class ContainerController {
  private final ContainerServiceImpl containerService;

  @Autowired
  public ContainerController(ContainerServiceImpl containerService) {
    this.containerService = containerService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Container> addContainer(@Valid @RequestBody Container bodyContainer) {
    return new ResponseEntity<>(containerService.addEntity(bodyContainer), HttpStatus.CREATED);
  }

  @GetMapping(value = "/{id}/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<Product>> getAllFromContainerById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(containerService.getAllProductsFromContainerById(id), HttpStatus.OK);
  }
}
